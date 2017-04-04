package controller;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class controller implements iController {

    List<User> users = new ArrayList<>();


    @Override
    public void sendSMS(User user, String msg)
    {


    }

    public List<User> getUsers(List<User> userList)
    {
        return userList;
    }

}
