package com.android.norika.play.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

	public static String getCurrentData() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		return sdf.format(date);
	}

	public static String getRemainTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date deadLine = null;
		try {
			deadLine = sdf.parse("2012-12-21 18:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
			return "解析有误";
		}

		long times_second = deadLine.getTime() - System.currentTimeMillis();

		StringBuffer sb = new StringBuffer("");
		long years = times_second / (1L * 365 * 24 * 60 * 60 * 1000);
		if (years > 0)
			sb.append(years + " 年");

		times_second -= years * 365 * 24 * 60 * 60 * 1000;
		long days = times_second / (1L * 24 * 60 * 60 * 1000);
		if (days > 0)
			sb.append(days + " 天");

		String times = sb.toString().trim();

		return times.equals("") ? "时间已截止" : times;
	}
}
