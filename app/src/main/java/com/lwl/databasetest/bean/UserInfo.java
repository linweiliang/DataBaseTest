package com.lwl.databasetest.bean;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by LWL on 15/12/25.
 */
public class UserInfo implements Serializable {

	public static final String ID = "_id";
	public static final String USERID = "userId";
	public static final String TOKEN = "token";
	public static final String TOKENSECRET = "tokenSecret";
	public static final String USERNAME = "userName";
	public static final String USERICON = "userIcon";

	private String id;
	private String userId; // 用户id
	private String token;
	private String tokenSecret;
	private String userName;
	private Drawable userIcon;

	public String getId() {
		return id;
	}

	public void setId(String pId) {
		id = pId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String pUserId) {
		userId = pUserId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String pToken) {
		token = pToken;
	}

	public String getTokenSecret() {
		return tokenSecret;
	}

	public void setTokenSecret(String pTokenSecret) {
		tokenSecret = pTokenSecret;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String pUserName) {
		userName = pUserName;
	}

	public Drawable getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(Drawable pUserIcon) {
		userIcon = pUserIcon;
	}
}
