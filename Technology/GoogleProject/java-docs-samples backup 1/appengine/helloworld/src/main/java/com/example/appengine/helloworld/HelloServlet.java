/**
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.appengine.helloworld;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// [START example]
@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {
  private static Logger logger = Logger.getLogger(HelloServlet.class.getName());

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    logger.log(Level.INFO, "doPost start...");
    logger.log(Level.INFO, "Username: " + request.getParameter("username"));
    logger.log(Level.INFO, "Password: " + request.getParameter("password"));
    logger.log(Level.INFO, "Checkbox: " + request.getParameter("rememberMe"));

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    String title = "Using POST Method to Read Form Data";
    String docType =
            "<!doctype html public \"-//w3c//dtd html 4.0 " +
                    "transitional//en\">\n";
    out.println(docType +
            "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor=\"#f0f0f0\">\n" +
            "<h1 align=\"center\">" + title + "</h1>\n" +
            "<ul>\n" +
            "  <li><b>Username</b>: "
            + request.getParameter("username") + "\n" +
            "  <li><b>Password</b>: "
            + request.getParameter("password") + "\n" +
            "</ul>\n" +
            "</body></html>");
    logger.log(Level.INFO, "doPost ended...");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    logger.log(Level.INFO, "doGet started...");
    response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    String title = "Using POST Method to Read Form Data";
    String docType =
            "<!doctype html public \"-//w3c//dtd html 4.0 " +
                    "transitional//en\">\n";
    out.println(docType +
            "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor=\"#f0f0f0\">\n" +
            "<h1 align=\"center\">" + title + "</h1>\n" +
            "<ul>\n" +
            "  <li><b>Username</b>: "
            + request.getParameter("username") + "\n" +
            "  <li><b>Password</b>: "
            + request.getParameter("password") + "\n" +
            "</ul>\n" +
            "</body></html>");
    logger.log(Level.INFO, "doGet ended...");
  }
}
// [END example]
