package github.akanemiku.springbootcacheredis;

import github.akanemiku.springbootcacheredis.entity.Student;
import github.akanemiku.springbootcacheredis.repository.StudentRepository;
import github.akanemiku.springbootcacheredis.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LettuceTest {
//    @Autowired
//    private RedisTemplate redisTemplate;

    @Autowired
    private StudentRepository repository;

    @Autowired
    private RedisUtil redis;

    @Test
    public void test(){
        Student student = repository.findAll().get(0);
        String key = "name";
//        redisTemplate.opsForValue().set(key, student.getName());
        redis.set(key, student.getName());
        // 获取数据
//        String value = (String) redisTemplate.opsForValue().get(key);
        String value = (String) redis.get(key);
        System.out.println("获取缓存中key为" + key + "的值为：" + value);

        key = "student1";
//        redisTemplate.opsForValue().set(key,student);
//        Student value2 = (Student) redisTemplate.opsForValue().get(key);
        redis.set(key,student);
        Student value2 = (Student) redis.get(key);
        System.out.println("获取缓存中key为" + key + "的值为：" + value2);

    }
}
