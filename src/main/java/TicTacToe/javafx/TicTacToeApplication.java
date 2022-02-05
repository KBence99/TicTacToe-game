package TicTacToe.javafx;

import TicTacToe.javafx.controller.WelcomeController;
import com.google.inject.Inject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.tinylog.Logger;

public class TicTacToeApplication extends Application {

    @Inject
    private FXMLLoader fxmlLoader;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Logger.info("Starting application");
        fxmlLoader = new FXMLLoader(WelcomeController.class.getResource("/fxml/Welcome.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("TicTacToe");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
