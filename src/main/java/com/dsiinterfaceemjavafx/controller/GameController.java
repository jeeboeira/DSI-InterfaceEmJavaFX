package com.dsiinterfaceemjavafx.controller;

import com.dsiinterfaceemjavafx.view.GameBoardScreen;
import com.dsiinterfaceemjavafx.view.GameOverPopup;
import com.jesse.boeira.ds1jogodavelha.core.Jogo;
import com.jesse.boeira.ds1jogodavelha.core.Jogador;
import javafx.stage.Stage;

public class GameController {

    private final Jogo jogo;
    private final GameBoardScreen boardScreen;
    private boolean player1Turn = true; // Define quem joga primeiro

    public GameController(Stage stage, String player1Name, String player2Name) {
        Jogador jogador1 = new Jogador(player1Name, 'X');
        Jogador jogador2 = new Jogador(player2Name, 'O');
        this.jogo = new Jogo(jogador1, jogador2);

        this.boardScreen = new GameBoardScreen();
        this.boardScreen.show(stage, player1Name, 'X', player2Name, 'O', this::handleMove);
    }

    // Trata jogadas no tabuleiro
    private void handleMove(int position, Runnable updateUI) {
        Jogador currentPlayer = player1Turn ? jogo.getJ1() : jogo.getJ2();

        // Realiza a jogada na lógica
        if (jogo.fazerJogada(position, currentPlayer.getTime())) {
            updateUI.run(); // Atualiza a interface visualmente

            if (jogo.ehFimDoJogo()) {
                endGame();
            } else {
                player1Turn = !player1Turn; // Alterna entre os jogadores
            }
        }
    }

    // Finaliza o jogo e exibe resultado
    private void endGame() {
        Jogador vencedor = jogo.temVencedor(jogo.getJ1(), jogo.getJ2());
        String winnerName = (vencedor != null) ? vencedor.getNome() : null;

        if (GameOverPopup.show(winnerName)) {
            jogo.novoJogo();
            player1Turn = true;
            boardScreen.resetBoard(); // Reseta o tabuleiro
        } else {
            System.exit(0); // Fecha o jogo
        }
    }
}
