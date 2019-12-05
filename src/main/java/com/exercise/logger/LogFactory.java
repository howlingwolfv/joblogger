/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.logger;

import com.exercise.logger.config.LogConfiguration;
import com.exercise.logger.enums.LogType;

/**
 *
 * @author pedro
 */
public class LogFactory {

    public static Log getLogger(String type) {
        if (LogType.FILE.getType().equals(type)) {
            return new FileLog(new LogConfiguration());
        } else if (LogType.CONSOLE.getType().equals(type)) {
            return new ConsoleLog(new LogConfiguration());
        } else if (LogType.DATABASE.getType().equals(type)) {
            return new DatabaseLog(new LogConfiguration());
        } else {
            throw new RuntimeException("Logger type not valid!");
        }
    }

}
