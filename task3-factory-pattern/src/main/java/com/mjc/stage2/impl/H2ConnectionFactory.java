package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;
import com.mjc.stage2.exceptions.ConnectionCreationException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    private static final Properties properties;

    static {
        properties = new Properties();
        try ( Reader reader = new FileReader("src/main/resources/h2database.properties") ) {
            properties.load(reader);
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }
    }


    @Override
    public Connection createConnection() {
        try {
            Class.forName(properties.getProperty("jdbc_driver"));
            return DriverManager.getConnection(properties.getProperty("db_url") , properties.getProperty("user") , properties.getProperty("password"));
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new ConnectionCreationException(ex);
        }
    }
}

