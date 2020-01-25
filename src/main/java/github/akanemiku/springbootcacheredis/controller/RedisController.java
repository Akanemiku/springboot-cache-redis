package github.akanemiku.springbootcacheredis.controller;

import github.akanemiku.springbootcacheredis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private StudentService service;

    @GetMapping("/list")
    public ResponseEntity getAllStudent(){
        return ResponseEntity.ok().body(service.findAll());
    }
}
