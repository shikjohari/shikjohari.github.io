package com.subscribe.servlets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Notifier {

  public static void notifyDevices() throws IOException{
    System.out.println("Sending Notifications");
    String gcmurl = "https://android.googleapis.com/gcm/send";
    String auth = "key=AIzaSyDwolUEQwUQ9mjRmKXUJ_0B_4L3FQ74RVg";
    URL obj = new URL(gcmurl);
    HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

    //add reuqest header
    con.setRequestMethod("POST");
    con.setRequestProperty("Authorization", auth);
    con.setRequestProperty("Content-Type", "application/json");
    StringBuilder sb = new StringBuilder("{\registration_ids\":[");
    for(String sub : Subscribe.subscriptions){
      sb.append("\""+sub+"\",");
    }
    sb.append("]}");
    
    // Send post request
    con.setDoOutput(true);
    System.out.println("Request format is " + con);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.writeBytes(sb.toString());
    wr.flush();
    wr.close();
    System.out.println(con.getResponseMessage());
    System.out.println(con.getResponseCode());
  }
}
