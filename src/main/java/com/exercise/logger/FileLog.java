/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.logger;

import com.exercise.logger.config.LogConfiguration;
import com.exercise.logger.enums.LogType;
import com.exercise.logger.util.FileManager;
import com.exercise.logger.util.LogCompose;
import java.util.logging.Level;
import org.apache.logging.log4j.util.Strings;

/**
 *
 * @author pedro
 */
public class FileLog implements Log {

    private FileManager manager;

    public FileLog(LogConfiguration configuration) {
        this.manager = new FileManager(configuration);
        logger.addHandler(this.manager.getFileHandler());
    }

    @Override
    public void createMessage(String message) {
        if (Strings.isBlank(message)) {
            throw new RuntimeException("Message must be specified");
        }
        logger.log(Level.INFO, LogCompose.compose(LogType.FILE, message));
    }

    @Override
    public void createWarning(String message) {
        if (Strings.isBlank(message)) {
            throw new RuntimeException("Warning must be specified");
        }
        logger.log(Level.WARNING, LogCompose.compose(LogType.FILE, message));
    }

    @Override
    public void createError(String message) {
        if (Strings.isBlank(message)) {
            throw new RuntimeException("Error must be specified");
        }
        logger.log(Level.SEVERE, LogCompose.compose(LogType.FILE, message));
    }

}
