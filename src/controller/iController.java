package controller;

import model.User;

public interface iController {

    public void sendSMS(String number, String msg) throws Exception;
}
