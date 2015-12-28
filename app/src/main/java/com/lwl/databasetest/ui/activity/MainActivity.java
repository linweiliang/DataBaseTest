package com.lwl.databasetest.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lwl.databasetest.R;
import com.lwl.databasetest.bean.UserInfo;
import com.lwl.databasetest.db.DataHelper;
import com.lwl.databasetest.util.LogUtils;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {

	private DataHelper lDataHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

		lDataHelper = new DataHelper(this);//初始化数据库
//		addUserInfo();//增
//		deleteUserInfo("0","deleteUserInfo--1-->:");//第二个参数为tag标志符，删
//		updateUserInfo();//改
		getUserInfo("getUserInfo--1-->:");//查


	}


	/**
	 * 添加用户信息
	 */
	private void addUserInfo(){
		UserInfo lUserInfo = new UserInfo(); //添加信息
		lUserInfo.setUserId("0");
		lUserInfo.setToken("88888888");
		lUserInfo.setTokenSecret("123456");
		lUserInfo.setUserName("lwl");
		lDataHelper.addUserInfo(lUserInfo);
	}

	/**
	 * 删除用户信息
	 * @param userId
	 * @param tag 标记使用来源
	 */
	private void deleteUserInfo(String userId,String tag){
		lDataHelper.delUserInfo(userId);
		int a = lDataHelper.delUserInfo("0");
		LogUtils.d(TAG, tag + a);
	}


	/**
	 * 把userId为0的userId更改信息
	 */
	 private void updateUserInfo(){
		 UserInfo pUserInfo = new UserInfo();
		 pUserInfo.setUserId("0");
		 pUserInfo.setToken("999999");
		 pUserInfo.setTokenSecret("654321");
		 pUserInfo.setUserName("lwl");
		 lDataHelper.updateUserInfo(pUserInfo);
	 }

	/**
	 * 查询用户信息
	 */
	private void getUserInfo(String tag){
		ArrayList<UserInfo> lList = null;
		lList = (ArrayList<UserInfo>) lDataHelper.getUserList(true);
		LogUtils.d(TAG,tag+lList);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		lDataHelper.close();
	}
}
