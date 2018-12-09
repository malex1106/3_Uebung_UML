package com.uebung3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static Stage primaryStage;

    private Parent root;
    private Scene mainScene;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        root = FXMLLoader.load(getClass().getResource("FXMLs/main.fxml"));

        mainScene = new Scene(root, 1120, 700);
        mainScene.getStylesheets().add(this.getClass().getResource("main.css").toExternalForm());

        primaryStage.setTitle("Aberix");
        primaryStage.setScene(mainScene);
        primaryStage.setMinWidth(1120);
        primaryStage.setMinHeight(710);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
