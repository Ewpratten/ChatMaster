package dev.hyperlisk.chatmaster.database;

import dev.hyperlisk.chatmaster.util.ConnectionString;
import javafx.scene.chart.PieChart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    /**
     * host: the host name of the sql server
     * port: port on which the database is setup
     * db: name of the database
     * user: username for getting info from the database
     * password: password to the specific database
     */
    private String host;
    private int port;
    private String db;
    private String user;
    private String password;
    private Logger logger;
    private Connection connection;


    public Database(String host, int port, String db, String user, String pass, Logger logger) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = pass;
        this.logger = logger;

    }

    public String getHost() {
        return host;
    }

    public String getDb() {
        return db;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }


    /**
     * Connect to the database with the given information from the config.
     *
     * @return true if connected : false if something fucked up.
     */
    public boolean openCon() {
        String jdbc = ConnectionString.getConnectionString(host, port, db, user, password);

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e)
        {
            throw new RuntimeException("Initalizing JDBC driver failed. Something major fucked up.");
        }

        try {
            connection = DriverManager.getConnection(jdbc);
            this.logger.log(Level.INFO, "Successful connection to --> " + db);
            return true;
        } catch (SQLException e ) {
            this.logger.log(Level.SEVERE, "Could not connect to --> " + db);
            return false;
        }
    }

    public void closeCon() {
        try {
            connection.close();
        } catch (SQLException e) {
            this.logger.log(Level.SEVERE, "Something went wrong when attempting to close the connection to --> " + db);
        }
    }

    public boolean isConnected() {

        final String CHECK_SQL_QUERY = "SELECT 1";
        boolean isConnected = false;
        try {
            final PreparedStatement statement = connection.prepareStatement(CHECK_SQL_QUERY);
            isConnected = true;
        } catch (Exception e) {
            if(e instanceof SQLException) {
                this.logger.log(Level.SEVERE, "SQL Exception -->" + e);

            } else if(e instanceof NullPointerException) {

                this.logger.log(Level.SEVERE, "NullPointer Exception -->" + e);

            } else {
                this.logger.log(Level.SEVERE, "Holy fuck, how did you even get here? Here's the excepetion -->" + e);
            }
        }

        return isConnected;

    }

    public PreparedStatement prepedStatement(String sqlStatement) {

        try {
            if(!isConnected()) {
                openCon();
            }
            return connection.prepareStatement(sqlStatement);
        } catch (SQLException e) {
            this.logger.log(Level.SEVERE, "Statement could not be prepared for " +
                    "some reason. Here is the statement you tried -->" + sqlStatement, e);
        }
        return null;
    }

    public void execute(String sql) {

        try {
            if(isConnected()) {
                connection.prepareStatement(sql).executeUpdate();
            } else {
                openCon();
                execute(sql);
            }
        } catch (SQLException e) {
            this.logger.log(Level.SEVERE, "Could not execute SQL statement!", e);
        }

    }
}
