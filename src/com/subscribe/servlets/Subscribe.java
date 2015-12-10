package com.subscribe.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SubscribeAndroid")
public class Subscribe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static List<String> subscriptions = new ArrayList<String>();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      String action = request.getParameter("action");
      String sid = request.getParameter("sid");
      System.out.println("sid recieved is " + sid + " and action is " + action);
      switch (action){
        case "subscribe" : 
          if(!subscriptions.contains(sid))
          subscriptions.add(sid);
          break;
        case "unsubscribe":
          subscriptions.remove(sid);
          break;
      }
      response.setContentType("text/plain");
      System.out.println("Active Subscriptions are \n" + subscriptions);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
