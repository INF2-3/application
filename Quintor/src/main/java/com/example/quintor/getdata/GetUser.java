package com.example.quintor.getdata;

import com.example.quintor.dataobjects.User;
import org.json.JSONObject;
import org.w3c.dom.Element;

public class GetUser {
    public static User makeUserJSON(JSONObject jsonObject) {
        int id = jsonObject.getInt("id");
        int roleId = jsonObject.getInt("roleId");
        String userName = jsonObject.getString("userName");
        String email = jsonObject.getString("email");

        return new User(email, userName, roleId);
    }

    public static User makeUserXML(Element element) {
        int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
        int roleId = Integer.parseInt(element.getElementsByTagName("roleId").item(0).getTextContent());
        String userName = element.getElementsByTagName("userName").item(0).getTextContent();
        String email = element.getElementsByTagName("email").item(0).getTextContent();

        return new User(email, userName, roleId);
    }
}
