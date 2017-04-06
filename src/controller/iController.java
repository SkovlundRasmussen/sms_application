package controller;

import model.User;

public interface iController {

    public void sendSMS(User user, String msg) throws Exception;
}
