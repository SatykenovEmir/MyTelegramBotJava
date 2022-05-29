package Services;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

import java.util.Map;

public interface MessageService {
    boolean sendMessage(String to, String message);
    boolean sendMessage(String to, String message, ReplyKeyboard replyKeyboard);

    boolean sendPermissionDeniedMessage(String to);

    Message sendCallBackQueryMessage(String to, String message, Map<String,String> keyboards);

    Message sendCallBackQueryMessage(String to, String message, int columnNumber, Map<String, String> keyboards);
}
