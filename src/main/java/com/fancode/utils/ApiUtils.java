package com.fancode.utils;

import com.fancode.modals.Todo;
import com.fancode.modals.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApiUtils {

    // Fetch all users
    public static List<User> getAllUsers() {
        return ApiClient.getList("/users", User.class);
    }

    // Fetch todos by userId
    public static List<Todo> getTodosByUserId(int userId) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("userId", userId);
        return ApiClient.getList("/todos", queryParams, Todo.class);
    }

    // Filter users based on FanCode city latitude and longitude
    public static List<User> getFanCodeUsers() {
        List<User> allUsers = getAllUsers();
        return allUsers.stream()
                .filter(user -> {
                    double lat = user.getAddress().getGeo().getLat();
                    double lng = user.getAddress().getGeo().getLng();
                    return lat >= -40 && lat <= 5 && lng >= 5 && lng <= 100;
                })
                .collect(Collectors.toList());
    }
}
