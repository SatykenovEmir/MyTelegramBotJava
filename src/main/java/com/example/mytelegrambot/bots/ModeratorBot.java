package com.example.mytelegrambot.bots;

import Services.ServiceFactory;
import com.example.mytelegrambot.models.Role;
import commands.abstr.ModeratorCommand;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("moderatorBot")
public class ModeratorBot extends MyBot{

    public ModeratorBot(List<ModeratorCommand> commands, ServiceFactory serviceFactory) {
        super(commands, serviceFactory);
    }

    @Override
    public Role getBotUserRole(){return Role.ROLE_MODERATOR;}

    @Override
    public String getBotUsername() {
        return "@sca19b_bot";
    }

    @Override
    public String getBotToken() {
        return "397233464:AAFXgvdDiz55DxMP7HRc2-jEtnbz0qTKi2I";
    }

}
