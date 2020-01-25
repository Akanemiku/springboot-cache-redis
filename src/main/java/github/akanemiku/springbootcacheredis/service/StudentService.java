package github.akanemiku.springbootcacheredis.service;

import github.akanemiku.springbootcacheredis.entity.Student;
import github.akanemiku.springbootcacheredis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    @Cacheable(value = "student",unless = "#result == null")
    public Student findById(Integer id) {
        return repository.findById(id).get();
    }

    @CachePut(value = "student",key = "#student.id")
    public Student save(Student student){
        return repository.save(student);
    }

    @CachePut(value = "student", key = "#student.id")
    public Student update(Student student) {
        return repository.save(student);
    }

    @CacheEvict(value = "student")
    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }


}
