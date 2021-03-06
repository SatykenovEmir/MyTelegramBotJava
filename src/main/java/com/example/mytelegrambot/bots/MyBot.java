package com.example.mytelegrambot.bots;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MyBot extends TelegramLongPollingBot {

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        /*ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = objectWriter.writeValueAsString(update);
        FileWriter fileWriter = new FileWriter("lastUpdate.json");
        fileWriter.write(json);
        fileWriter.flush();

        if (update.hasCallbackQuery()) {

            Message message = update.getCallbackQuery().getMessage();
            SendMessage.builder()
                    .chatId(message.getChatId().toString())
                    .text("You pressed a button").build();

            EditMessageText editMessageText = EditMessageText.builder()
                    .chatId(getWebhookInfo().getLastErrorMessage())
                    .messageId(update.getUpdateId())
                    .text("Edit message")
                    .replyMarkup(InlineKeyboardMarkup.builder().build())
                    .build();
            DeleteMessage.builder()
                    .chatId(getWebhookInfo().getLastErrorMessage())
                    .messageId(update.getUpdateId());
            execute(editMessageText);
        }
        */
        if(update.hasMessage()) {
            handleMessage(update.getMessage());
            Message message = update.getMessage();
            if(message.hasText()){
                Message sendMessage = execute(
                        SendMessage.builder()
                                .chatId(message.getChatId().toString())
                                .text("Please press /login").build()
                );
            }
        }


    }
    @SneakyThrows
    private void handleMessage(Message message) {
        System.out.println(message);
        if (message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> commandEntity =
                    message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
            if(commandEntity.isPresent()){
                String command =
                        message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
                if ("/login".equals(command)) {
                    List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
                    for (Buttons buttons1 : Buttons.values()) {
                        buttons.add(List.of(
                                InlineKeyboardButton.builder().text(buttons1.name()).callbackData("Admin" + buttons1).build()
                                /*InlineKeyboardButton.builder().text(buttons1.name()).callbackData("Moderator" + buttons1).build()*/));
                    }
                    execute(
                            SendMessage.builder()
                                    .text("Who are you?")
                                    .chatId(message.getChatId().toString())
                                    .replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build())
                                    .build());
                }
            }
        }

    }

    public void handleCallbackQuery(CallbackQuery callbackQuery){
    }

    @Override
    public String getBotUsername() {
        return "@sca19b_bot";
    }

    @Override
    public String getBotToken() {
        return "5397233464:AAFXgvdDiz55DxMP7HRc2-jEtnbz0qTKi2I";
    }
}
