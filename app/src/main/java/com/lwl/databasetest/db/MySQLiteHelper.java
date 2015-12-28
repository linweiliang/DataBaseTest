package com.lwl.databasetest.db;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lwl.databasetest.bean.UserInfo;


/**
 * Created by LWL on 15/12/25.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

	//用来保存UserID、Access Token、Access Secret的表名
	public static final String TB_NAME = "users";


	public MySQLiteHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}


	//创建表
	@Override
	public void onCreate(SQLiteDatabase db) {
//		if (tabIsExist(db, TB_NAME)) {
//
//		}else {
			try {
				db.execSQL("CREATE TABLE IF NOT EXISTS " +
								TB_NAME + "(" +
								UserInfo.ID + " integer primary key," +
								UserInfo.USERID + " varchar," +
								UserInfo.TOKEN + " varchar," +
								UserInfo.TOKENSECRET + " varchar," +
								UserInfo.USERNAME + " varchar," +
								UserInfo.USERICON + " blob" +
								")"
				);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Log.e("Database", "onCreate");
		}
//	}

	//更新表
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TB_NAME);
		onCreate(db);
		Log.e("Database", "onUpgrade");
	}

	//更新列
	public void updateColumn(SQLiteDatabase db, String oldColumn, String newColumn, String typeColumn) {
		try {
			db.execSQL("ALTER TABLE " +TB_NAME + " CHANGE " +oldColumn + " " + newColumn +" " + typeColumn
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 判断某张表是否存在
	 * @param tabName 表名
	 * @return
	 */
	private  boolean tabIsExist(SQLiteDatabase db,String tabName){
		boolean result = false;
		if(tabName == null){
			return false;
		}
		Cursor cursor = null;
		try {

			String sql = "select count(*) as c from sqlite_master where type ='table' and name ='"+tabName.trim()+"' ";
			cursor = db.rawQuery(sql, null);
			if(cursor.moveToNext()){
				int count = cursor.getInt(0);
				if(count>0){
					result = true;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

}

