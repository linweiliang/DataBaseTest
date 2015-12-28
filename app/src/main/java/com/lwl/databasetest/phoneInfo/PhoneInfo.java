package com.lwl.androidprojectstructuremode.phoneInfo;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by LWL on 15/12/25.
 */
public class PhoneInfo {

	public static TelephonyManager mTelephonyManager = null;


	public static void init(Context pContext) {
		mTelephonyManager = (TelephonyManager) pContext
				.getSystemService(Context.TELEPHONY_SERVICE);
	}

	//获得手机ImeI
	public static String getImeI() {
		return mTelephonyManager.getDeviceId();
	}

	//获得系统版本号
	public static String getSystemVersion() {
		return mTelephonyManager.getDeviceSoftwareVersion();
	}

	//获取到SIM卡唯一编号ID
	public static String getSimSerialNumber() {
		return mTelephonyManager.getSimSerialNumber();
	}

	//获取到客户ID，即IMSid

	public static String getSubscriberId() {
		return mTelephonyManager.getSubscriberId();
	}

	//获取手机号码
	public static String getLine1Number() {
		return mTelephonyManager.getLine1Number();
	}
}
