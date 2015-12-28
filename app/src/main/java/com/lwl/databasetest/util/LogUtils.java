package com.lwl.androidprojectstructuremode.util;

import android.util.Log;

/**
 * Created by LWL on 2015/2/5.
 */
public class LogUtils {

    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int ASSERT = 6;
    public static final int NOTHING = 7;
    public static final int LEVEL = VERBOSE;

    public static void v(String tag,String context){
        if (LEVEL<=VERBOSE){
            Log.v(tag, context);
        }
    }

    public static void d(String tag,String context){
        if (LEVEL<=DEBUG){
            Log.d(tag, context);
        }
    }

    public static void i(String tag,String context){
        if (LEVEL<=INFO){
            Log.i(tag, context);
        }
    }

    public static void w (String tag,String context){
        if (LEVEL<=WARN){
            Log.w(tag, context);
        }
    }

    public static void e(String tag,String context){
        if (LEVEL<=ERROR){
            Log.e(tag, context);
        }
    }
    }
