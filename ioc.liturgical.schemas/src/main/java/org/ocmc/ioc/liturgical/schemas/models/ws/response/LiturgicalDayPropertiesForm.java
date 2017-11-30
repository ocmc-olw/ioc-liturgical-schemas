package org.ocmc.ioc.liturgical.schemas.models.ws.response;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;
import org.ocmc.ioc.liturgical.schemas.models.ws.ldp.LiturgicalDayProperties;

/**
 * Model for return a Resource description to a REST requestor.
 * 
 * @author mac002
 *
 */
@Attributes(title = "Liturgical Day Properties", description = "For the date shown below, this gives you the liturgical properties applicable for the date you requested.")
public class LiturgicalDayPropertiesForm extends AbstractModel {
	@Attributes(readonly = true, description = "The liturgical date used for the properties")
	@Expose public String theLiturgicalDate = "";
	@Attributes(readonly = true, description = "The Julian date of the liturgical date")
	@Expose public String theJulianDate = "";
	@Attributes(readonly = true, description = "The Gregorian date of the liturgical date")
	@Expose public String theGregorianDate = "";
	@Attributes(readonly = true, description = "")
	@Expose public String dayOfWeek = "";
	@Attributes(readonly = true, description = "")
	@Expose public int modeOfWeek = 1;
	@Attributes(readonly = true, description = "")
	@Expose public String eothinonNumber = "";
	@Attributes(readonly = true, description = "")
	@Expose public String triodionStartDateLastYear = "";
	@Attributes(readonly = true, description = "")
	@Expose public String triodionStartDateThisYear = "";
	@Attributes(readonly = true, description = "")
	@Expose public String triodionStartDateNextYear = "";
	@Attributes(readonly = true, description = "")
	@Expose public String paschaDateThisYear = "";
	@Attributes(readonly = true, description = "")
	@Expose public String allSaintsDateThisYear = "";
	@Attributes(readonly = true, description = "")
	@Expose public int numberOfSundaysBeforeStartOfTriodion = 0;
	@Attributes(readonly = true, description = "")
	@Expose public int daysUntilStartOfTriodion = 0;
	@Attributes(readonly = true, description = "")
	@Expose public String lastSundayAfterElevationOfCross = "";
	@Attributes(readonly = true, description = "")
	@Expose public int daysSinceLastSundayAfterElevationOfCross = 0;
	@Attributes(readonly = true, description = "")
	@Expose public boolean isTriodion = false;
	@Attributes(readonly = true, description = "")
	@Expose public boolean isPentecostarion = false;
	
	SimpleDateFormat ymd = new SimpleDateFormat("yyyy/MM/dd");
	SimpleDateFormat eymd = new SimpleDateFormat("EEEE yyyy/MM/dd");

	public LiturgicalDayPropertiesForm() {
		super();
		this.serialVersionUID = 1.1;
	}
	
	public LiturgicalDayPropertiesForm(LiturgicalDayProperties day) {
		super();
		this.serialVersionUID = 1.1; // this is used to set a version number for the schema

		/**
		 * Paul: you need to finish this off...
		 * Just like below, for each property in this class, set it by using the day parameter.
		 */
		this.theLiturgicalDate = formattedDate(day.getGregorianCalendar(), ymd);
		this.theJulianDate = formattedDate(day.getTheDayJulian(), ymd);
		this.theGregorianDate = formattedDate(day.getTheDayGregorian(), eymd);
		// complete the rest of the properties
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public int getModeOfWeek() {
		return modeOfWeek;
	}
	public void setModeOfWeek(int modeOfWeek) {
		this.modeOfWeek = modeOfWeek;
	}
	public String getEothinonNumber() {
		return eothinonNumber;
	}
	public void setEothinonNumber(String eothinonNumber) {
		this.eothinonNumber = eothinonNumber;
	}
	public String getTriodionStartDateLastYear() {
		return triodionStartDateLastYear;
	}
	public void setTriodionStartDateLastYear(String triodionStartDateLastYear) {
		this.triodionStartDateLastYear = triodionStartDateLastYear;
	}
	public String getTriodionStartDateThisYear() {
		return triodionStartDateThisYear;
	}
	public void setTriodionStartDateThisYear(String triodionStartDateThisYear) {
		this.triodionStartDateThisYear = triodionStartDateThisYear;
	}
	public String getTriodionStartDateNextYear() {
		return triodionStartDateNextYear;
	}
	public void setTriodionStartDateNextYear(String triodionStartDateNextYear) {
		this.triodionStartDateNextYear = triodionStartDateNextYear;
	}
	public String getPaschaDateThisYear() {
		return paschaDateThisYear;
	}
	public void setPaschaDateThisYear(String paschaDateThisYear) {
		this.paschaDateThisYear = paschaDateThisYear;
	}
	public String getAllSaintsDateThisYear() {
		return allSaintsDateThisYear;
	}
	public void setAllSaintsDateThisYear(String allSaintsDateThisYear) {
		this.allSaintsDateThisYear = allSaintsDateThisYear;
	}
	public int getNumberOfSundaysBeforeStartOfTriodion() {
		return numberOfSundaysBeforeStartOfTriodion;
	}
	public void setNumberOfSundaysBeforeStartOfTriodion(int numberOfSundaysBeforeStartOfTriodion) {
		this.numberOfSundaysBeforeStartOfTriodion = numberOfSundaysBeforeStartOfTriodion;
	}
	public int getDaysUntilStartOfTriodion() {
		return daysUntilStartOfTriodion;
	}
	public void setDaysUntilStartOfTriodion(int daysUntilStartOfTriodion) {
		this.daysUntilStartOfTriodion = daysUntilStartOfTriodion;
	}
	public String getLastSundayAfterElevationOfCross() {
		return lastSundayAfterElevationOfCross;
	}
	public void setLastSundayAfterElevationOfCross(String lastSundayAfterElevationOfCross) {
		this.lastSundayAfterElevationOfCross = lastSundayAfterElevationOfCross;
	}
	public int getDaysSinceLastSundayAfterElevationOfCross() {
		return daysSinceLastSundayAfterElevationOfCross;
	}
	public void setDaysSinceLastSundayAfterElevationOfCross(int daysSinceLastSundayAfterElevationOfCross) {
		this.daysSinceLastSundayAfterElevationOfCross = daysSinceLastSundayAfterElevationOfCross;
	}
	public boolean isTriodion() {
		return isTriodion;
	}
	public void setTriodion(boolean isTriodion) {
		this.isTriodion = isTriodion;
	}
	public boolean isPentecostarion() {
		return isPentecostarion;
	}
	public void setPentecostarion(boolean isPentecostarion) {
		this.isPentecostarion = isPentecostarion;
	}

	
    /**
     * Return the date formatted per the formatter passed in
     * @param c the calendar
     * @param formatter
     * @return
     */
	private String formattedDate(GregorianCalendar c, SimpleDateFormat formatter) {
		try {
			return formatter.format(c.getTime());
		} catch (Exception e) {
			return "error/error/error";
		}
	}

	public String getTheJulianDate() {
		return theJulianDate;
	}

	public void setTheJulianDate(String theJulianDate) {
		this.theJulianDate = theJulianDate;
	}

	public String getTheGregorianDate() {
		return theGregorianDate;
	}

	public void setTheGregorianDate(String theGregorianDate) {
		this.theGregorianDate = theGregorianDate;
	}

	public void setTheLiturgicalDate(String theLiturgicalDate) {
		this.theLiturgicalDate = theLiturgicalDate;
	}

	public String getTheLiturgicalDate() {
		return theLiturgicalDate;
	}

}