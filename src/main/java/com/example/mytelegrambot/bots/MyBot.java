package com.example.mytelegrambot.bots;

import Services.MessageService;
import Services.ServiceFactory;
import com.example.mytelegrambot.models.Role;
import commands.abstr.Command;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.Optional;

@Component
public class MyBot extends TelegramLongPollingBot {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());
    protected final List<Command> commands;
    protected final ServiceFactory serviceFactory;
    private final MessageService messageService;
    public MyBot(List<? extends Command> commands, ServiceFactory serviceFactory) {

        if (commands != null)
            this.commands = (List<Command>) commands;

        else throw new NullPointerException("Commands list cannot be null");
            LoggerFactory.getLogger(getClass()).info("Setting up bot messageService");
            this.serviceFactory = serviceFactory;
            messageService = serviceFactory.getMessageService(this);
        }



    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()) {
            handleMessage(update.getMessage());
            Message message = update.getMessage();

            if(message.equals("/start")){
                System.out.println("Successfully started!");
                Message sendMessage = execute(
                SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Successfully started!").build());
            }

        }




    }
    @SneakyThrows
    private void handleMessage(Message message) {
        System.out.println(message);
        if (message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> commandEntity =
                    message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
            if(commandEntity.isPresent()) {
                String command =
                        message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
                if ("/login".equals(command)) {

                    Message sendMessage = execute(
                            SendMessage.builder()
                                    .chatId(message.getChatId().toString())
                                    .text("Who are you? \n\n" +
                                            "Admin\n" +
                                            "Moderator\n" +
                                            "Worker").build());
                }
            }
        }

        if(message.getText().equals("/start")){
            System.out.println("Successfully started!");
            Message sendMessage = execute(
                    SendMessage.builder()
                            .chatId(message.getChatId().toString())
                            .text("Successfully started!").build());
        }

        if(message.getText().equals("Admin")){
            Message sendMessage = execute(
                    SendMessage.builder()
                            .chatId(message.getChatId().toString())
                            .text("Hello Admin! \n\n" +
                                    "Statistics").build());
        }
        if(message.getText().equals("Moderator")){
            Message sendMessage = execute(
                    SendMessage.builder()
                            .chatId(message.getChatId().toString())
                            .text("Hello Moderator!\n\n" +
                                    "Send the tasks to workers").build());
        }if(message.getText().equals("Worker")){
            Message sendMessage = execute(
                    SendMessage.builder()
                            .chatId(message.getChatId().toString())
                            .text("Hello Worker!").build());
        }

    }

    public void handleCallbackQuery(CallbackQuery callbackQuery){
    }

    public Role getBotUserRole(){return Role.ROLE_ADMIN;}

    @Override
    public String getBotUsername() {
        return "@sca19b_bot";
    }

    @Override
    public String getBotToken() {
        return "5397233464:AAFXgvdDiz55DxMP7HRc2-jEtnbz0qTKi2I";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !obj.getClass().equals(getClass())) return false;
        MyBot o = (MyBot) obj;
        return getBotUsername().equals(o.getBotUsername());
    }
}
