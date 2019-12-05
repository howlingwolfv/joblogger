/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.logger.enums;

/**
 *
 * @author pedro
 */
public enum LogType {

    CONSOLE("console"),
    DATABASE("database"),
    FILE("file");

    private String type;

    private LogType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
