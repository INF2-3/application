package com.example.quintor;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ApiService {

    private URL url;

    public ApiService(){
        setUrl("http://localhost:8080/MT940toJSON");
    }

    public String getRequest() throws Exception {
        HttpURLConnection connection = setConnection("get");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public String postRequest(String body) throws Exception{
        HttpURLConnection connection = setConnection("post");

        OutputStream os = connection.getOutputStream();
        byte[] input = body.getBytes(StandardCharsets.UTF_8);
        os.write(input, 0, input.length);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public HttpURLConnection setConnection(String method) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) getUrl().openConnection();
        switch (method){
            case "get":
                connection.setRequestMethod("GET");
                break;
            case "post":
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);
                break;
        }

        return connection;
    }

    public void setUrl(String url) throws RuntimeException {
        try{
        this.url = new URL(url);

        }catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public URL getUrl() {
        return url;
    }
}
