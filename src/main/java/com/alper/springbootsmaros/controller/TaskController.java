package com.alper.springbootsmaros.controller;


import com.alper.springbootsmaros.model.Task;
import com.alper.springbootsmaros.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/maroapi")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> findAll(){
        try {
            List<Task> tasks = taskRepository.findAll();
            if (tasks.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(tasks , HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable("id") long id){
        Optional<Task> taskData = taskRepository.findById(id);
        if (taskData.isPresent()){
            return new ResponseEntity<>(taskData.get() , HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        try {
            Task _task = taskRepository.save(new Task(task.getName() , task.getDescription()));
            return new ResponseEntity<>(_task , HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") long id , @RequestBody Task task){
        Optional<Task> taskData = taskRepository.findById(id);
        if (taskData.isPresent()){
            Task _task = taskData.get();
            _task.setName(task.getName());
            _task.setDescription(task.getDescription());

            return new ResponseEntity<>(taskRepository.save(_task) , HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<HttpStatus> deleteTaskByID(@PathVariable("id") long id){
        try {
            taskRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tasks")
    public ResponseEntity<HttpStatus> deleteAllTasks(){
        try {
            taskRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
