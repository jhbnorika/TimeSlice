package com.android.norika.play.app;

import android.app.Application;

import com.android.norika.play.model.ColorType;

public class LovePlayApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
        ColorType.init(this);
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}

}
