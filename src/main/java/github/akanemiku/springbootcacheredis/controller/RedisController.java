package github.akanemiku.springbootcacheredis.controller;

import github.akanemiku.springbootcacheredis.entity.Student;
import github.akanemiku.springbootcacheredis.service.StudentService;
import github.akanemiku.springbootcacheredis.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "测试模块", description = "测试对Redis的CRUD操作")
@RestController
public class RedisController {
    @Autowired
    private StudentService service;

    @ApiOperation(value = "根据学生id查询对应学生")
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "query", name = "id", value = "学生id", required = true,defaultValue = "1")
    )
    @GetMapping("/list")
    public ResponseEntity getStudent(@RequestParam("id") Integer id) {
        Student student = service.findById(id);
        return ResponseEntity.ok().body(student);
    }

    @ApiOperation(value = "插入学生",notes = "更新Redis")
    @GetMapping("/insert")
    public ResponseEntity insertStudent() {
        Student student = new Student();
        student.setNo("0000");
        student.setName("test");
        student.setHobby("test");
        return ResponseEntity.ok().body(service.save(student));
    }

    @ApiOperation(value = "根据学生id删除对应学生")
    @GetMapping("/delete")
    public void deleteStudent(@ApiParam(name = "id", value = "学生id", required = true) @RequestParam("id") Integer id) {
        service.deleteUser(id);
    }

    @ApiOperation(value = "根据学生id查询对应学生，返回学生对象")
    @GetMapping("/find")
    public Student findStudentById(@ApiParam(name = "id", value = "学生id") @RequestParam("id") Integer id){
        Student student = service.findById(id);
        return student;
    }

    @ApiOperation(value = "根据学生id查询对应学生，返回VO")
    @GetMapping("/find2")
    public ResultUtil.ResultVO findStudentById2(@ApiParam(name = "id", value = "学生id") @RequestParam("id") Integer id){
        Student student = service.findById(id);
        return ResultUtil.success(student);
    }
}
