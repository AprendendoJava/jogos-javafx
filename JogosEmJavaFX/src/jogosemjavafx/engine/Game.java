/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogosemjavafx.engine;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author william
 */
public abstract class Game {

    /*
     O GraphicsContext assim o jogo pode desenhar as coisas
     */
    protected GraphicsContext gc;
    
    private Canvas canvas;

    /*
     O tamanho da área que podemos desenhar
     */
    float MAX_W;
    float MAX_H;

    public Game(float w, float h) {
        MAX_W = w;
        MAX_H = h;
        canvas = new Canvas(w, h);
        gc = canvas.getGraphicsContext2D();
    }

    public abstract void update();

    public abstract void display();
    
    public Canvas getCanvas() {
        return canvas;
    }

}
