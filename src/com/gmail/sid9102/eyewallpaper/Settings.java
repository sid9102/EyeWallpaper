package com.gmail.sid9102.eyewallpaper;

import rajawali.wallpaper.Wallpaper;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;

// Deprecated PreferenceActivity methods are used for API Level 10 (and lower) compatibility
// https://developer.android.com/guide/topics/ui/settings.html#Overview
@SuppressWarnings("deprecation")
public class Settings extends PreferenceActivity implements
		SharedPreferences.OnSharedPreferenceChangeListener {

	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);		
		getPreferenceManager().setSharedPreferencesName("eyePrefs");
		addPreferencesFromResource(R.xml.preferences);
		getPreferenceManager().getSharedPreferences()
				.registerOnSharedPreferenceChangeListener(this);
	}

	protected void onResume() {
		super.onResume();
	}

	protected void onDestroy() {
		getPreferenceManager().getSharedPreferences()
				.unregisterOnSharedPreferenceChangeListener(this);
		super.onDestroy();
	}

	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
	}
}