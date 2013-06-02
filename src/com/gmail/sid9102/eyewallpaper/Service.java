package com.gmail.sid9102.eyewallpaper;

import rajawali.wallpaper.Wallpaper;
import android.content.Context;

public class Service extends Wallpaper {
	private Renderer mRenderer;

	public Engine onCreateEngine() {
		mRenderer = new Renderer(this);
		return new WallpaperEngine(this.getSharedPreferences("eyePrefs", Context.MODE_PRIVATE), getBaseContext(), mRenderer, false);
	}
}
