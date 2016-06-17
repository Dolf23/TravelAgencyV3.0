package by.it_academy.agency.commands.factory;

import by.it_academy.agency.commands.Command;
import by.it_academy.agency.commands.guest.LoginCommand;
import by.it_academy.agency.constants.Parameters;

import javax.servlet.http.HttpServletRequest;

public enum CommandFactory {
    INSTANCE;

    public Command defineCommand(HttpServletRequest request) {
        Command current = null;
        String commandName = request.getParameter(Parameters.COMMAND);
        try {
            CommandType type = CommandType.valueOf(commandName.toUpperCase());
            current = type.getCurrentCommand();
        } catch (NullPointerException e) {
            current = new LoginCommand();
        } catch (IllegalArgumentException e) {
            current = new LoginCommand();
        }

        return current;
    }

}