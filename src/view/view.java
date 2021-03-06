package view;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import model.*;
import controller.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.List;

public class view extends Application {

    private Stage stage;
    private Scene scene;
    private TextField textField, textFieldSender;
    private TextArea textArea;
    private Button btnSend;
    private GridPane gridPane;
    private VBox vBox;

    private ComboBox comboBoxUsers;
    controller controller_instance = new controller();

    public static void main(String[] args) {
        model dbModel = new model();

        //dbModel.connectToBD();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        btnSend = new Button("Send");
        btnSend.setOnAction(event -> {
            sendMsg(event);
        });
        textField = new TextField();
        textArea = new TextArea();
        textArea.setPrefColumnCount(10);
        textFieldSender = new TextField();
        comboBoxUsers = new ComboBox();
        fillCombobox(comboBoxUsers);
        vBox = new VBox();
        gridPane = new GridPane();

        vBox.getChildren().addAll(textArea, textFieldSender, comboBoxUsers, btnSend);
        scene = new Scene(vBox);

        stage.setScene(scene);
        stage.show();

    }

    private void sendMsg(ActionEvent event) {
        try {
            String number = comboBoxUsers.getValue().toString();
            String msg = textArea.getText();
            String sender = textFieldSender.getText();

            controller_instance.sendSMS(number, msg, sender);
        }
        catch (Exception e)
        {

        }
    }

    public ComboBox fillCombobox(ComboBox cb)
    {

        List<User> Users = controller_instance.getUsers();

        for(int i = 0; i < Users.size(); i++)
        {
            cb.getItems().addAll(Users.get(i).getNumber());
        }
        cb.setValue("Numre");
  /*    cb.getItems().addAll(Users);*/

        return cb;
    }

}
