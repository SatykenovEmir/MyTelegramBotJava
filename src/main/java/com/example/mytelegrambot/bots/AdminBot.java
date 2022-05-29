package com.example.mytelegrambot.bots;

import Services.ServiceFactory;
import com.example.mytelegrambot.models.Role;
import commands.abstr.AdminCommand;
import commands.abstr.Command;


import java.util.List;

public class AdminBot extends MyBot {

    public AdminBot(List<AdminCommand> commands,
                    ServiceFactory serviceFactory) {
        super(commands,serviceFactory);

    }

    @Override
    public Role getBotUserRole(){return Role.ROLE_ADMIN;}

    @Override
    public String getBotUsername() {
        return "@sca19b_bot";
    }

    @Override
    public String getBotToken() {
        return "397233464:AAFXgvdDiz55DxMP7HRc2-jEtnbz0qTKi2I";
    }

}
