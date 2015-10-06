package com.shuzheng.ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 
 * 日期工具类
 * 
 * @author shuzheng
 * @version 2014/04/14
 * 
 */
public class DateUtil {

	public static String TIMEZONE = "Asia/Shanghai";

	/**
	 * 取得 String 日期
	 * @return
	 */
	public static String getNow() {
		return getNow("yyyy-MM-dd HH:mm:ss");
	}

	public static String getNow(String format) {
		return getNow(format, TIMEZONE);
	}

	public static String getNow(String format, String timezone) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		GregorianCalendar c = new GregorianCalendar();
		TimeZone tz = TimeZone.getTimeZone(timezone);
		c.setTimeZone(tz);
		sdf.setTimeZone(tz);
		return sdf.format(c.getTime());
	}

	/**
	 * String 转 long
	 * 
	 * @param time
	 * @return
	 */
	public static long getTimeMillis(String time) {
		return getTimeMillis(time, "yyyy-MM-dd HH:mm:ss");
	}

	public static long getTimeMillis(String time, String format) {
		return getTimeMillis(time, format, TIMEZONE);
	}

	public static long getTimeMillis(String time, String format, String timezone) {
		if (time.trim().equals(""))
			return 0;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		TimeZone tz = TimeZone.getTimeZone(timezone);
		sdf.setTimeZone(tz);
		long timeMillis = 0L;
		try {
			Date date = sdf.parse(time);
			timeMillis = date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timeMillis;
	}

	/**
	 * long 转 String
	 * 
	 * @param l
	 * @return
	 */
	public static String formatDate(long l) {
		return formatDate(l, "yyyy-MM-dd HH:mm:ss");
	}

	public static String formatDate(long l, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		GregorianCalendar c = new GregorianCalendar();
		TimeZone tz = TimeZone.getTimeZone(TIMEZONE);
		c.setTimeZone(tz);
		c.setTimeInMillis(l);
		return sdf.format(c.getTime());
	}

	/**
	 * 显示几分钟前 几天前 今个月前 几年前形式
	 */
	public static String getPupDate(Date date) {
		Date one = date;
		Date two = new Date();
		long time1 = one.getTime();
		long time2 = two.getTime();
		long diff;
		long day = 0;
		long hour = 0;
		long min = 0;
		String alltime = "";
		// long sec = 0;
		if (time1 < time2) {
			diff = time2 - time1;
		} else {
			diff = time1 - time2;
		}
		day = diff / (24 * 60 * 60 * 1000);
		hour = (diff / (60 * 60 * 1000) - day * 24);
		min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
		// sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
		if ((long) (day / 360) > 0) {
			alltime = (long) (day / 360) + " years ago";
		} else {
			if (day - 1 == 0) {
				alltime = "yesterday";
			} else if (day - 1 < 0) {
				if (hour - 1 <= 0) {
					if (min - 1 > 0) {
						alltime = (min - 1) + " minutes ago";
					} else {
						alltime = "a moment ago";
					}
				} else {
					alltime = (hour - 1) + " hours ago";
				}
			} else {
				// return day + "天" + hour + "小时" + min + "分" + sec + "秒";
				if ((long) (day / 30) > 0) {
					alltime = (long) (day / 30) + " months ago";
				} else {
					if ((long) (day / 7) > 0) {
						alltime = (long) (day / 7) + " weeks ago";
					} else {
						if (day - 1 == 0) {
							alltime = "yesterday";
						} else if (day - 1 == 1) {
							alltime = "the day before yesterday";
						} else {
							alltime = (day - 1) + " days ago";
						}
					}
				}
			}
		}
		return alltime;
	}

	/**
	 * 自定义时间格式
	 * 
	 * @param time
	 * @return
	 */
	public static String getPuptime(long time) {
		// 当前时间毫秒数
		long now = System.currentTimeMillis();
		return getPuptime(now, time);
	}

	public static String getPuptime(long now, long time) {
		// 间隔秒数
		long diff = (now - time) / 1000;
		if (diff < 0) { // 时空混乱
			return "";
		} else if (diff >= 0 && diff < 10) { // 10秒内
			return "刚刚";
		} else if (diff >= 10 && diff < 60) { // 1分钟内
			return diff + "秒前";
		} else if (diff >= 60 && diff < 120) { // 2分钟内
			return "1分钟前";
		} else if (diff >= 120 && diff < 3600) { // 1小时内
			return (diff / 60) + "分钟前";
		} else if (diff >= 3600 && diff < 86400) { // 一天内
			return (diff / 3600) + "小时前";
		} else if (diff >= 86400 && diff < 172800) { // 两天内
			return "昨天";
		} else if (diff >= 172800 && diff < 259200) { // 三天内
			return "前天";
		}
		// else if (diff >= 172800 && diff < 2592000) { // 30天内
		// return (diff / 86400) + "天前";
		// }
		return formatDate(time, "yyyy-MM-dd HH:mm");
	}

	public static String getPuptime2(long time) {
		Date one = new Date(time);
		Date two = new Date();
		long time1 = one.getTime();
		long time2 = two.getTime();
		long diff;
		long day = 0;
		long hour = 0;
		long min = 0;
		String alltime = "";
		if (time1 < time2) {
			diff = time2 - time1;
		} else {
			diff = time1 - time2;
		}
		day = diff / (24 * 60 * 60 * 1000);
		hour = (diff / (60 * 60 * 1000) - day * 24);
		min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);

		if ((long) (day / 360) > 0) { // 大于1年
			// alltime = (long) (day / 360) + " 年前";
			alltime = formatDate(time);
		} else { // 小于1年
			if (day - 1 == 0) { // 昨天
				alltime = "昨天";
			} else if (day - 1 < 0) { // 1天内
				if (hour - 1 <= 0) { // 1小时内
					if (min - 1 > 0) { // 1分钟外
						alltime = (min - 1) + " 分钟前";
					} else { // 1分钟内
						alltime = "刚刚";
					}
				} else { // 1小时外 1天内
					alltime = (hour - 1) + " 小时前";
				}
			} else { // 1天外 1年内
				if ((long) (day / 30) > 0) { // 1月外
					// alltime = (long) (day / 30) + " 月前";
					alltime = formatDate(time);
				} else {
					if ((long) (day / 7) > 0) {
						alltime = (long) (day / 7) + " 星期前";
					} else {
						if (day - 1 == 0) {
							alltime = "昨天";
						} else if (day - 1 == 1) {
							alltime = "前天";
						} else {
							alltime = (day - 1) + " 天前";
						}
					}
				}
			}
		}
		return alltime;
	}
	
}
