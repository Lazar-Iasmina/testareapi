package com.example.proiectcolectiv;

import java.sql.*;

public class DataBase {
    private static String  url = "jdbc:mysql://localhost:3306/team-project";
    private static String user="root";
    private static String password="";
    public static void createTableUser( String tableName) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName
                    + "  (userID         VARCHAR(255) unique ,"
                    + "   displayName            VARCHAR(255),"
                    + "   photoURL          VARCHAR(255),"
                    + "   email          VARCHAR(255) unique,"
                    + "   password           VARCHAR(255),"
                    + "   joinDate     DATE,"
                    + "   position VARCHAR(255)," +
                    " primary key (userID))";

        statement.executeUpdate(sqlCreate);

        conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void createTablePost(String tableName) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName
                    + "  (postID           INTEGER unique auto_increment, "
                    + "   userID            VARCHAR(255)  ,"
                    + "   questionTitle         VARCHAR(255),"
                    + "   questionContent          VARCHAR(255),"
                    + "   likes           INTEGER,"
                    + "   dislikes     INTEGER,"
                    + "   date DATE,"
                    + "   category VARCHAR(255),"
                    + "   questionCode VARCHAR(255) ,"
                    + "primary key (postID),"
                    + "foreign key (userID) references User(userID) )";

            statement.executeUpdate(sqlCreate);
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static void createTableComment(String tableName) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName
                    + "  (commentID           INTEGER unique auto_increment,"
                    + "   userID              VARCHAR(255)  ,"
                    + "   parentPostID        INTEGER , "
                    + "   parentCommID         INTEGER ,"
                    + "   content VARCHAR(255),"
                    + "   likes           INTEGER,"
                    + "   dislikes     INTEGER,"
                    + "   date DATE, "
                    + " commentTitle VARCHAR(255),"
                    + " commentCode VARCHAR(255), "
                    + "primary key (commentID),"
                    + "foreign key (userID) references User(userID),"
                    + "foreign key (parentPostID) references Post(postID),"
                    + "foreign key (parentCommID) references Comment(commentID))";

            statement.executeUpdate(sqlCreate);
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static void createTableFavorite(String tableName) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName
                    + "  (idFav           Integer unique auto_increment,"
                    + "   postID            INTEGER ,"
                    + "   userID VARCHAR(255), "
                    + "primary key (idFav),"
                    +" foreign key (postID) references Post(postID),"
                    +"foreign key (userID) references User(userID))";

            statement.executeUpdate(sqlCreate);
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static void createTableBadges(String tableName) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName
                    + "  (idBadges          VARCHAR(255) unique,"
                    + "   userID            VARCHAR(255) ,"
                    + "   badgeType VARCHAR(255),"
                    +  " primary key(idBadges)," +
                    "foreign key (userID) references User(userID))";

            statement.executeUpdate(sqlCreate);
            conn.close();
        } catch (SQLException e) {

        }


    }
    public static void createTableQuestionLabel(String tableName) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName
                    + "( labelID   VARCHAR(255) ,"
                    + " postID    INTEGER, "
                    +
                    "foreign key (postID) references Post(postID)" +
                    ")";
            System.out.println(sqlCreate);
            statement.executeUpdate(sqlCreate);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}