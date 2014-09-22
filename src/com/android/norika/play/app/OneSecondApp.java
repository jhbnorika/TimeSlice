package com.android.norika.play.app;

import com.android.norika.play.model.ColorType;

import android.app.Application;

public class OneSecondApp extends Application {

	@Override
	public void onCreate() {

		ColorType.init(this);
		super.onCreate();
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}

}
