package com.lwl.androidprojectstructuremode.util;

import android.util.Log;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2014/6/23.
 * 数据验证类
 */
public class Validate {

    /**
     * 集合非空验证
     * @param collection
     * @return
     */
    public static boolean isBlank(Collection collection){
        if(collection==null||collection.size()<=0)
            return true;
        return false;
    }

    /**
     * 对象非空验证
     * @param obj
     * @return
     */
    public static boolean isBlank(Object obj){
        if(obj==null)
            return true;
        return false;
    }

    /**
     * 字符串非空验证
     * @param str
     * @return
     */
    public static boolean isBlank(String str){
        if(str==null||str.trim().length()<=0)
            return true;
        return false;
    }

    /**
     * 数组非空验证
     * @param array
     * @return
     */
    public static boolean isBlank(Object[] array){
        if(array==null||array.length<=0)
            return true;
        return false;
    }

    /**
     * map非空验证
     * @param map
     * @return
     */
    public static boolean isBlank(Map map){
        if(map==null||map.size()<=0)
            return true;
        return false;
    }

    /**
     * 判断是否整型
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        return str.matches("[\\d]+");
    }

    /**
     * 判断是否浮点型
     * @param str
     * @return
     */
    public static boolean isDouble(String str) {
        return str.matches("[\\d.]+");
    }

    /**
     * 判断是否手机号
     * @param str
     * @return
     */
    public static boolean isPhoneNumber(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][0-9][0-9]{9}$");
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    /**
     * 验证邮箱
     * @param line
     * @return
     */
    public static boolean isEmail(String line){
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(line);
        return m.find();
    }

    /**
     * 是否为ip:端口格式
     * @param address
     * @return
     */
    public static boolean isIpPort(String address){
        if(isBlank(address))
            return false;
        try{
            address = address.trim();
            String[] sp = address.split(":");//http://210.3.34.20:9090
            if(sp.length!=2)
                return false;
            if(Integer.parseInt(sp[1])>65535||Integer.parseInt(sp[1])<1)
                return false;
            String[] s = sp[0].split("\\.");
            if(s.length!=4)
                return false;
            for(String ip:s){
                if(Integer.parseInt(ip)<1||Integer.parseInt(ip)>255)
                    return false;
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            Log.d("Test","validate isIpPort error");
            return false;
        }
    }

    /**
     * 是否为ip:端口格式
     * @param address
     * @return
     */
    public static boolean isHttpIpPort(String address){
        if(isBlank(address))
            return false;
        try{
            address = address.trim();
            if(!address.contains("http://")&&!address.contains("https://"))
                return false;
            address=address.replace("http://","").replace("https://","");
            String[] sp = address.split(":");//http://210.3.34.20:9090
            if(sp.length!=2)
                return false;
            if(Integer.parseInt(sp[1])>65535||Integer.parseInt(sp[1])<1)
                return false;
            String[] s = sp[0].split("\\.");
            if(s.length!=4)
                return false;
            for(String ip:s){
                if(Integer.parseInt(ip)<1||Integer.parseInt(ip)>255)
                    return false;
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            Log.d("Test","validate isIpPort error");
            return false;
        }
    }

    /**
     * 只能是中文、英文、数字
     * @param content
     * @return
     */
    public static boolean inputIsLegal(String content){
        String regex="^[a-zA-Z0-9\u4E00-\u9FA5]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match=pattern.matcher(content);
        return match.matches();
    }

    /**
     * 只能是英文、数字
     * @param content
     * @return
     */
    public static boolean inputIsLegal2(String content){
        String regex="^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match=pattern.matcher(content);
        return match.matches();
    }

    /**
     *中文、英文、数字、标点
     * @param content
     * @return
     */
    public static boolean inputIsLegal3(String content){
        String regex="^[a-zA-Z0-9\u4E00-\u9FA5,.!?。 ，#？！]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match=pattern.matcher(content);
        return match.matches();
    }

    public static boolean extNameIsMatched(String fileName ,int fileType) {
        String regex = "";
        switch (fileType) {
            case 0:
                regex = "^.*?\\.(3gp|mp4|avi|wmv|flv|mkv)$";
                break;
            case 1:
                regex = "^.*?\\.(m4a|mp3|mid|wav|xmf|ogg|wma)$";
                break;
            case 2:
                regex = "^.*?\\.(txt|ppt|xls|doc|pdf|pptx|xlsx|docx)$";
                break;
            case 3:
                regex = "^.*?\\.(apk)$";
                break;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher match=pattern.matcher(fileName);
        return match.matches();
    }
}
