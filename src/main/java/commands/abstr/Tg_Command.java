package commands.abstr;

import Services.ServiceFactory;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class Tg_Command {
    protected final Log LOG = LogFactory.getLog(getClass());
    protected final ServiceFactory serviceFactory;

    private final String commandName;

    public Tg_Command(String commandName, ServiceFactory factory) {
        LogFactory.getLog(getClass()).trace("Command created:" + commandName);
        this.commandName = commandName;
        this.serviceFactory = factory;
    }

    public String getCommandName() {
        return commandName;
    }
}
