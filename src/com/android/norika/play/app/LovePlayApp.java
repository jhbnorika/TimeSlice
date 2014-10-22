package com.android.norika.play.app;

import android.app.Application;

import com.android.norika.play.model.ColorType;
import com.norika.android.library.util.DebugManager;
import com.norika.android.library.util.DevUtils;

public class LovePlayApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
        ColorType.init(this);

        DebugManager.init(getApplicationContext());
        if (DebugManager.isDebug())
            DevUtils.enableStrictMode();
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
