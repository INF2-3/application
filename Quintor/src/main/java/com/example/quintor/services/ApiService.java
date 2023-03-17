package com.example.quintor.services;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class ApiService {

    private String url;
    private String endpoint;

    public ApiService() {
        setUrl(System.getenv("URL"));
    }

    /**
     * Makes a get request to a api
     *
     * @param endpoint endpoint of the api
     * @return String result of get request
     * @throws Exception Throws when connection failed
     */
    public String getRequest(String endpoint) throws Exception {
        setEndpoint(endpoint);
        HttpURLConnection connection = setConnection(Method.GET);

        return getResponse(connection);
    }

    /**
     * Makes a post request to a api
     *
     * @param endpoint endpoint of the api
     * @param body     the body that will be sent with the post request
     * @return String result of post request
     * @throws Exception Throws when connection failed
     */
    public String postRequest(String endpoint, String body) throws Exception {
        HttpURLConnection connection = setConnection(Method.POST);

        OutputStream os = connection.getOutputStream();
        byte[] input = body.getBytes(StandardCharsets.UTF_8);
        os.write(input, 0, input.length);

        return getResponse(connection);

    }

    /**
     * Gets the response from a api call
     *
     * @param connection the connection with the api
     * @return String response of the api call
     * @throws IOException Throws when it's not possible to get the input stream from the connection
     */
    public String getResponse(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    /**
     * Setups the connection with the api
     *
     * @param method POST or Get
     * @return HttpURLConnection
     * @throws Exception Throws when there is no connection made
     */
    public HttpURLConnection setConnection(Method method) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(getUrl() + getEndpoint()).openConnection();
        switch (method) {
            case GET:
                connection.setRequestMethod("GET");
                break;
            case POST:
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);
                break;
        }

        return connection;
    }

    public void setUrl(String url) {
        if(!url.isEmpty()){
            this.url = url;
        }
    }

    public String getUrl() {
        return url;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        if(!endpoint.isEmpty()){
            this.endpoint = endpoint;
        }
    }
}
