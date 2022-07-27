package com.alper.springbootsmaros.filter;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;





@Component
public class GoogleFilter implements Filter {


    @Override
    public void doFilter (ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {




        HttpServletResponse res = null;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        res = (HttpServletResponse) servletResponse;
        
        res.setHeader("Access-Control-Allow-Origin", "*");
        //res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, HEAD, OPTIONS, DELETE");
        res.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers , Google-Token");
        res.setHeader("Access-Control-Max-Age" , "86400");
        
        if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
            res.setStatus(200);
        }
        else {
            try {
        /*
        PrintWriter out = servletResponse.getWriter();
        */


                //Enumeration<String> headerNames = req.getHeaderNames();


                //System.out.println(servletRequest.getServerName());


                //System.out.println(req.getHeader("Google-Token"));


                GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                        // Specify the CLIENT_ID of the app that accesses the backend:
                        .setAudience(Collections.singletonList("218225500837-c6h9i9io5sctiuc8fskjjvhc135ofolj.apps.googleusercontent.com"))
                        // Or, if multiple clients access the backend:
                        //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
                        .build();


                //req.getHeader("Google-Token")
                //String idTokenString = "ya29.A0AVA9y1s884vEX99sc_YLeqMUcsz16dZ8IyLSYO73wb6UjPHIDIBLzDIKUAzX4hXjpmET3LbY4lHyK72RW0z6vplRgGdQnv8FgtRnvoC4Ws7rzDz5J5Xy87sMF5upwgt1pK7zwKDDSCz1O3kKHEy5oIX6RKCmtgYUNnWUtBVEFTQVRBU0ZRRTY1ZHI4T0VGbTBhTEJoVXdJeURPUlBPZXVZZw0165";


                //System.out.println("iki");
                System.out.println(servletRequest.getServerName());
                Enumeration<String> headerNames = req.getHeaderNames();
                System.out.println(req.getHeader("google-token"));
                System.out.println(req.getHeader("google-token"));
                String googleToken = req.getHeader("google-token");


                GoogleIdToken idToken = verifier.verify(googleToken);

                if (idToken != null) {
                    Payload payload = idToken.getPayload();
                    // Print user identifier
                    String userId = payload.getSubject();
                    String userName = (String) payload.get("name");
                    String email = (String) payload.get("email");
                    System.out.println("User ID: " + userId + "\n" + "Name : " + userName + "\n" + email);
                    res.setStatus(200);
                } else {
                    res.setStatus(403);

                    System.out.println("Invalid Id Token");
                    return;
                }




        /*
        int token = Integer.parseInt(req.getParameter("id"));
        if(token>2205)
            filterChain.doFilter(servletRequest , servletResponse);
        else
        */

                filterChain.doFilter(servletRequest, servletResponse);
            } catch (Exception e) {
                System.out.println("Something wrong! :/");
                res.setStatus(403);
            }
        }


    }

}
