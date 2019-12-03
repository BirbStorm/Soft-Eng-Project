package Util;

import java.sql.*;

public class DBUtil {

    public static Connection setConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("mysql://doadmin:mw81pbjyw96uiaar@" +
                "db-appointments-do-user-6714215-0.db.ondigitalocean.com:" +
                "25060/appointments?ssl-mode=REQUIRED");
    }

    public static ResultSet executeQuery(String query) throws SQLException, ClassNotFoundException{
        Connection conn = setConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            System.out.println("Select statement: " + query + "\n");

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (rs != null) {
                //Close resultSet
                rs.close();
            }
            if (stmt != null) {
                //Close Statement
                stmt.close();
            }
            //Close connection
            conn.close();
        }
        return rs;
    }

    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        Connection conn = setConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlStmt);

        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                //Close statement
                stmt.close();
            }
            //Close connection
            conn.close();
        }
    }
}
