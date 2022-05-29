package com.example.mytelegrambot.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String taskDetails;

    @ManyToOne
    private TgUser createdBy;

    @Enumerated(EnumType.STRING)
    private TaskState taskState;

    private LocalDateTime createdDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    public TgUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(TgUser createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
