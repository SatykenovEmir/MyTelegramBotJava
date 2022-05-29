package commands.abstr;

import com.example.mytelegrambot.bots.MyBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command{
    boolean execute(Update update, MyBot bot);
}
