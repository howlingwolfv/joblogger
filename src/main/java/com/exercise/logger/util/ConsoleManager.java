/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.logger.util;

import com.exercise.logger.config.LogConfiguration;
import java.io.Serializable;
import java.util.logging.ConsoleHandler;

/**
 *
 * @author pedro
 */
public class ConsoleManager implements Serializable {

    private static final long serialVersionUID = 1L;

    private static ConsoleManager instance = null;

    private ConsoleManager(LogConfiguration configuration) {
        super();
    }

    public static ConsoleManager getInstance(LogConfiguration configuration) {
        if (instance == null) {
            instance = new ConsoleManager(configuration);
        }
        return instance;
    }

    public ConsoleHandler getConsoleHandler() {
        return new ConsoleHandler();
    }

}
