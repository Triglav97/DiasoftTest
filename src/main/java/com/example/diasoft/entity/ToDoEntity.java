package com.example.diasoft.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class ToDoEntity {
    @Id
    @Column(name = "todoid", nullable = false)
    @SequenceGenerator(name = "toDoIdSeq", sequenceName = "todo_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "toDoIdSeq")
    private Long todoId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "completed", nullable = false)
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userid;

}
