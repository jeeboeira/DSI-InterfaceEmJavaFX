package com.dsiinterfaceemjavafx.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LocalGameSetup implements Screen{

    @Override
    public void show(Stage stage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        // Campo para o nome do jogador 1
        Label player1Label = new Label("Nome do jogador 1:");
        TextField player1Field = new TextField();
        player1Field.setPromptText("Digite o nome do Jogador 1");

        //Escolha do time para o jogador 1
        Label teamLabel = new Label("Escolha o time do Jogador 1:");
        ToggleGroup teamGroup = new ToggleGroup();
        RadioButton xButton = new RadioButton("X");
        RadioButton oButton = new RadioButton("O");
        xButton.setToggleGroup(teamGroup);
        oButton.setToggleGroup(teamGroup);
        xButton.setSelected(true); //seleciona o "X" por padrão

        // Botão Avançar
        Button nextButton = new Button("Próximo");
        nextButton.setOnAction(event -> {
            // Pega os valores dos campos
            String player1Name = player1Field.getText().trim();
            String player1Team = ((RadioButton) teamGroup.getSelectedToggle()).getText();

            if (!player1Name.isEmpty()) {
                PlayerSetupScreen player2Screen = new PlayerSetupScreen(player1Name, player1Team);
                player2Screen.show(stage);
            } else {
                player1Field.setPromptText("Nome Obrigatório!");
                player1Field.setStyle("-fx-border-color: red;");
            }
        });

        // Adiciona ao layout
        root.getChildren().addAll(player1Label, player1Field, teamLabel, xButton, oButton, nextButton);

        // Cena
        Scene scene = new Scene(root, 400,400);
        stage.setScene(scene);
        stage.setTitle("Configuração de jogo Local");
        stage.show();
    }
}
