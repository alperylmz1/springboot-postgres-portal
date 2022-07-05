package com.alper.springbootsmaros.controller;

import com.alper.springbootsmaros.model.Timesheet;
import com.alper.springbootsmaros.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/maroapi")
public class TimesheetController {

    @Autowired
    TimesheetRepository timesheetRepository;

    @GetMapping("/timesheets")
    public ResponseEntity<List<Timesheet>> findAll(){
        try {
            List<Timesheet> timesheets = timesheetRepository.findAll();
            if (timesheets.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(timesheets , HttpStatus.OK);

            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/timesheets/{id}")
    public ResponseEntity<Timesheet> getTimesheetsById(@PathVariable("id") long id){
        Optional<Timesheet> timesheetData = timesheetRepository.findById(id);
        if (timesheetData.isPresent()){
            return new ResponseEntity<>(timesheetData.get() , HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/timesheets/user/{userID}")
    public ResponseEntity<List<Timesheet>> findByUserId(@PathVariable("userID") Long userID){
        try {
            List<Timesheet> timesheets = timesheetRepository.findAllByUserId(userID);

                if (timesheets.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                else{
                    return new ResponseEntity<>(timesheets , HttpStatus.OK);
                }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping("/timesheets")
    public ResponseEntity<Timesheet> createTimesheet(@RequestBody Timesheet timesheet){
        try {
            Timesheet _timesheet = timesheetRepository.save(new Timesheet(timesheet.getUserID(),timesheet.getTimesheetdate(),timesheet.getDuration(),timesheet.getLocation(),timesheet.getTaskID(), timesheet.getClientID(),timesheet.getDescription() , timesheet.getCreateDate() , timesheet.getCreateUser()));
            return new ResponseEntity<>(_timesheet , HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }











    @PutMapping("/timesheets/{id}")
    public ResponseEntity<Timesheet> updateTimesheet(@PathVariable("id") long id , @RequestBody Timesheet timesheet){
        Optional<Timesheet> timesheetData = timesheetRepository.findById(id);
        if (timesheetData.isPresent()){
            Timesheet _timesheet = timesheetData.get();
            _timesheet.setUserID(timesheet.getUserID());
            _timesheet.setTimesheetdate(timesheet.getTimesheetdate());
            _timesheet.setDuration(timesheet.getDuration());
            _timesheet.setLocation(timesheet.getLocation());
            _timesheet.setTaskID(timesheet.getTaskID());
            _timesheet.setClientID(timesheet.getClientID());
            _timesheet.setDescription(timesheet.getDescription());
            _timesheet.setCreateDate(timesheet.getCreateDate());
            _timesheet.setCreateUser(timesheet.getCreateUser());

            return new ResponseEntity<>(timesheetRepository.save(_timesheet) , HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/timesheets/{id}")
    public ResponseEntity<HttpStatus> deleteTimesheet(@PathVariable("id") long id){
        try {
            timesheetRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/timesheets")
    public ResponseEntity<HttpStatus> deleteAllTimesheets(){
        try {
            timesheetRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
