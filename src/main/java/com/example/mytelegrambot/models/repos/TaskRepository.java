package com.example.mytelegrambot.models.repos;

import com.example.mytelegrambot.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Long> {
}
