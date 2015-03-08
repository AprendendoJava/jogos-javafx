/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jogosemjavafx.engine;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.util.Duration;

/**
 *
 * @author william
 */
public class GameEngine {

    private int frameCount = 0;
    private int frameRate;
    private final Game game;
    private final Timeline gameLoop;

    public GameEngine(int frameRate, Game game) {
        this.frameRate = frameRate;
        this.game = game;
        gameLoop = createLoop();
    }

    public int getFrameCount() {
        return frameCount;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }

    private void run(Event e) {
        frameCount++;
        game.update();
        game.display();
    }

    public void start() {
        gameLoop.playFromStart();
    }

    public void stop() {
        gameLoop.stop();
    }

    private Timeline createLoop() {
        // inspired on https://carlfx.wordpress.com/2012/04/09/javafx-2-gametutorial-part-2/
        final Duration d = Duration.millis(1000 / frameRate);
        final KeyFrame oneFrame = new KeyFrame(d, this::run);
        Timeline t = new Timeline(frameRate, oneFrame);
        t.setCycleCount(Animation.INDEFINITE);
        return t;
    }

}