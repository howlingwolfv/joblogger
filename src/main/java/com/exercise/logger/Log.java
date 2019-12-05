/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.logger;

import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public interface Log {

    public static final Logger logger = Logger.getLogger("Logger");

    public void createMessage(String message);

    public void createWarning(String message);

    public void createError(String message);

}
