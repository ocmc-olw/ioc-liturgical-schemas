package org.ocmc.ioc.liturgical.schemas.models.db.stats;

import com.google.gson.annotations.Expose;

import java.time.Instant;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;

/**
 * Keeps statistics on country, region, and city of requests to search the liturgical text
 * @author mac002
 *
 */
public class LocationLog extends LTKLite {
	private static String schema = LocationLog.class.getSimpleName();
	private static double version = 1.1;
	
	@Expose  public String lastAccessedTimestamp = "2000-01-01T12:00:23.764Z";
	@Expose  public long count;
	@Expose public String country = "unknown";
	@Expose  public String countryCode = "unknown";
	@Expose public String region = "unknown";
	@Expose public String regionName = "unknown";
	@Expose public String city = "unknown";

	public LocationLog(String countryCode, String region, String city) {
		super(
				Constants.LIBRARY_LOCATION
				, countryCode
				, region + city
				, schema
				, version
				);		
		this.countryCode = countryCode;
		this.region = region;
		this.city = city;
	}

	public String getLastAccessedTimestamp() {
		return lastAccessedTimestamp;
	}

	public void increment() {
		this.lastAccessedTimestamp = Instant.now().toString();
		this.count = count + 1;
	}
	public void setLastAccessedTimestamp(String lastAccessedTimestamp) {
		this.lastAccessedTimestamp = lastAccessedTimestamp;
	}


	public long getCount() {
		return count;
	}


	public void setCount(long count) {
		this.count = count;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getRegionName() {
		return regionName;
	}


	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
