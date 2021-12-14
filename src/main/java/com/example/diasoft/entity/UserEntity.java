package com.example.diasoft.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(name = "userid", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "userIdSeq", sequenceName = "user_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeq")
    private Long userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "pass", nullable = false)
    private String pass;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private List<ToDoEntity> todos;
}
