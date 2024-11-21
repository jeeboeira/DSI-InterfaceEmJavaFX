package com.dsiinterfaceemjavafx.view;

import com.dsiinterfaceemjavafx.controller.GameController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayerSetupScreen implements Screen{

    private final String player1Name;
    private final String player1Team;

    public PlayerSetupScreen(String player1Name, String player1Team) {
        this.player1Name = player1Name;
        this.player1Team = player1Team;
    }

    @Override
    public void show(Stage stage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        // Nome do jogador 2
        Label player2Label = new Label("Nome do jogador 2:");
        TextField player2Field = new TextField();
        player2Field.setPromptText("Digite o nome do Jogador 2");

        // Botão para iniciar o jogo
        Button StartGameButton = new Button("Iniciar jogo");
        StartGameButton.setOnAction(e -> {
            String player2Name = player2Field.getText().trim();
            String player2Team = player1Team.equals("X") ? "O" : "X";

            if (!player2Name.isEmpty()) {
                PlayerConfirmationPopup.show(player1Name, "X", player2Name, "O");
                GameController gameController = new GameController(primaryStage, player1Name, player2Name);
                GameBoardScreen gameBoard = new GameBoardScreen();
                gameBoard.show(stage, player1Name, 'X', player2Name, 'O');
            } else {
                player2Field.setPromptText("Nome Obrigatório!");
                player2Field.setStyle("-fx-border-color: red;");
            }
        });

        // Adiciona ao layout
        root.getChildren().addAll(player2Label, player2Field, StartGameButton);

        // Cena
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Configuração do Jogador 2");
        stage.show();
    }
}
