package by.it_academy.TravelAgency.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class logger {
    private static logger instanse;

    private logger() {
        new File("tomcat\\webapps\\Log.txt");
    }

    public static logger getInstanse() {
        logger localInstance = instanse;
        if (null == localInstance) {
            synchronized (logger.class) {
                localInstance = instanse;
                if (null == localInstance)
                    instanse = localInstance = new logger();
            }
        }
        return localInstance;
    }

    public static void writeLog(String logText) {
        try {
            getInstanse();
            PrintWriter printer = new PrintWriter(new FileWriter("tomcat\\webapps\\Log.txt", true));
            printer.println(new Date(System.currentTimeMillis()) + " : " + logText);
            printer.close();
        } catch (IOException e) {

        }
    }
}
