package by.it_academy.agency.commands;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request);
}
