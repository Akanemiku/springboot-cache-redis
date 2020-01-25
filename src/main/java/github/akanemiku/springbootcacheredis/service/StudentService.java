package github.akanemiku.springbootcacheredis.service;

import github.akanemiku.springbootcacheredis.entity.Student;
import github.akanemiku.springbootcacheredis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> findAll() {
        return repository.findAll();
    }
}
