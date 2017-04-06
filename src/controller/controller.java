package controller;
import java.io.DataOutputStream;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
import model.User;
import java.util.ArrayList;
import java.util.List;

import model.*;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;


import static nexo_quickstart.Util.*;

public class controller implements iController {

    model model_instance = new model();
    List<User> users = new ArrayList<>();


    @Override
    public void sendSMS(User user, String msg)  throws Exception
    {
        int user_number = user.getNumber();

        configureLogging();

        String API_KEY = "e6c0d20c";
        String API_SECRET = "d2b99f88afcc436d";
        String TO_NUMBER = Integer.toString(user_number);
        String FROM_NUMBER = "004531340753";


            AuthMethod auth = new TokenAuthMethod(API_KEY, API_SECRET);
            NexmoClient client = new NexmoClient(auth);
            System.out.println(FROM_NUMBER);

            SmsSubmissionResult[] responses = client.getSmsClient().submitMessage(new TextMessage(
                FROM_NUMBER,
                TO_NUMBER,
                msg));
        for (SmsSubmissionResult response : responses) {
            System.out.println(response);
        }
    }

    public List<User> getUsers()
    {

        return model_instance.connectToBD();
    }

}
