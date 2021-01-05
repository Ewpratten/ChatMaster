package dev.hyperlisk.chatmaster.util;

public class ConnectionString {

    /**
     * @author hyperliskdev
     *
     * @param host
     * @param port
     * @param db
     * @param user
     * @param pass
     * @return
     */
    public static String getConnectionString(String host, int port, String db, String user, String pass) {
        return "jdbc:mysql://" + host + ":" + port + "/" + db + "?user=" + user + "?password=" + pass;
    }

}
