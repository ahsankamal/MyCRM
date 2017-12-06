package com.codegems.mycrm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("TestServlet")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user="ahsan";
        String password="password";
        String jdbcUrl="jdbc:mysql://localhost:3306/mycrm?useSSL=false";
        String driver="com.mysql.jdbc.driver";

        try{
            PrintWriter out = resp.getWriter();
            out.println("Connecting to db: "+jdbcUrl);
            Class.forName(driver);
            Connection con = DriverManager.getConnection(jdbcUrl,user,password);
            out.println("Connected successfully");
            con.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
