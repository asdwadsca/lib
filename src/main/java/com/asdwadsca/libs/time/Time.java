package com.asdwadsca.libs.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该类用于时间处理相关内容
 */
public class Time {
    /**
     * 该方法会将时间格式化为String类型的值并返回
     */
    public static String TimeRead(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
