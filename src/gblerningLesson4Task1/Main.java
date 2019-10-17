package gblerningLesson4Task1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("MyChat");

        GridPane root = new GridPane();
        root.setHgap(25);
        root.setVgap(15);

        TextArea chatMessage = new TextArea();
        chatMessage.setDisable(true);
        root.add(chatMessage,0,0,5,25);


        TextArea listUsers = new TextArea();
        listUsers.setDisable(true);
        root.add(listUsers,5,0,2,25);

        TextField enterMessage = new TextField("");

        enterMessage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                chatMessage.appendText(enterMessage.getText() +"\n");

                enterMessage.clear();
            }
        });

        root.add(enterMessage,0,25,6,1);

        Button btn = new Button();
        btn.setText("Send Message'");

        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                chatMessage.appendText(enterMessage.getText() +"\n");

                enterMessage.clear();

            }
        });

        root.add(btn,6,25,2,1);

        primaryStage.setScene(new Scene(root, 350, 450));
        primaryStage.show();


    }
}


