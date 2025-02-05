package test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.LinkedHashMap;

public class Rest {
    public static void main(String[] args) {
        Response restAssured = RestAssured.get("https://dummyjson.com/products");
        JsonPath jsonPath = restAssured.jsonPath();
        System.out.println(jsonPath.get().toString());
        LinkedHashMap<String,String> list = jsonPath.get("products[0]");
        System.out.println(list.get("description"));
    }


}

