package com.jsw.common;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		System.out.println(getRiQiBeforeCurDay());
		System.out.println(getRiQiAfterCurDay());
	}

	// --------------------------

	public static String getSysDate(String format, Date StrDate, int year,
			int month, int day) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sFmt = new SimpleDateFormat(format);
		cal.setTime(StrDate);
		if (day != 0) {
			cal.add(cal.DATE, day);
		}
		if (month != 0) {
			cal.add(cal.MONTH, month);
		}
		if (year != 0) {
			cal.add(cal.YEAR, year);

		}
		return sFmt.format(cal.getTime());
	}

	public static String GetSysDate(String format, String StrDate, int year,
			int month, int day) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sFmt = new SimpleDateFormat(format);
		cal.setTime(sFmt.parse((StrDate), new ParsePosition(0)));

		if (day != 0) {
			cal.add(cal.DATE, day);
		}
		if (month != 0) {
			cal.add(cal.MONTH, month);
		}
		if (year != 0) {
			cal.add(cal.YEAR, year);

		}
		return sFmt.format(cal.getTime());
	}
	/**
	 * 默认日期格式
	 */
	public static String DEFAULT_FORMAT = "yyyy-MM-dd";
	public static String DEFAULT_FORMAT_SS = "yyyy-MM-dd HH:mm:ss";
	public static String DEFAULT_FORMAT_YRAR_DAY = "yyyy-MM";
	
	/**
	 * 格式化日期
	 * @param date 日期对象
	 * @return String 日期字符串
	 */
	public static String formatDateForYM(Date date){
		SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT_YRAR_DAY);
		String sDate = f.format(date);
		return sDate;
	}
	
	/**
	 * 格式化日期
	 * @param date 日期对象
	 * @return String 日期字符串
	 */
	public static String formatDateForSS(Date date){
		SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT_SS);
		String sDate = f.format(date);
		return sDate;
	}
	
	/**
	 * 格式化日期
	 * @param date 日期对象
	 * @return String 日期字符串
	 */
	public static String formatDate(Date date){
		SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
		String sDate = f.format(date);
		return sDate;
	}
	
	/**
	 * 获取当年的第一天
	 * @param year
	 * @return
	 */
	public static Date getCurrYearFirst(){
		Calendar currCal=Calendar.getInstance();  
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearFirst(currentYear);
	}
	
	/**
	 * 获取当年的最后一天
	 * @param year
	 * @return
	 */
	public static Date getCurrYearLast(){
		Calendar currCal=Calendar.getInstance();  
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearLast(currentYear);
	}
	
	/**
	 * 获取某年第一天日期
	 * @param year 年份
	 * @return Date
	 */
	public static Date getYearFirst(int year){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}
	
	/**
	 * 获取某年最后一天日期
	 * @param year 年份
	 * @return Date
	 */
	public static Date getYearLast(int year){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();
		
		return currYearLast;
	}
	
	/**
	 * 获取当前时间的上个月的日期（yyyy-MM）字符转类型
	 * @throws Exception 
	 */
	public static String getBeforeCurMonth() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT_YRAR_DAY);
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		String date = year+"-"+month;
		Date d = sdf.parse(date);
		return formatDateForYM(d);
	}
	
	/**
	* @Method: getBeforeCurDay
	* @Description: (获取当前时间的前一天的日期)
	* @return String
	*/ 
	public static String getRiQiBeforeCurDay(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date date = cal.getTime();
		SimpleDateFormat signTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
		return signTimeFormat.format(date);
	}
	/**
	* @Method: getRiQiAfterCurDay
	* @Description: (获取当前时间的第二天日期)
	* @return String
	*/ 
	public static String getRiQiAfterCurDay(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, +1);
		Date date = cal.getTime();
		SimpleDateFormat signTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
		return signTimeFormat.format(date);
	}
	
}
