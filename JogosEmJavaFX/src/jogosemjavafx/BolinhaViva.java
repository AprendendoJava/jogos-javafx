/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogosemjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import jogosemjavafx.engine.Game;
import jogosemjavafx.engine.GameEngine;

/**
 *
 * @author wsiqueir
 */
public class BolinhaViva extends Application {

    @Override
    public void start(Stage s) {
        // Esse é o tamanho da tela do nosso jogo, a área de desenho
        final int largura = 600, altura = 400;
        
        Game bolinhas = new Game(largura, altura) {

            // A velocidade que a bolinha vai se mover
            int velocidadeX = 2, velocidadeY = 2;
            
            // a posição X e Y da bolinha
            int x = 1, y = 1;

            @Override
            public void update() {
                // A bolinha terá sempre a sua posição atualizada
                x += velocidadeX;
                y += velocidadeY;
                // Verificamos se a posição da bolinha está saindo da tela
                if (x > largura || x < 0) {
                    velocidadeX *= -1;
                }
                if (y > altura || y < 0) {
                    velocidadeY *= -1;
                }
            }

            @Override
            public void display() {
                // primeiro desenhos o fundo com a cor cinza claro
                gc.setFill(Color.LIGHTGRAY);
                gc.fillRect(0, 0, largura, altura);
                // vamos fazer da cor vermelha
                gc.setFill(Color.RED);
                // enfim, desenhamos a bolinha com a posição atualizada e o tamanho de 10
                gc.fillOval(x, y, 30, 30);
            }
        };
        
        // aqui a nossa engine em sí, sem ela o jogo não tem vida. 
        //Colocamos 100 quadros por segundos, 
        //o que significa que a tela vai se desenhar 100 vezes por segundo
        GameEngine engine = new GameEngine(100, bolinhas);
        
        // Agora vamos fazer as coisas do JavaFX para ter a nossa aplicação aparecendo quando rodarmos o programa
        s.setScene(new Scene(new StackPane(bolinhas.getCanvas())));
        s.show();

        // taca lhe pau!
        engine.start();
        
        
    }

}
