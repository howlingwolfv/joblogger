/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.logger;

import com.exercise.logger.config.LogConfiguration;
import com.exercise.logger.enums.LogType;
import com.exercise.logger.util.ConsoleManager;
import com.exercise.logger.util.LogCompose;
import java.util.logging.Level;
import org.apache.logging.log4j.util.Strings;

/**
 *
 * @author pedro
 */
public class ConsoleLog implements Log {

    private ConsoleManager manager;

    public ConsoleLog(LogConfiguration configuration) {
        this.manager = ConsoleManager.getInstance(configuration);
        logger.addHandler(this.manager.getConsoleHandler());
    }

    @Override
    public void createMessage(String message) {
        if (Strings.isBlank(message)) {
            throw new RuntimeException("Message must be specified");
        }
        logger.log(Level.INFO, LogCompose.compose(LogType.CONSOLE, message));
    }

    @Override
    public void createWarning(String message) {
        if (Strings.isBlank(message)) {
            throw new RuntimeException("Message must be specified");
        }
        logger.log(Level.WARNING, LogCompose.compose(LogType.CONSOLE, message));
    }

    @Override
    public void createError(String message) {
        if (Strings.isBlank(message)) {
            throw new RuntimeException("Error must be specified");
        }
        logger.log(Level.SEVERE, LogCompose.compose(LogType.CONSOLE, message));
    }

}
