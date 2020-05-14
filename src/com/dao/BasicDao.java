package com.dao;
import com.util.JDBCUtilsByDruid;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


public class BasicDao<T> {
    QueryRunner qr = new QueryRunner();
    /*
     * 功能：	通用的增删改方法，针对于任何表
     */
    public int update(String sql,Object...param) throws SQLException {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, param);
            return update;
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            connection.close();
//            JDBCUtilsByDruid.close(connection);
        }
    }
    /**
     * 功能：返回单个对象，针对于任何表
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public  T querySingle(String sql,Class<T> clazz,Object...params) throws SQLException {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();

            //执行查询
            return qr.query(connection, sql, new BeanHandler<T>(clazz), params);


        }  catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            connection.close();
//            JDBCUtilsByDruid.close(connection);
        }
    }

    /**
     * 功能：返回多个对象，针对于任何表
     * @param sql
     * @return
     */
    public List<T> queryMulti(String sql,Class<T> clazz,Object...params) throws SQLException {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();

            //执行查询
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), params);


        }  catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            connection.close();
//            JDBCUtilsByDruid.close(connection);
        }
    }
    /**
     * 功能：返回单个值
     * @param sql
     * @param params
     * @return
     */
    public Object scalar(String sql,Object...params) throws SQLException {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();


            //执行查询
            return qr.query(connection, sql, new ScalarHandler(),params);


        }  catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            JDBCUtilsByDruid.close(connection);
        }
    }

}


//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.handlers.BeanHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
//
//import java.sql.Connection;
//import java.util.List;
//
//public class BasicDao<T> {
//    QueryRunner queryRunner = new QueryRunner();
//    public int update(String sql,Object...params) throws Exception {
//        Connection connection = JDBCUtilsByDruid.getConnection();
//        try{
//            return queryRunner.update(connection,sql,params);
//        } catch (Exception e){
//            throw new RuntimeException(e);
//        } finally {
//            JDBCUtilsByDruid.close(connection);
//        }
//    }
//    public T querySingle(String sql,Class<T> clazz,Object...params) throws Exception{
//        Connection connection = JDBCUtilsByDruid.getConnection();
//        try{
//            return queryRunner.query(connection,sql,new BeanHandler<T>(clazz),params);
//        } catch (Exception e){
//            throw new RuntimeException(e);
//        } finally {
//            JDBCUtilsByDruid.close(connection);
//        }
//    }
//    public List<T> queryMutil(String sql, Class<T> clazz, Object...params) throws Exception{
//        Connection connection = JDBCUtilsByDruid.getConnection();
//        try{
//            return queryRunner.query(connection,sql,new BeanListHandler<T>(clazz),params);
//        } catch (Exception e){
//            throw new RuntimeException(e);
//        } finally {
//            JDBCUtilsByDruid.close(connection);
//        }
//    }
//}
