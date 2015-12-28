package com.lwl.databasetest;

import android.app.Application;

import com.lwl.databasetest.phoneInfo.PhoneInfo;

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
