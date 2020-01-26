package github.akanemiku.springbootcacheredis.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor//全参构造
@NoArgsConstructor//无参构造
@ToString//toString
@Entity
@Table(name = "student")
@ApiModel(value = "学生对象")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "学生id", notes = "主键自增", example = "1")
    private Integer id;

    @ApiModelProperty(value = "学生学号", example = "1000")
    private String no;

    @ApiModelProperty(value = "学生姓名", example = "小明")
    private String name;

    @ApiModelProperty(value = "学生爱好", example = "玩游戏")
    private String hobby;
}
