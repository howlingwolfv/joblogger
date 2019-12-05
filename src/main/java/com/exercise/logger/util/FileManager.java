/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.logger.util;

import com.exercise.logger.config.LogConfiguration;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.FileHandler;

/**
 *
 * @author pedro
 */
public class FileManager implements Serializable {

    private static final long serialVersionUID = 1L;

    private LogConfiguration config;

    public FileManager(LogConfiguration config) {
        super();
        this.config = config;
    }

    public File getLogFile() {
        File logFile = new File(this.config.getProperty("logger.logFilePath"));
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException("Error create new log file.", ex);
            }
        }
        return logFile;
    }

    public FileHandler getFileHandler() {
        try {
            getLogFile();
            return new FileHandler(this.config.getProperty("logger.logFilePath"));
        } catch (SecurityException | IOException ex) {
            throw new RuntimeException("Error get file handler.", ex);
        }
    }

}
