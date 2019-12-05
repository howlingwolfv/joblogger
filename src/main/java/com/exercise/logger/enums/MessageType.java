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
public enum MessageType {

    MESSAGE(1, "message"),
    ERROR(2, "error"),
    WARNING(3, "warning");

    private int id;
    private String name;

    private MessageType(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
