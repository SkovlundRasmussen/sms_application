package view;

import model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class view extends Application {

    private Stage stage;
    private Scene scene;
    private TextField textField;
    private Button btnSend;
    private ComboBox comboBoxUsers;
    private GridPane gridPane;
    private VBox vBox;

    public static void main(String[] args) {
        model dbModel = new model();

        dbModel.connectToBD();

        //launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        btnSend = new Button("Send");
        textField = new TextField();
        textField.setMinSize(300, 300);
        comboBoxUsers = new ComboBox();
        vBox = new VBox();
        gridPane = new GridPane();

        vBox.getChildren().addAll(textField, comboBoxUsers, btnSend);
        scene = new Scene(vBox);

        stage.setScene(scene);
        stage.show();

    }
}
