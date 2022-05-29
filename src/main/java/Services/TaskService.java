package Services;

import com.example.mytelegrambot.models.Task;
import com.example.mytelegrambot.models.TgUser;

import java.util.Set;

public interface TaskService {
    Task createTask(TgUser user, String taskDetails);

    Task createTask(Long userId, String taskDetails);

    Set<Task> getActiveTasks();

    Task getTask(long taskId);

    void cancelTask(Long taskId,TgUser user);

    void revokeTaskFromUser(Task task);
}
