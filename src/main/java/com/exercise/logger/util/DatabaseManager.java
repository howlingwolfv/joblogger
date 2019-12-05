/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.logger.util;

import com.exercise.logger.config.LogConfiguration;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pedro
 */
public class DatabaseManager implements Serializable {

    private static final long serialVersionUID = 1L;

    private static DatabaseManager instance = null;
    private LogConfiguration configuration;

    private DatabaseManager(LogConfiguration configuration) {
        this.configuration = configuration;
    }

    public static DatabaseManager getInstance(LogConfiguration configuration) {
        if (instance == null) {
            instance = new DatabaseManager(configuration);
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            Connection connection = null;
            Class.forName(configuration.getProperty("logger.bd.jdbcDriver"));
            String userName = configuration.getProperty("logger.bd.userName");
            String password = configuration.getProperty("logger.bd.password");
            connection = DriverManager.getConnection(configuration.getProperty("logger.bd.dbUrl"), userName, password);
            return connection;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException("Connection DB error.", ex);
        }
    }

    public Statement getStatement(Connection connection) {
        try {
            return connection.createStatement();
        } catch (SQLException ex) {
            throw new RuntimeException("Get Statment Connection error.", ex);
        }
    }

    private void createLogTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            statement = getStatement(connection);
            statement.executeUpdate("create table IF NOT EXISTS Log_Values(message varchar(255), type int)");
        } catch (SQLException ex) {
            throw new RuntimeException("Create log table BD error.", ex);
        }
    }

    public void insertMessageDB(String message, int messageType) {
        Connection connection = null;
        Statement statement = null;
        try {
            createLogTable();
            connection = getConnection();
            statement = getStatement(connection);
            statement.execute("INSERT INTO Log_Values(message, type) VALUES('" + message + "', " + String.valueOf(messageType) + ")");
        } catch (SQLException ex) {
            throw new RuntimeException("Insert message BD error.", ex);
        }
    }
}
