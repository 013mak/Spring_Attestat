package com.mak.ht.model;



import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Tasks {

    enum TaskStatus {
        NOT_STARTED, IN_PROGRESS, COMPLETED;
    }

    public Tasks() {
        startTime= LocalDateTime.now();
    }

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(nullable = true)
    private String title;
    @Column(nullable = true)
    private String description;
    @Column(nullable = true)
    private String priority;
    @Column(nullable = true)
    private String status;

private LocalDateTime startTime;
    @Column(nullable = true)
    private String worker;

}
