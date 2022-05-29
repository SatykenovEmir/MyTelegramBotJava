package com.example.mytelegrambot;


import com.example.mytelegrambot.bots.Buttons;
import com.example.mytelegrambot.models.Role;
import com.example.mytelegrambot.models.TgUser;
import com.example.mytelegrambot.models.repos.TaskRepository;
import com.example.mytelegrambot.models.repos.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class MyTelegramBotApplication {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner bootstrap() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                TgUser tgUser = new TgUser();
                tgUser.setId(620628187L);
                tgUser.setFullName("Mr.Javlon");
                tgUser.setRole(Role.ROLE_ADMIN);

                userRepository.save(tgUser);
            }
        };
    }

    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(MyTelegramBotApplication.class, args);
    }


}
/*
@Component
public class InlineKeyboardMaker {

    public InlineKeyboardMarkup getInlineMessageButtonsWithTemplate(String prefix, boolean isUserDictionaryNeed) {
        InlineKeyboardMarkup inlineKeyboardMarkup = getInlineMessageButtons(prefix, isUserDictionaryNeed);
        inlineKeyboardMarkup.getKeyboard().add(getButton(
                "Шаблон",
                prefix + CallbackDataPartsEnum.TEMPLATE.name()
        ));
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup getInlineMessageButtons(String prefix, boolean isUserDictionaryNeed) {
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        for (DictionaryResourcePathEnum dictionary : DictionaryResourcePathEnum.values()) {
            rowList.add(getButton(
                    dictionary.getButtonName(),
                    prefix + dictionary.name()
            ));
        }


        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    private List<InlineKeyboardButton> getButton(String buttonName, String buttonCallBackData) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(buttonName);
        button.setCallbackData(buttonCallBackData);

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(button);
        return keyboardButtonsRow;
    }
}*/
