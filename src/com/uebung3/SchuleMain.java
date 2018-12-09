package com.uebung3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SchuleMain extends Application {

    private static Stage primaryStage;

    private Parent root;
    private Scene mainScene;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        root = FXMLLoader.load(getClass().getResource("FXMLs/schule.fxml"));

        mainScene = new Scene(root, 473, 319);
        mainScene.getStylesheets().add(this.getClass().getResource("StyleSheets/main.css").toExternalForm());

        primaryStage.setTitle("Schulbank");
        primaryStage.setScene(mainScene);
        primaryStage.setMinWidth(473);
        primaryStage.setMinHeight(319);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
