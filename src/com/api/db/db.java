package com.api.db;

import java.sql.*;
import java.util.Properties;
import org.gjt.mm.mysql.Driver;

public class db {
    public static Connection getConnection() throws SQLException{
        Driver driver=new org.gjt.mm.mysql.Driver();
        DriverManager.registerDriver(driver);
        String conString="jdbc:mysql://localhost:3306/NhanVienDB";
        Properties info=new Properties();
        info.setProperty("characterEncoding", "utf8");
        info.setProperty("user","root");
        info.setProperty("password","manhquan");
        Connection connection;
        connection=DriverManager.getConnection(conString,info);
        return connection;
    }

    public static Statement createStatement() throws SQLException{
        return getConnection().createStatement();
    }

    public static ResultSet executeQuery(String sql)throws SQLException{
        return createStatement().executeQuery(sql);
    }

    public static PreparedStatement execute(String sql) throws SQLException {
        return getConnection().prepareCall(sql);
    }

    public static int executeUpdate(String sql)throws SQLException{
        return createStatement().executeUpdate(sql);
    }

    public static int executeUpdateID(String sql) throws SQLException{
        return createStatement().executeUpdate(sql,createStatement().RETURN_GENERATED_KEYS);
    }

    public static void close()throws SQLException{
        getConnection().close();
    }
}
