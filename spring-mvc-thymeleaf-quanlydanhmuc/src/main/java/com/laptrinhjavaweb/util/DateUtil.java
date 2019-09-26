package com.laptrinhjavaweb.util;

import java.util.Date;

public class DateUtil {

	public static Date getSysdate() {

		Date sysDate = new Date(System.currentTimeMillis());
		return sysDate;
	}

}
