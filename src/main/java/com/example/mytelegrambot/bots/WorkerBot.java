package com.example.mytelegrambot.bots;

import Services.ServiceFactory;
import com.example.mytelegrambot.models.Role;
import com.fasterxml.jackson.databind.json.JsonMapper;
import commands.abstr.Command;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WorkerBot extends MyBot {


    protected WorkerBot(
            List<Command> commands, ServiceFactory serviceFactory) {
        super(commands, serviceFactory);
    }


    public Role getBotUserRole() {
        return Role.ROLE_WORKER;
    }
    @Override
    public String getBotUsername() {
        return "@sca19b_bot";
    }

    @Override
    public String getBotToken() {
        return "5397233464:AAFXgvdDiz55DxMP7HRc2-jEtnbz0qTKi2I";
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            JsonMapper jsonMapper = new JsonMapper();
            String json = jsonMapper.writeValueAsString(update);
            Files.writeString(Path.of("jsons", "result.json"), json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
