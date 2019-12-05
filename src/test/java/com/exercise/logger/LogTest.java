/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.logger;

import com.exercise.logger.config.LogConfiguration;
import com.exercise.logger.enums.LogType;
import com.exercise.logger.enums.MessageType;
import com.exercise.logger.util.DatabaseManager;
import com.exercise.logger.util.LogCompose;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author pedro
 */
public class LogTest {

    public LogTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void validateConsoleType() {
        Log logger = LogFactory.getLogger(LogType.CONSOLE.getType());
        assertEquals(true, logger instanceof ConsoleLog);
    }

    @Test
    public void validateConsoleLog() {
        Log logger = LogFactory.getLogger(LogType.CONSOLE.getType());
        logger.createMessage("Validate Console - Test Message Info");
        logger.createWarning("Validate Console - Test Message Warning");
        logger.createError("Validate Console - Test Message Error");
        assertEquals(true, logger instanceof ConsoleLog);
    }

    @Test
    public void validateDatabaseType() {
        Log logger = LogFactory.getLogger(LogType.DATABASE.getType());
        assertEquals(true, logger instanceof DatabaseLog);
    }

    @Test
    public void validateDBConnection() {
        DatabaseManager dbm = DatabaseManager.getInstance(new LogConfiguration());
        try {
            assertTrue(dbm.getConnection().isValid(0));
        } catch (SQLException ex) {
            assertTrue(false);
        }
    }

    @Test
    public void validateDatabaseLog() {
        Log logger = LogFactory.getLogger(LogType.DATABASE.getType());
        logger.createMessage("Validate Database - Test Message Info");
        logger.createWarning("Validate Database - Test Message Warning");
        logger.createError("Validate Database - Test Message Error");
        assertEquals(true, logger instanceof DatabaseLog);
    }

    @Test
    public void validateFileType() {
        Log logger = LogFactory.getLogger(LogType.FILE.getType());
        assertEquals(true, logger instanceof FileLog);
    }

    @Test
    public void validateFileLog() {
        Log logger = LogFactory.getLogger(LogType.FILE.getType());
        logger.createMessage("Validate File - Test Message Info ");
        logger.createWarning("Validate File - Test Message Warning ");
        logger.createError("Validate File - Test Message Error ");
        assertEquals(true, logger instanceof FileLog);
    }
}
