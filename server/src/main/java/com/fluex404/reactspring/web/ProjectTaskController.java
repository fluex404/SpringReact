package com.fluex404.reactspring.web;

import com.fluex404.reactspring.domain.ProjectTask;
import com.fluex404.reactspring.repository.ProjectTaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ProjectTaskController {
    @Autowired
    private ProjectTaskDao dao;

    // Save or Update
    @PostMapping
    public ResponseEntity<?> saveOrUpdate(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {
        if(result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        if(projectTask.getStatus() == null || projectTask.equals("")) {
            projectTask.setStatus("TO_DO");
        }
        return new ResponseEntity<ProjectTask>(dao.save(projectTask), HttpStatus.CREATED);
    }
    // Find All Data
    @GetMapping
    public List<ProjectTask> findAll() {
        return dao.findAll();
    }
    // Find By Id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable("id") ProjectTask projectTask) {
        // dao.findById(id).get();
        return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK);
    }
    // Delete By Id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@Valid @PathVariable("id") ProjectTask projectTask) {
        dao.delete(projectTask);
        return new ResponseEntity<String>("the data have been removed!", HttpStatus.OK);
    }
}
