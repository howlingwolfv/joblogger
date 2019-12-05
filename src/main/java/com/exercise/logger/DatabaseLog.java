/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.logger;

import com.exercise.logger.config.LogConfiguration;
import com.exercise.logger.enums.LogType;
import com.exercise.logger.enums.MessageType;
import com.exercise.logger.util.DatabaseManager;
import com.exercise.logger.util.LogCompose;
import org.apache.logging.log4j.util.Strings;

/**
 *
 * @author pedro
 */
public class DatabaseLog implements Log {

    private DatabaseManager manager;

    public DatabaseLog(LogConfiguration configuration) {
        this.manager = DatabaseManager.getInstance(configuration);
    }

    @Override
    public void createMessage(String message) {
        if (Strings.isBlank(message)) {
            throw new RuntimeException("Message must be specified");
        }
        this.manager.insertMessageDB(LogCompose.compose(LogType.DATABASE, message), MessageType.MESSAGE.getId());
    }

    @Override
    public void createWarning(String message) {
        if (Strings.isBlank(message)) {
            throw new RuntimeException("Warning must be specified");
        }
        this.manager.insertMessageDB(LogCompose.compose(LogType.DATABASE, message), MessageType.WARNING.getId());
    }

    @Override
    public void createError(String message) {
        if (Strings.isBlank(message)) {
            throw new RuntimeException("Error must be specified");
        }
        this.manager.insertMessageDB(LogCompose.compose(LogType.DATABASE, message), MessageType.ERROR.getId());
    }

}
