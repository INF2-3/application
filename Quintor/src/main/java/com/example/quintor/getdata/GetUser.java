package com.example.quintor.getdata;

import com.example.quintor.dataobjects.User;
import org.json.JSONObject;

public class GetUser {
    public static User makeUserJSON(JSONObject jsonObject) {
        int id = jsonObject.getInt("id");
        int roleId = jsonObject.getInt("roleId");
        String userName = jsonObject.getString("userName");
        String email = jsonObject.getString("email");

        return new User(email, userName, roleId);
    }
}
