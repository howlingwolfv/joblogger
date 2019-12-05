/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.logger.config;

import java.io.Serializable;

/**
 *F
 * @author pedro
 */
public class LogConfiguration implements Serializable {

    private static final long serialVersionUID = 1L;

    public String getProperty(final String property) {
        String message = null;
        switch (property) {
            case "logger.logFilePath":
                message = "./data/logFile.txt";
                break;
            case "logger.bd.userName":
                message = "root";
                break;
            case "logger.bd.password":
                message = "root";
                break;
            case "logger.bd.jdbcDriver":
                message = "org.h2.Driver";
                break;
            case "logger.bd.dbUrl":
                message = "jdbc:h2:./data/loggerDB";
                break;
            default:
                break;
        }

        return message;
    }
}
