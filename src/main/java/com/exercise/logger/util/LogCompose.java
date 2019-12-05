/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.logger.util;

import com.exercise.logger.enums.LogType;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Date;

/**
 *
 * @author pedro
 */
public class LogCompose {

    public static String compose(LogType type, String message) {
        return MessageFormat.format("{0}\t{1}\t{2}", type.getType(),
                DateFormat.getDateInstance(DateFormat.LONG).format(new Date()),
                message);
    }
}
