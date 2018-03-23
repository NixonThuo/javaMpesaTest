package com.mpesatest.maven;


import com.google.common.base.Stopwatch;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DEVWK008
 */

// With @WebServlet annotation the webapp/WEB-INF/web.xml is no longer required.
@WebServlet(name = "CloudSQL",
    description = "CloudSQL: Write timestamps of visitors to Cloud SQL",
    urlPatterns = "/cloudsql")
public class CLoudSQL {
  Connection conn;
  String dbName = "mpesa_db",
          dbInstance = "mpesa-test:us-central1:mpesa-instance", uname="postgres", upass="KennRixx2@";
  
  public void CLoudSQL(){
      try {
          String jdbcurl = String.format("jdbc:postgresql://google/%s?socketFactory=com.google.cloud.sql.postgres.SocketFactory" +
                  "&socketFactoryArg=%s", dbName,dbInstance);
          
          conn = DriverManager.getConnection(jdbcurl, uname, upass);
      } catch (SQLException ex) {
          Logger.getLogger(CLoudSQL.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

}
    

