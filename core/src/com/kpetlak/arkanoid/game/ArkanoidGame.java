package com.kpetlak.arkanoid.game;

import com.badlogic.gdx.Game;
import com.kpetlak.arkanoid.screens.SplashScreen;

public class ArkanoidGame extends Game {

    public static int WIDTH = 720;
    public static int HEIGHT = 480;

    private boolean paused;

	@Override
	public void create () {
		this.setScreen(new SplashScreen(this));
	}

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
}
