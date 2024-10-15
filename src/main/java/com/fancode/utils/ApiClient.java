package com.fancode.utils;

import com.fancode.config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class ApiClient {

    static {
        // Set the base URI from ConfigReader when the class is loaded
        RestAssured.baseURI = ConfigReader.getBaseUrl();
    }

    // Generic GET request method without query parameters
    public static <T> T get(String endpoint, Class<T> responseClass) {
        Response response = RestAssured
                .given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response.as(responseClass);
    }

    // Generic GET request method with query parameters
    public static <T> T get(String endpoint, Map<String, Object> queryParams, Class<T> responseClass) {
        Response response = RestAssured
                .given()
                .queryParams(queryParams)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response.as(responseClass);
    }

    // Generic GET request method for lists using JsonPath
    public static <T> List<T> getList(String endpoint, Map<String, Object> queryParams, Class<T> responseClass) {
        return RestAssured
                .given()
                .queryParams(queryParams)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("", responseClass);
    }

    // Overloaded method for lists without query parameters
    public static <T> List<T> getList(String endpoint, Class<T> responseClass) {
        return RestAssured
                .given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("", responseClass);
    }
}
