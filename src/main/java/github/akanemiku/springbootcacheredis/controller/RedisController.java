package github.akanemiku.springbootcacheredis.controller;

import github.akanemiku.springbootcacheredis.entity.Student;
import github.akanemiku.springbootcacheredis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private StudentService service;

    @GetMapping("/list")
    public ResponseEntity getStudent(@RequestParam("id") Integer id){
        Student student = service.findById(id);
        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/insert")
    public ResponseEntity insertStudent(){
        Student student = new Student();
        student.setNo("0000");
        student.setName("test");
        student.setHobby("test");
        return ResponseEntity.ok().body(service.save(student));
    }

    @GetMapping("/delete")
    public void deleteStudent(@RequestParam("id") Integer id){
        service.deleteUser(id);
    }
}
