package com.demo.util;

import jakarta.servlet.ServletContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBConnect {
    public Connection conn;
    public PreparedStatement pstmt;
    public ResultSet rs;

    public JDBConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false&allowPublicKeyRetrieval=true";
            String id = "root";
            String pwd = "password";
            conn = DriverManager.getConnection(url, id, pwd);
            System.out.println("DB 연결 성공(기본 생성자)");
        } catch (Exception e) {
            System.out.println("DB 연결 실패(기본 생성자) " + e.getMessage());
        }
    }

    public JDBConnect(ServletContext application) {
        try {
            String driver = application.getInitParameter("MySQLDriver");
            Class.forName(driver);
            String url = application.getInitParameter("MySQLUrl");
            String id = application.getInitParameter("MySQLId");
            String pwd = application.getInitParameter("MySQLPwd");
            conn = DriverManager.getConnection(url, id, pwd);
            System.out.println("DB 연결 성공(매개변수 생성자)");
        } catch (Exception e) {
            System.out.println("DB 연결 성공(매개변수 생성자) : " + e.getMessage());
        }
    }
    
    public void close() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) rs.close();
            if (conn != null) conn.close();
            System.out.println("JDBC 자원해제");
        } catch (Exception e) {
            System.out.println("JDBC 자원해제 실패 " + e.getMessage());
        }
    }
}
