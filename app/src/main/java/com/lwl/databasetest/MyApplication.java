package com.lwl.androidprojectstructuremode;

import android.app.Application;

import com.lwl.androidprojectstructuremode.phoneInfo.PhoneInfo;

/**
 * Created by LWL on 15/12/25.
 */
public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		PhoneInfo.init(this);
	}
}
