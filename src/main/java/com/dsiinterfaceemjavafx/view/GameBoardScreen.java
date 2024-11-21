package com.dsiinterfaceemjavafx.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.function.BiConsumer;

public class GameBoardScreen {

    private final Button[][] buttons = new Button[3][3];

    public void show(Stage stage, String player1Name, char player1Symbol, String player2Name, char player2Symbol,
                     BiConsumer<Integer, Runnable> onMove) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Button();
                buttons[i][j].setPrefSize(100, 100);
                buttons[i][j].setStyle("-fx-font-size: 24; -fx-text-fill: black;");

                int position = i * 3 + j;
                buttons[i][j].setOnAction(event -> {
                    onMove.accept(position, () -> {
                        buttons[i][j].setText(player1Symbol == 'X' ? "X" : "O");
                        buttons[i][j].setDisable(true);
                    });
                });

                grid.add(buttons[i][j], j, i);
            }
        }

        Scene scene = new Scene(grid, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Tabuleiro de Jogo");
        stage.show();
    }

    // Reseta o tabuleiro para uma nova partida
    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setDisable(false);
            }
        }
    }
}
