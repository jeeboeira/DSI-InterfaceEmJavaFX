package com.dsiinterfaceemjavafx.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class SplashScreen implements Screen{ // Tela inicial do jogo

    @Override
    public void show(Stage stage) {
        StackPane root = new StackPane();                                   // Cria um layout simples

        // Mensagem Central
        Label message = new Label("Pressione qualquer tecla para continuar...");
        message.setStyle("-fx-font-size: 24; -fx-tex-fill: white;");

        root.getChildren().add(message);                                    // Adiciona o rótulo ao layout
        root.setStyle("-fx-background-color: black;");

        Scene scene = new Scene(root, 400, 400);                     // Cria uma cena e adiciona ao palco

        scene.setOnKeyPressed((KeyEvent event) -> {
            MainMenu mainMenu = new MainMenu();                             // Navega para o menu inicial
            mainMenu.show(stage);
        });

        stage.setScene(scene);
        stage.show();
    }
}
