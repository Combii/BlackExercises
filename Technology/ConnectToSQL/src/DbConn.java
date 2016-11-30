import java.sql.*;

/**
 * Created by David Stovlbaek on 21/10/16.
 */
public class DbConn {

    public static void main(String[] args) throws SQLException {
        openConnection();
    }


    public static void openConnection() throws SQLException {

        String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/";
        String dbName = "sql7141058";
        String username = dbName;
        String password = "7iTt9kuv5P";

        /*
        String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/";
        String dbName = "sql7141053";
        String username = "sql7141053";
        String password = "GpyscwCxMe";
        */

        Connection connection = DriverManager.getConnection(url + dbName, username, password);

        /*
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE sup (Lol INTEGER)");
        */

        DatabaseMetaData md = connection.getMetaData();
        ResultSet rs = md.getTables(null, null, "%", null);

        while (rs.next()) {
            System.out.println(rs.getString(3));
        }

        ResultSet rs2 = md.getColumns(null, null, "%", null);
        System.out.println();
        while (rs2.next()) {
            System.out.println(rs2.getString(4));
        }



    }

}
