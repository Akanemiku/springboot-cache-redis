package github.akanemiku.springbootcacheredis.entity;

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
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String no;
    private String name;
    private String hobby;
}
