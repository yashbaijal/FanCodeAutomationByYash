package com.fancode.tests;

import com.fancode.testComponents.BaseTest;
import com.fancode.modals.Todo;
import com.fancode.modals.User;
import com.fancode.utils.ApiUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FanCodeTest extends BaseTest {

    @Test
    public void verifyFanCodeUsersTodoCompletion() {
        List<User> fanCodeUsers = ApiUtils.getFanCodeUsers();
        Assert.assertFalse(fanCodeUsers.isEmpty(), "No users found in FanCode city.");

        for (User user : fanCodeUsers) {
            List<Todo> todos = ApiUtils.getTodosByUserId(user.getId());
            Assert.assertFalse(todos.isEmpty(), "No todos found for user ID: " + user.getId());

            long completedCount = todos.stream().filter(Todo::isCompleted).count();
            double completionPercentage = ((double) completedCount / todos.size()) * 100;

            System.out.println("User ID: " + user.getId() + ", Completed: " + completionPercentage + "%");

            Assert.assertTrue(completionPercentage > 50,
                    "User ID: " + user.getId() + " has less than 50% todos completed.");
        }
    }
}
