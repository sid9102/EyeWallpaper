package com.gmail.sid9102.eyewallpaper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class UserPrefs {

	private static final String disembodied = "pref_disembodied";

	private static UserPrefs mUserPrefs;

	private SharedPreferences mSharedPrefs;

	private UserPrefs(final Context context) {
		mSharedPrefs = context.getSharedPreferences("eyePrefs", Context.MODE_PRIVATE);
		init();
	}

	public static final UserPrefs getInstance(final Context context) {
		if (mUserPrefs == null)
			mUserPrefs = new UserPrefs(context);

		return mUserPrefs;
	}

	public boolean getBody() {
		return mSharedPrefs.getBoolean(disembodied, false);
	}

	public void setBody(boolean disembody) {
		mSharedPrefs.edit().putBoolean(disembodied, disembody)
				.commit();
	}

	/**
	 * Good time to verify any data. In this instance I just want to see the
	 * default value for the box color. This is not really necessary I just
	 * wanted to have an example.
	 */
	private final void init() {
		final Editor editor = mSharedPrefs.edit();

		// This could easily be done in the preferences XML
		if (!mSharedPrefs.contains(disembodied)) {
			editor.putBoolean(disembodied, false);
		}

		editor.commit();
	}

}