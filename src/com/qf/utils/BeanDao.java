package com.qf.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.InvocationTargetException;import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeanDao {
    public static int update(String sql,Object[] objects) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        QueryRunner queryRunner = JdbcUtils.getQueryRunner();
        int rows = queryRunner.update(conn, sql, objects);
        return rows;

       /* Connection conn = JdbcUtils.getConnection();
        PreparedStatement ppst = conn.prepareStatement(sql);
        //获取参数元数据对象
        ParameterMetaData parameterMetaData = ppst.getParameterMetaData();
        int parameterCount = parameterMetaData.getParameterCount();
        //获取参数个数
        if(parameterCount != 0&&objects.length == parameterCount){
            for (int i = 1; i <= parameterCount ; i++) {
                ppst.setObject(i, objects[i-1]);
            }
        }
        int i = ppst.executeUpdate();
        JdbcUtils.close(conn,ppst);
        return i;*/
    }

    public static <T> List<T> query(String sql, Object[] objects, Class<T> cls) throws SQLException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Connection conn = JdbcUtils.getConnection();
        QueryRunner queryRunner = JdbcUtils.getQueryRunner();
        List<T> query = queryRunner.query(conn, sql, new BeanListHandler<>(cls), objects);
        return query;
        /*PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //获取参数元数据对象
        ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
        //通过参数元数据对象的方法获取参数个数
        int parameterCount = parameterMetaData.getParameterCount();
        //给sql语句中的？占位符赋值
        for (int i = 1; i <= parameterCount ; i++) {
            preparedStatement.setObject(i,objects[i-1]);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        //获取结果集元数据对象
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        System.out.println(columnCount);
        List<T> list = new ArrayList<>();
        //遍历获取元素
       while(resultSet.next()){
           T t = cls.getConstructor(null).newInstance(null);
           for (int i = 1; i <= columnCount ; i++) {
               //获取字段的名字
               String columnName = metaData.getColumnName(i);
               //获取对应字段的值
               Object value = resultSet.getObject(i);
               //将值进行存储
               BeanUtils.setProperty(t,columnName,value);
           }
           list.add(t);
        }*/
      /* JdbcUtils.close(conn,preparedStatement,resultSet);
       return list.size() != 0? list:null;*/


    }
}
