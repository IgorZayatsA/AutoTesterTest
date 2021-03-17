package com.gmail.igorzayatsa.utils;

import java.sql.*;
import java.util.ArrayList;

public class SQLManager {

    public Connection connection;
    public static ArrayList<String> sqlList = new ArrayList<>();

    protected Statement statement;

    private static SQLManager sqlManager = null;

    public static SQLManager getInstance() {
        if (sqlManager == null) {
            sqlManager = new SQLManager();
        }
        return sqlManager;
    }

    private SQLManager() {
        String url = "jdbc:sqlserver://desktop-nsb2nuc\\sqlexpress;databaseName=TestDb";
        String username = "User1";
        String password = "user";
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("No DB connection");
        }
    }

    //Метод преобразования данных в запрос и добавления в List
    public static void addToList(String name, Timestamp beginTime, Timestamp endTime){
        String strBeginTime = beginTime.toString()
                .replace("-", "");
        String strEndTime = endTime.toString()
                .replace("-", "");
        sqlList.add("INSERT INTO DepositTest (Step_name, Step_start_time, step_end_time)" +
                "VALUES ('" + name + "','" + strBeginTime + "','" + strEndTime + "')");
    }

    //Метод записи в базу данных
    public void insertIntoDataBase(){
        try {
            if (sqlList != null){
                for (String s : sqlList) {
                    statement = connection.createStatement();
                    statement.executeUpdate(s);
                }
            }
            //connection.close();
            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.connection;
    }
}
