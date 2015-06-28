package com.test.springrest.model;

import com.test.springrest.shared.SharedMethods;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Bandula Gamage on 28/06/2015.
 */
public class UserStore {
    private static UserStore selfRef;

    private int userCounter;
    private HashMap<String, User> users = new HashMap<String, User>();

    public UserStore() {
        selfRef = this;
    }

    public User getUser(String userName) {
        return users.get(userName);
    }

    public ArrayList<User> getUsers() {
        return new ArrayList<User>(users.values());
    }

    public String updateUser(User user) {
        if ((user != null) && (users.containsKey(user.getUserName()))) {
            users.put(user.getUserName(), user);
            user.setLastModified(new Date());
            return SharedMethods.generateStatus("update", user.getUserName() + " successfully updated");
        } else
            return SharedMethods.generateStatus("update", "Failed, user not found");
    }

    public String addUser(User newUser) {
        users.put(newUser.getUserName(), newUser);

        return SharedMethods.generateStatus("add", newUser.getUserName()+ " successfully added");
    }

    public String deleteUser(String userName) {
        if (userName != null) {
            users.remove(userName);
            return SharedMethods.generateStatus("delete", userName + " successfully deleted");
        } else
            return SharedMethods.generateStatus("delete", " operation aborted");
    }

    public static synchronized UserStore getInstance() {
        if (selfRef == null)
            selfRef = new UserStore();

        return selfRef;
    }

}
