package Services;

import com.example.mytelegrambot.bots.*;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

public class ServiceFactory {
    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier("defaultCommandsService")
    private CommandsService commandsService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private TgDataService tgDataService;

    @Bean
    @Scope("prototype")
    @Lazy
    public MessageService getMessageService(MyBot bot) {
        return new TgMessageService().setBot(bot);
    }

    @Bean
    @Scope("prototype")
    @Lazy
    public IMessage iMessage(String key) {
        return null;/*new IMessage(key);*/
    }

    public CommandsService getCommandsService() {
        return commandsService;
    }

    public UserService getUserService() {
        return userService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public TgDataService getTgService() {
        return tgDataService;
    }
}
