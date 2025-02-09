package github.akanemiku.springbootcacheredis.repository;

import github.akanemiku.springbootcacheredis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, CrudRepository<Student,Integer> {
    @Query(nativeQuery = true, value = "select * from student")
    List<Student> findAll();
}
