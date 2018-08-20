package com.pinyougou.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 
 * @author:  描述: 时间工具类集合
 * @date: 
 * @version: 
 */
public class DateUtils {

	public static final String YEARS = "YEARS";
	public static final String MONTHS = "MONTHS";
	public static final String DAYS = "DAYS";
	public static final String HOURS = "HOURS";
	public static final String MINUTES = "MINUTES";
	public static final String SECONDS = "SECONDS";

	/**
	 * @Description: unit 参数通过 DateUtils.DAYS 的方式获取
	 * @Description: 可获取多少年前，多少月前，多少日前，多少小时前，多少分钟前，多少秒前时间(timeCount为负数)
	 * @Description: 可获取多少年后，多少月后，多少日后，多少小时后，多少分钟后，多少秒后时间(timeCount为正数)
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param date
	 * @param timeCount
	 * @param unit
	 * @return: LocalDate
	 */
	public static LocalDate getNDayAgoOrLaterTime(LocalDate date, int timeCount, String unit) {
		LocalDate ld = null;
		switch (unit) {
		case "YEARS":
			ld = date.plus(timeCount, ChronoUnit.YEARS);
			break;
		case "MONTHS":
			ld = date.plus(timeCount, ChronoUnit.MONTHS);
			break;
		case "DAYS":
			ld = date.plus(timeCount, ChronoUnit.DAYS);
			break;
		case "HOURS":
			ld = date.plus(timeCount, ChronoUnit.HOURS);
			break;
		case "MINUTES":
			ld = date.plus(timeCount, ChronoUnit.MINUTES);
			break;
		case "SECONDS":
			ld = date.plus(timeCount, ChronoUnit.SECONDS);
			break;
		}
		return ld;
	}

	/*
	 * 指定日期加上天数后的日期
	 * 
	 * @param num 为增加的天数
	 * 
	 * @param newDate 创建时间
	 * 
	 * @return
	 * 
	 * @throws ParseException*
	 */
	public static String plusDay(int num, String newDate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currdate = format.parse(newDate);
		System.out.println("现在的日期是：" + currdate);
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
		currdate = ca.getTime();
		String enddate = format.format(currdate);
		System.out.println("增加天数以后的日期：" + enddate);
		return enddate;
	}

	public static Date addDate(Date date, long day) throws ParseException {
		long time = date.getTime(); // 得到指定日期的毫秒数
		day = day * 24 * 60 * 60 * 1000; // 要加上的天数转换成毫秒数
		time += day; // 相加得到新的毫秒数
		return new Date(time); // 将毫秒数转换成日期
	}
	
	public static Date removeDate(Date date, long day) throws ParseException {
		long time = date.getTime(); // 得到指定日期的毫秒数
		day = day * 24 * 60 * 60 * 1000; // 要加上的天数转换成毫秒数
		time -= day; // 相加得到新的毫秒数
		return new Date(time); // 将毫秒数转换成日期
	}


	public static Date removeOneMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, -1);
		return calendar.getTime();
	}

	/**
	 * @Description: 获取两个时间包含多少天/月/年
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param minTime
	 * @param maxTime
	 * @param unit
	 * @return
	 * @return: int
	 */
	public static int dateDifference(LocalDate minTime, LocalDate maxTime, String unit) {
		int days = 0;
		Period periodToNextJavaRelease = Period.between(minTime, maxTime);
		switch (unit) {
		case "YEARS":
			days = periodToNextJavaRelease.getYears();
			break;
		case "MONTHS":
			days = periodToNextJavaRelease.getMonths();
			break;
		case "DAYS":
			days = periodToNextJavaRelease.getDays();
			break;
		}
		return days;
	}

	/**
	 * @Description: Date 类型 转 LocalDate类型
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param date
	 * @return
	 * @return: LocalDate
	 */
	public static LocalDate dateParseLocalDate(Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		return localDateTime.toLocalDate();
	}

	/**
	 * @Description: LocalDate 类型 转 Date类型
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date LocalDateParseDate(LocalDate localDate) {
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
		return Date.from(instant);
	}

	/**
	 * @Description: Date类型 返回YYYYMMDD String类型
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static String returnDateYYYYMMDD(Date date) {
		if (!OpinionUtils.notEmpty(date))
			return "错误的时间类型";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}

	public static String returnDateYYYYMMDD2(Date date) {
		if (!OpinionUtils.notEmpty(date))
			return "错误的时间类型";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * @Description: Date类型 返回YYYY-MM-DD HH:mm:ss String类型
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static String returnDateYYYYMMDDHHmmss(Date date) {
		if (!OpinionUtils.notEmpty(date))
			return "错误的时间类型";
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 获取时间，短信上用到
	 * 
	 * @Description: TODO
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param date
	 * @return
	 * @return: String
	 */
	public static String returnNormalDate(Date date) {
		if (!OpinionUtils.notEmpty(date))
			return "错误的时间类型";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}

	/**
	 * @Description: YYYY-MM-DD HH:mm:ss("2017-06-12 21:10:28") String类型 转
	 *               Date类型
	 * @Description: YYYY-MM-DD("2017-06-12") String类型 转 Date类型
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date returnDate(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			if (StringUtils.isNotEmpty(date)) {
				return sdf.parse(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Description: 时间对比(判断时间①是否大于/等于/小于参数2)--如果大于返回毫秒差(正数)/如果等于返回0/如果小于返回毫秒差(负数)
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param arg1
	 * @param arg2
	 * @return
	 * @return: boolean
	 */
	public static long dateCompare(Date arg1, Date arg2) {

		/**
		 * 判断参数是否合法
		 */
		if (arg1 == null || arg2 == null)
			return -1;

		/**
		 * 获取差额
		 */
		long differ = arg1.getTime() - arg2.getTime();

		/**
		 * 返回参数
		 */
		return differ;
	}

	// public static Date formatDate(Date date){
	// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	// try {
	// format.parse(date.toString());
	// } catch (ParseException e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * 
	 * @Description: 计算当前时间距离今晚0点还有多少秒，
	 * @author: 
	 * @date: 
	 * @version: 
	 * @return
	 * @return: int
	 */
	public static int nowToZeroOfSecond() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.MILLISECOND, 999);
		// 今晚0点毫秒数
		long zeroMillis = cal.getTimeInMillis();
		// 当前毫秒数
		long currentMillis = System.currentTimeMillis();
		// 返回相差秒数
		return (int) (zeroMillis - currentMillis) / 1000;
	}

	/**
	 * 
	 * @Description: 获取某天凌晨时间
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param localDate
	 * @param plusDays
	 * @return
	 * @return: int
	 */
	public static LocalDate getZero(LocalDate localDate, int plusDays) {
		LocalTime midnight = LocalTime.MIDNIGHT;
		LocalDateTime todayMidnight = LocalDateTime.of(localDate, midnight);
		LocalDateTime tomorrowMidnight = todayMidnight.plusDays(plusDays);
		return tomorrowMidnight.toLocalDate();

	}

	/**
	 * 
	 * @Description: 获取当前时间之前或之后几分钟 minute
	 * @Description: unit 参数通过 DateUtils.DAYS 的方式获取
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param minute
	 * @return
	 * @return: String
	 */
	public static Date getTimeByMinute(int timeCount, String unit) {
		Calendar calendar = Calendar.getInstance();

		switch (unit) {
		case "HOURS":
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + timeCount);
			break;
		case "MINUTES":
			calendar.add(Calendar.MINUTE, timeCount);
			break;
		case "DAYS":
			calendar.add(Calendar.DAY_OF_MONTH, timeCount);
			break;
		}
		return calendar.getTime();
	}
	
	/**
	 * 获取两个时间相差的天数
	 * @Description: TODO
	 * @author: 
	 * @date: 
	 * @version:  
	 * @param date1
	 * @param date2
	 * @return
	 * @return: int
	 */
	public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
       int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年            
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            
            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }
	
	
	
	/** 获取当天的开始时间 */
	public static java.util.Date getDayBegin() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	/** 获取当天的结束时间 */
	public static java.util.Date getDayEnd() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	/** 获取昨天的开始时间 */
	public static Date getBeginDayOfYesterday() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayBegin());
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	/** 获取昨天的结束时间 */
	public static Date getEndDayOfYesterDay() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayEnd());
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	/** 获取明天的开始时间 */
	public static Date getBeginDayOfTomorrow() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayBegin());
		cal.add(Calendar.DAY_OF_MONTH, 1);

		return cal.getTime();
	}

	/** 获取明天的结束时间 */
	public static Date getEndDayOfTomorrow() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayEnd());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/** 获取本周的开始时间 */
	public static Date getBeginDayOfWeek() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
			dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek);
		return getDayStartTime(cal.getTime());
	}

	/** 获取本周的结束时间 */
	public static Date getEndDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getBeginDayOfWeek());
		cal.add(Calendar.DAY_OF_WEEK, 6);
		Date weekEndSta = cal.getTime();
		return getDayEndTime(weekEndSta);
	}

	/** 获取本月的开始时间 */
	public static Date getBeginDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		return getDayStartTime(calendar.getTime());
	}
	
	/** 获取本月的结束时间 */
	public static Date getEndDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(getNowYear(), getNowMonth() - 1, day);
		return getDayEndTime(calendar.getTime());
	}

	/** 获取本年的开始时间 */
	public static java.util.Date getBeginDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DATE, 1);

		return getDayStartTime(cal.getTime());
	}

	/** 获取本年的结束时间 */ 
	public static java.util.Date getEndDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DATE, 31);
		return getDayEndTime(cal.getTime());
	}

	/** 获取某个日期的开始时间 */ 
	public static Timestamp getDayStartTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
				0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new Timestamp(calendar.getTimeInMillis());
	}

	/** 获取某个日期的结束时间 */ 
	public static Timestamp getDayEndTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23,
				59, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return new Timestamp(calendar.getTimeInMillis());
	}

	/** 获取今年是哪一年 */ 
	public static Integer getNowYear() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return Integer.valueOf(gc.get(1));
	}

	/** 获取本月是哪一月 */ 
	public static int getNowMonth() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return gc.get(2) + 1;
	}

	/** 两个日期相减得到的天数 */ 
	public static int getDiffDays(Date beginDate, Date endDate) {

		if (beginDate == null || endDate == null) {
			throw new IllegalArgumentException("getDiffDays param is null!");
		}

		long diff = (endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24);

		int days = new Long(diff).intValue();

		return days;
	}

	/** 两个日期相减得到的毫秒数 */ 
	public static long dateDiff(Date beginDate, Date endDate) {
		long date1ms = beginDate.getTime();
		long date2ms = endDate.getTime();
		return date2ms - date1ms;
	}

	/** 获取两个日期中的最大日期 */ 
	public static Date max(Date beginDate, Date endDate) {
		if (beginDate == null) {
			return endDate;
		}
		if (endDate == null) {
			return beginDate;
		}
		if (beginDate.after(endDate)) {
			return beginDate;
		}
		return endDate;
	}

	/** 获取两个日期中的最小日期 */ 
	public static Date min(Date beginDate, Date endDate) {
		if (beginDate == null) {
			return endDate;
		}
		if (endDate == null) {
			return beginDate;
		}
		if (beginDate.after(endDate)) {
			return endDate;
		}
		return beginDate;
	}


	/** 返回某月该季度的第一个月 */ 
	public static Date getFirstSeasonDate(Date date) {
		final int[] SEASON = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4 };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int sean = SEASON[cal.get(Calendar.MONTH)];
		cal.set(Calendar.MONTH, sean * 3 - 3);
		return cal.getTime();
	}

	/** 返回某个日期下几天的日期 */ 
	public static Date getNextDay(Date date, int i) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) + i);
		return cal.getTime();
		
	}
 
	/** 返回某个日期前几天的日期 */ 
	public static Date getFrontDay(Date date, int i) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - i);
		return cal.getTime();
	}

	/** 获取某年某月到某年某月按天的切片日期集合（间隔天数的日期集合） */ 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getTimeList(int beginYear, int beginMonth, int endYear, int endMonth, int k) {
		List list = new ArrayList();
		if (beginYear == endYear) {
			for (int j = beginMonth; j <= endMonth; j++) {
				list.add(getTimeList(beginYear, j, k));

			}
		} else {
			{
				for (int j = beginMonth; j < 12; j++) {
					list.add(getTimeList(beginYear, j, k));
				}

				for (int i = beginYear + 1; i < endYear; i++) {
					for (int j = 0; j < 12; j++) {
						list.add(getTimeList(i, j, k));
					}
				}
				for (int j = 0; j <= endMonth; j++) {
					list.add(getTimeList(endYear, j, k));
				}
			}
		}
		return list;
	}

	// 
	/** 获取某年某月按天切片日期集合（某个月间隔多少天的日期集合） */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getTimeList(int beginYear, int beginMonth, int k) {
		List list = new ArrayList();
		Calendar begincal = new GregorianCalendar(beginYear, beginMonth, 1);
		int max = begincal.getActualMaximum(Calendar.DATE);
		for (int i = 1; i < max; i = i + k) {
			list.add(begincal.getTime());
			begincal.add(Calendar.DATE, k);
		}
		begincal = new GregorianCalendar(beginYear, beginMonth, max);
		list.add(begincal.getTime());
		return list;
	}

	/** 获取某年某月的第一天日期 */
	public static Date getStartMonthDate(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.getTime();
	}

	/** 获取某年某月的最后一天日期 */ 
	public static Date getEndMonthDate(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(year, month - 1, day);
		return calendar.getTime();
	}
	
	
	
	public static void main(String[] args) throws ParseException {
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", java.util.Locale.US);
		
		Date date = sdf.parse(getNextDay(new Date(),3).toString());
		
		SimpleDateFormat sdf2 =  new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(sdf2.format(getBeginDayOfWeek()));
		System.out.println(sdf2.format(getBeginDayOfMonth()));
		System.out.println(sdf2.format(getBeginDayOfYear()));
		System.out.println(sdf2.format(date)); 
		
		Date date2 = sdf.parse(getNextDay(getBeginDayOfMonth(),3).toString());
		System.out.println(sdf2.format(date2)); 
		System.out.println(getDiffDays(sdf2.parse("2018-01-12"),sdf2.parse("2018-01-10")));
	
		System.out.println(addDate(sdf2.parse("2018-01-02"),1));
		
		String endTime = "2018-04-13 23:59:59";
		Date date3 = new Date();
		String newDate = sdf2.format(date3);
		
		int count = DateUtils.getDiffDays(sdf2.parse(newDate), sdf2.parse(endTime));
		System.err.println(count);*/
		Date s = getTimeByMinute(1, DateUtils.MINUTES);
		System.out.println(s);
	}

}
