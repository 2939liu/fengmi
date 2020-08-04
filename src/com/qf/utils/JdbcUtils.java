package com.qf.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
   /* private static String url = null;
    private static String user = null;
    private static String password = null;
    private static String driver = null;*/

    /*static{
        Properties pro = new Properties();
        InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            pro.load(is);
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driverClass");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    //返回一个连接池对象
    public static DataSource getDataSource(){
        return  cpds;
    }
//返回一个连接对象
    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }

    private static QueryRunner queryRunner;
    public static QueryRunner getQueryRunner(){
        synchronized (JdbcUtils.class){
            if(queryRunner == null){
                queryRunner = new QueryRunner();
                return queryRunner;
            }
            return null;
        }
    }

    public static void close(Connection conn, PreparedStatement ppst, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(conn,ppst);
    }

    public static void close(Connection conn, PreparedStatement ppst){
        if(ppst != null){
            try {
                ppst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
