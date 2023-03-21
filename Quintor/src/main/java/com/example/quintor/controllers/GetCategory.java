package com.example.quintor.controllers;

import com.example.quintor.transaction.Category;
import org.json.JSONObject;

public class GetCategory {
    public static Category checkCategory(JSONObject jsonObject) {
        int categoryId = (int) jsonObject.get("categoryId");
        String name = (String) jsonObject.get("name");

        return new Category(categoryId, name);
    }
}
