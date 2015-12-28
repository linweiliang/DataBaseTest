package com.lwl.databasetest;

import android.app.Application;

import com.lwl.databasetest.phoneInfo.PhoneInfo;

/**
 * Created by LWL on 15/12/25.
 */
public class MyApplication extends Application {
//	private DataHelper lDataHelper;
	@Override
	public void onCreate() {
		super.onCreate();
//		lDataHelper = new DataHelper(this);//初始化数据库
		PhoneInfo.init(this);
	}
}
