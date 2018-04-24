package org.ocmc.ioc.liturgical.schemas.iso.lang;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.utils.ErrorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocaleDate {
	private static final Logger logger = LoggerFactory.getLogger(LocaleDate.class);
	private Locale locale = null;
	private String dateFull = "";
	private String dateMedium = "";
	private String dateShort = "";
	private String month = "";
	private String monthNameFull = "";
	private String monthNameShort = "";
	private String year = "";
	private String day = "";
	private String dayOfWeekFull = "";
	private String dayOfWeekShort = "";
	private String dayOfWeekAlt = "";
	private String monthYear = "";
	private String key = "";
	private String topicKey = "";
	
	public LocaleDate(
			Locale locale
			, String year
			, String month
			, String day
			) {
		this.locale = locale;
		this.year = year;
		this.month = month;
		this.day = day;
		this.monthYear = month + "/" + year;
		try {
			int theYear = Integer.parseInt(year);
			int theMonth = (Integer.parseInt(month)); 
			int theMonthDay = Integer.parseInt(day);
			this.key = "y" + year 
					+ ".m" + String.format("%02d", theMonth) 
					+ ".d" + String.format("%02d", theMonthDay);
			this.topicKey = Constants.ID_DELIMITER
					+ Constants.TOPIC_CALENDAR 
					+ Constants.ID_DELIMITER 
					+ this.key
					;
			LocalDate date = LocalDate.of(theYear, theMonth, theMonthDay);
			DateTimeFormatter pattern = DateTimeFormatter
					.ofLocalizedDate(FormatStyle.FULL)
					.withLocale(this.locale);
			this.dateFull = date.format(pattern);
			pattern = DateTimeFormatter
					.ofLocalizedDate(FormatStyle.MEDIUM)
					.withLocale(this.locale);
			this.dateMedium = date.format(pattern);
			pattern = DateTimeFormatter
					.ofLocalizedDate(FormatStyle.SHORT)
					.withLocale(this.locale);
			this.dateShort = date.format(pattern);
			// month
			pattern = DateTimeFormatter
					.ofPattern("MMMM")
					.withLocale(this.locale);
			this.monthNameFull = date.format(pattern);
			pattern = DateTimeFormatter
					.ofPattern("MM")
					.withLocale(this.locale);
			this.monthNameShort = date.format(pattern);
			// day of week
			pattern = DateTimeFormatter
					.ofPattern("EEEE")
					.withLocale(this.locale);
			this.dayOfWeekFull = date.format(pattern);
			pattern = DateTimeFormatter
					.ofPattern("EE")
					.withLocale(this.locale);
			this.dayOfWeekShort = date.format(pattern);
			pattern = DateTimeFormatter
					.ofPattern("e MMMM (EEEE)")
					.withLocale(this.locale);
			this.dayOfWeekAlt = date.format(pattern);
			// month year
			pattern = DateTimeFormatter
					.ofPattern("MMMM yyyy")
					.withLocale(this.locale);
			this.monthYear =  date.format(pattern);
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}
	}
	
	/**
	 * Returns the specified date, formatted for the locale of the ID language and country,
	 * If not found, it will be formatted for English.
	 * Note, per the Java Locale documentation:
	 * When a language has both an alpha-2 code and an alpha-3 code, the alpha-2 code must be used.
	 * @param year to use
	 * @param month to use
	 * @param day to use
	 * @return the date formatted for the language code locale
	 */
	public String getLocaleDate(String year, String month, String day) {
		String result = "";
		try {
			int theYear = Integer.parseInt(year);
			int theMonth = (Integer.parseInt(month)); 
			int theMonthDay = Integer.parseInt(day);
			LocalDate date = LocalDate.of(theYear, theMonth, theMonthDay);
			DateTimeFormatter pattern = DateTimeFormatter
//					.ofLocalizedDate(FormatStyle.FULL)
					.ofPattern("MMMM")
					.withLocale(this.locale);
			result = date.format(pattern);
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}
		return result;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getDateFull() {
		return dateFull;
	}

	public void setDateFull(String dateFull) {
		this.dateFull = dateFull;
	}

	public String getDateMedium() {
		return dateMedium;
	}

	public void setDateMedium(String dateMedium) {
		this.dateMedium = dateMedium;
	}

	public String getDateShort() {
		return dateShort;
	}

	public void setDateShort(String dateShort) {
		this.dateShort = dateShort;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getMonthNameFull() {
		return monthNameFull;
	}

	public void setMonthNameFull(String monthNameFull) {
		this.monthNameFull = monthNameFull;
	}

	public String getMonthNameShort() {
		return monthNameShort;
	}

	public void setMonthNameShort(String monthNameShort) {
		this.monthNameShort = monthNameShort;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDayOfWeekFull() {
		return dayOfWeekFull;
	}

	public void setDayOfWeekFull(String dayOfWeekFull) {
		this.dayOfWeekFull = dayOfWeekFull;
	}

	public String getDayOfWeekShort() {
		return dayOfWeekShort;
	}

	public void setDayOfWeekShort(String dayOfWeekShort) {
		this.dayOfWeekShort = dayOfWeekShort;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTopicKey() {
		return topicKey;
	}

	public void setTopicKey(String topicKey) {
		this.topicKey = topicKey;
	}

	public String getDayOfWeekAlt() {
		return dayOfWeekAlt;
	}

	public void setDayOfWeekAlt(String dayOfWeekAlt) {
		this.dayOfWeekAlt = dayOfWeekAlt;
	}

}
