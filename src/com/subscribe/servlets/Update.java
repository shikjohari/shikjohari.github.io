package com.subscribe.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
  private static final long serialVersionUID = 1L;

  static List<String> data = new ArrayList<String>();

  public Update() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.getWriter().write("Data Stored is \n");
    response.getWriter().write("--\n");
    for (String s : data) {
      response.getWriter().write(s);
      response.getWriter().write("\n");
    }
    response.getWriter().write("No of Items " + data.size());

    response.getWriter().write("<form action=\"Update\" method=\"post\">");
    response.getWriter().write("<input type=\"text\" name=\"name\"/><br/><br/>");
    response.getWriter().write("<input type=\"submit\" value=\"register\"/>");
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    data.add(request.getParameter("name"));
    response.getWriter().write("New Name Added");
    Notifier.notifyDevices();
  }

}
