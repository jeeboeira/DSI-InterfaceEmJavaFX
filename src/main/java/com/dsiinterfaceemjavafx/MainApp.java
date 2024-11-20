package com.dsiinterfaceemjavafx;

import com.dsiinterfaceemjavafx.view.BoardView;
import com.dsiinterfaceemjavafx.view.SplashScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {              // Classe principal do Jogo da Velha FX.

    @Override
    public void start(Stage primaryStage) {
        // Exibe a tela inicial (Splash Screen)
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.show(primaryStage);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
