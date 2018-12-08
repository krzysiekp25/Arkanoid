package com.kpetlak.arkanoid.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kpetlak.arkanoid.game.ArkanoidGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = ArkanoidGame.WIDTH;
		config.height = ArkanoidGame.HEIGHT;
		config.resizable = false;
		config.title = "ARKANOID";
		config.addIcon("icons/icon.png", Files.FileType.Internal);

		new LwjglApplication(new ArkanoidGame(), config);
	}
}
