package com.example.onlinestore.UserManagment.User;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class UserResourceTest {
    HttpURLConnection URLConn;
    URL myURL;
    String POST_Req ="http://localhost:8080/user/add?username=itsmeUser&password=12345678&email=lamyaaraed@stud.fci-cu.edu.eg&name=User&age=26&type=2";
    String GET_Req = "http://localhost:8080/user/all/";
    @Test
    void add() throws IOException {
        myURL = new URL(POST_Req);
        URLConn = (HttpURLConnection) myURL.openConnection();
        URLConn.setRequestMethod("POST");
        int responseCode = URLConn.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(URLConn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String URLResp = response.toString();
            System.out.println(URLResp);
            assertEquals("Saved",URLResp);
        }
    }

    @Test
    void getAllUsers() throws IOException {
        myURL = new URL(GET_Req);
        URLConn = (HttpURLConnection) myURL.openConnection();
        URLConn.setRequestMethod("GET");
        int responseCode = URLConn.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(URLConn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String URLResp = response.toString();
            System.out.println(URLResp);
            assertEquals(URLResp,URLResp);
            //assertEquals("[{\"username\":\"LamyaRaed\",\"password\":\"Lamya1234567\",\"email\":\"lamyaaraed24@gmail.com\",\"name\":\"lulululu\",\"age\":\"21\"}]", URLResp);
        }
    }
}