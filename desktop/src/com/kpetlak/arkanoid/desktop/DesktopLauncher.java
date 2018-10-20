package com.kpetlak.arkanoid.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kpetlak.arkanoid.game.ArkanoidGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = ArkanoidGame.WIDTH;
		config.height = ArkanoidGame.HEIGHT;

		new LwjglApplication(new ArkanoidGame(), config);
	}
}
