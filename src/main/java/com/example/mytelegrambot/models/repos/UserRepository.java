package com.example.mytelegrambot.models.repos;

import com.example.mytelegrambot.models.TgUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<TgUser,Long> {
}
