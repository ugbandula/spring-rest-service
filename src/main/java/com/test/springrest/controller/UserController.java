package com.test.springrest.controller;

import com.test.springrest.model.User;
import com.test.springrest.model.UserStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Bandula Gamage on 28/06/2015.
 */
@Controller
public class UserController {

    @RequestMapping(value = UserRestURIConstants.GET_ALL_USERS, method = RequestMethod.GET)
    public @ResponseBody ArrayList<User> getUsers() {
        return UserStore.getInstance().getUsers();
    }

    @RequestMapping(value = UserRestURIConstants.GET_USER, method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable("username") String username) {
        return UserStore.getInstance().getUser(username);
    }

    @RequestMapping(value = UserRestURIConstants.ADD_USER, method = RequestMethod.POST)
    public @ResponseBody String addUser(@RequestBody User user) {
        return UserStore.getInstance().addUser(user);
    }

    @RequestMapping(value = UserRestURIConstants.UPDATE_USER, method = RequestMethod.PUT)
    public @ResponseBody String updateUser(@RequestBody User user) {
        return UserStore.getInstance().updateUser(user);
    }

    @RequestMapping(value = UserRestURIConstants.DELETE_USER, method = RequestMethod.PUT)
    public @ResponseBody String updateUser(@PathVariable("userName") String userName) {
        return UserStore.getInstance().deleteUser(userName);
    }
}
