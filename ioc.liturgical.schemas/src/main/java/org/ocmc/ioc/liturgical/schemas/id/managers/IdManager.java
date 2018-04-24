package org.ocmc.ioc.liturgical.schemas.id.managers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.iso.lang.IsoLangThreeToTwo;
import org.ocmc.ioc.liturgical.utils.ErrorUtils;
import org.ocmc.ioc.liturgical.utils.GeneralUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;

/**
 * Manages multipart IDs, where parts are delimited by the pipe character |
 * There can be any number of parts.
 * For convenience, there are constructors for
 * 4 parts
 * 3 parts
 * 2 parts
 * 
 * There is no need for a single part id.
 * You probably don't need more than four parts to a key.
 * 
 * @author mac002
 *
 */
public class IdManager {
	private static final Logger logger = LoggerFactory.getLogger(IdManager.class);
	public enum COLUMNS {Primary, Center, Right};
	private List<String> idParts = new ArrayList<String>();
	private List<String> libraryParts = new ArrayList<String>();
	private List<String> topicParts = new ArrayList<String>();
	private List<String> keyParts = new ArrayList<String>();
	private String libraryLanguage = null;
	private String libraryCountry = null;
	private String libraryRealm = null;
	private boolean libraryIsDomain = false;
	private String delimiter = Constants.ID_DELIMITER;
	private String splitter = Constants.ID_SPLITTER;
//	private int topicIndex = 1;
//	private int keyIndex = 2;
	
	/**
	 * Parameterless constructor allowed
	 */
	public IdManager() {
	}

	/**
	 * This constructor expects the id to have parts delimited by Constants.ID_DELIMTER
	 * and it should be a simple ID.  That is, there should not be other IDs embedded
	 * into the ID.  If there are, use the constructor that allows you to indicate
	 * where the topic and key parts start.
	 * @param id the ID
	 */
	public IdManager(String id) {
		try {
			String[] parts = id.split(splitter);
			for (String part : parts) {
					idParts.add(part);
			}
			if (parts.length == 3) {
				this.libraryParts.add(parts[0]);
				this.topicParts.add(parts[1]);
				this.keyParts.add(parts[2]);
				this.libraryIsDomain = true;
				this.setDomainParts();
			}
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}
	}

	/**
	 * In the case of a library, topic, or key that embeds another delimited string (e.g. another ID)
	 * this provides a means to indicate where each of the three parts starts.
	 * 
	 * If you use this constructor, then you can subsequently call
	 * getLibrary(), getTopic(), or getKey()
	 * 
	 * @param id the id
	 * @param topicIndex the position at which the topic part of the id starts
	 * @param keyIndex the position at which the key part of the id starts
	 */
	public IdManager(String id, int topicIndex, int keyIndex) {
		try {
			String[] parts = id.split(splitter);
			for (String part : parts) {
					idParts.add(part);
			}
			for (int i = 0; i < topicIndex; i++) {
				this.libraryParts.add(idParts.get(i));
			}
			for (int i = topicIndex; i < keyIndex; i++) {
				this.topicParts.add(idParts.get(i));
			}
			for (int i = keyIndex; i < idParts.size(); i++) {
				this.keyParts.add(idParts.get(i));
			}
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}
	}

	/**
	 * Constructs an ID from the parts of a String array
	 * @param parts the parts from which to construct an  ID
	 */
	public IdManager(String [] parts) {
		try {
				for (String part : parts) {
					idParts.add(part);
				}
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}		
	}
	
	/**
	 * Construct an ID with four parts
	 * @param part1 first part
	 * @param part2 second part
	 * @param part3 third part
	 * @param part4 fourth part
	 */
	public IdManager(
			  String part1
			, String part2
			, String part3
			, String part4
						) {
		idParts.add(part1);
		idParts.add(part2);
		idParts.add(part3);
		idParts.add(part4);
	}

	/**
	 * Construct an ID with 3 parts
	 * @param part1 the first part
	 * @param part2 the second part
	 * @param part3 the third part
	 */
	public IdManager(
			String part1
			, String part2
			, String part3
			) {
		idParts.add(part1);
		idParts.add(part2);
		idParts.add(part3);
		this.libraryParts.add(part1);
		this.setDomainParts();
	}

	/**
	 * Construct an ID with 2 parts
	 * @param part1 the first part of the id
	 * @param part2 the second part of the id
	 */
	public IdManager(
			String part1
			, String part2
			) {
		idParts.add(part1);
		idParts.add(part2);
	}
	
	
	/**
	 * Parses the domain into its constituent parts of language code, country code, and realm.
	 */
	private void setDomainParts() {
		if (this.libraryParts.size() == 1) {
			try {
				String [] parts = this.libraryParts.get(0).split(Constants.DOMAIN_DELIMITER);
				if (parts.length == 3) {
					this.libraryLanguage = parts[0];
					this.libraryCountry = parts[1];
					this.libraryRealm = parts[2];
					this.libraryIsDomain = true;
				}
			} catch (Exception e) {
				
			}
		}
	}
	
	/**
	 * @return the number of parts for this key
	 */
	public int partCount() {
		return idParts.size();
	}
	
	/**
	 * @return the ID with all its parts as a delimited string
	 */
	public String getId() {
		if (idParts.size() > 1) {
			return Joiner.on(Constants.ID_DELIMITER).join(idParts);
		} else {
			return idParts.get(0);
		}
	} 
	
	/**
	 * @return the library part of the ID
	 */
	public String getLibrary() {
		if (this.libraryParts.size() > 1) {
			return Joiner.on(Constants.ID_DELIMITER).join(this.libraryParts);
		} else {
			return this.libraryParts.get(0);
		}
	}
	
	/**
	 * @param library the library part of the ID
	 */
	public void setLibrary(String library) {
		this.libraryParts.clear();
		if (this.idParts.size() == 0) {
			this.idParts.add(library);
		} else {
			this.idParts.set(0, library);
		}
		this.libraryParts.add(library);
		this.setDomainParts();
	}

	/**
	 * @return the Topic part of the ID
	 */
	public String getTopic() {
		if (this.topicParts.size() > 1) {
			return Joiner.on(Constants.ID_DELIMITER).join(this.topicParts);
		} else {
			if (this.topicParts == null || this.topicParts.size() == 0) {
				return "";
			} else {
				return this.topicParts.get(0);
			}
		}
	}
	
	/**
	 * Useful for when the library is being swapped for another.
	 * @return the Topic and Key part of an ID. 
	 */
	public String getTopicKey() {
		return getTopic() + Constants.ID_DELIMITER + getKey();
	}

	/**
	 * @return the topic part of the ID
	 */
	public String getKey() {
		if (this.keyParts.size() > 1) {
			return Joiner.on(Constants.ID_DELIMITER).join(this.keyParts);
		} else {
			return this.keyParts.get(0);
		}
	}

	/**
	 * @return the character used to delimit the parts of the ID
	 */
	public String getDelimiter() {
		return delimiter;
	}
	
	/**
	 * @param index position at which the key starts
	 * @return the value corresponding to the index
	 */
	public String get(int index) {
		try {
			return idParts.get(index);
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}
		return null;
	}

	/**
	 * @return the language part of the library (domain)
	 */
	public String getLibraryLanguage() {
		return libraryLanguage;
	}

	/**
	 * Sets the language part of the library (domain)
	 * @param libraryLanguage the ISO code for the language part of the library
	 */
	public void setLibraryLanguage(String libraryLanguage) {
		this.libraryLanguage = libraryLanguage;
	}

	/**
	 * @return the country part of the library (domain)
	 */
	public String getLibraryCountry() {
		return libraryCountry;
	}

	/**
	 * @param libraryCountry the country part of the library.
	 */
	public void setLibraryCountry(String libraryCountry) {
		this.libraryCountry = libraryCountry;
	}

	/**
	 * @return the realm part of the library
	 */
	public String getLibraryRealm() {
		return libraryRealm;
	}

	/**
	 * @param libraryRealm the realm part of the library
	 */
	public void setLibraryRealm(String libraryRealm) {
		this.libraryRealm = libraryRealm;
	}

	/**
	 * Checks to see if the library is a domain.  If it has three
	 * parts separated by an underscore, it is considered to be a domain.
	 * @return true if the library is a domain
	 */
	public boolean isLibraryDomain() {
		return libraryIsDomain;
	}

	/**
	 * Checks the domain parameter to see if it is a domain,
	 * that is, if it has three parts separated by an underscore.
	 * @param domain to be checked
	 * @return true if it is a domain
	 */
	public boolean isLibraryDomain(String domain) {
		String[] parts = domain.split(Constants.ID_SPLITTER);
		if (parts.length == 1) {
			parts = domain.split(Constants.DOMAIN_SPLITTER);
			return parts.length == 3;
		} else {
			return false;
		}
	}
	
	/**
	 * Create an OSLW entry for this ID and the supplied value
	 * e.g.
	 * 		meMA.Ode6C225 = "Δήμοις τε φαίνει, προσδραμεῖν τῷ Δεσπότῃ."
	 * 
	 * Note: the value will be empty unless:
	 * 1. The size of the library, topic, and key == 1 in all three cases
	 * 2. The library value can be split usng Constants.DOMAIN_DELIMITER and the resulting size is exactly three
	 * @param value for the resource
	 * @return an OSLW entry for this ID and the supplied value
	 */
	public String getAlwbResourceForValue(String value) {
		StringBuffer sb = new StringBuffer();
		if (libraryIsDomain 
				&& this.libraryParts.size() == 1 
				&& this.topicParts.size() == 1 
				&& this.keyParts.size() == 1
				) {
			sb.append(this.keyParts.get(0));
			sb.append(" = ");
			sb.append(GeneralUtils.wrapQuotes(value.trim()));
			sb.append("\n");
		}
		return sb.toString();
	}

/**
 * @return gr\textunderscore gr\textunderscore cog~topic~key (as an example)
 */
public String getOslwPexId() {
	return this.getOslwLibrary() + "~" + this.getTopicKey();
}

/**
 * @return library formated for OSLW
 */
public String getOslwLibrary() {
	return this.getLibraryLanguage() + "\\textunderscore " + this.getLibraryCountry() + "\\textunderscore " + this.getLibraryRealm();
}

/**
 * @param value to format
 * @return value formatted as an OSLW resource
 */
public String getOslwResourceForValue(String value) {
	StringBuffer sb = new StringBuffer();
	if (libraryIsDomain 
			&& this.libraryParts.size() == 1 
			&& this.topicParts.size() == 1 
			&& this.keyParts.size() == 1
			) {
		sb.append("\\itId{");
		sb.append(this.libraryLanguage);
		sb.append("}{");
		sb.append(this.libraryCountry);
		sb.append("}{");
		sb.append(this.libraryRealm);
		sb.append("}{");
		sb.append(this.topicParts.get(0));
		sb.append("}{");
		sb.append(this.keyParts.get(0));
		sb.append("}{\n");
		if (value != null && value.length() > 0) {
			sb.append(value.trim());
			sb.append("\n");
		}
		sb.append("}%\n");
		
		// if this value is an actor, then also add a version that has a colon
		if (this.topicParts.get(0).equals("actors")) {
			sb.append("\\itId{");
			sb.append(this.libraryLanguage);
			sb.append("}{");
			sb.append(this.libraryCountry);
			sb.append("}{");
			sb.append(this.libraryRealm);
			sb.append("}{");
			sb.append(this.topicParts.get(0));
			sb.append("}{");
			sb.append(this.keyParts.get(0) + ".colon");
			sb.append("}{\n");
			sb.append("\\itRid{");
			sb.append(this.topicParts.get(0));
			sb.append("}{");
			sb.append(this.keyParts.get(0) + "\\grcolon");
			sb.append("}");
			sb.append("\n}%\n");
		}
	}
	return sb.toString();
}

/**
 * @return Topic and Key formatted for OSLW
 */
public String getOslwTopicKey() {
	StringBuffer sb = new StringBuffer();
	if (this.topicParts.size() > 0 && this.keyParts.size() > 0) {
		sb.append("{");
		sb.append(this.topicParts.get(0));
		sb.append("}{");
		sb.append(this.keyParts.get(0));
		sb.append("}");
	}
	return sb.toString();
}

/**
 * @return the Topic and Key formatted as an OSLW RID (Relative ID)
 */
public String getOslwRid() {
	StringBuffer sb = new StringBuffer();
	sb.append("\\itRid");
	sb.append(this.getOslwTopicKey());
	return sb.toString();
}

/**
 * @return  the ID formatted as an OSLW SID (Specific ID)
 */
public String getOslwSid() {
	StringBuffer sb = new StringBuffer();
	sb.append("\\itSid");
	sb.append("{");
	sb.append(this.libraryLanguage);
	sb.append("}{");
	sb.append(this.libraryCountry);
	sb.append("}{");
	sb.append(this.libraryRealm);
	sb.append("}{");
	sb.append(this.topicParts.get(0));
	sb.append("}{");
	sb.append(this.keyParts.get(0));
	sb.append("}\n");
	return sb.toString();
}


/**
 * Returns an OSLW ID whose value is a RID redirect to the specified topic and key.
 * A RID is a Relative ID, i.e. one that uses the same domain as the enclosing \it resource.
 *  
 * @param topic to format
 * @param key to format
 * @return an OSLW ID whose value is a RID redirect to the specified topic and key
 */
public String getOslwRedirectRid(String topic, String key) {
	StringBuffer sb = new StringBuffer();
	if (libraryIsDomain 
			&& this.libraryParts.size() == 1 
			&& this.topicParts.size() == 1 
			&& this.keyParts.size() == 1
			) {
		sb.append("\\itId{");
		sb.append(this.libraryLanguage);
		sb.append("}{");
		sb.append(this.libraryCountry);
		sb.append("}{");
		sb.append(this.libraryRealm);
		sb.append("}{");
		sb.append(topic);
		sb.append("}{");
		sb.append(key);
		sb.append("}{\n");
		sb.append("\\itRid{");
		sb.append(this.topicParts.get(0));
		sb.append("}{");
		sb.append(this.keyParts.get(0));
		sb.append("}\n}%\n");
	}
	return sb.toString();
}

/**
 * Returns an OSLW ID whose value is a SID  redirect to the specified topic and key.
 * A SID is a Specific ID. This with use a different domain than the enclosing resource
 *  
 * @param library to format
 * @param topic to format
 * @param key to format
 * @return an OSLW ID whose value is a SID  redirect to the specified topic and key
 */
public String getOslwRedirectSid(String library, String topic, String key) {
	StringBuffer sb = new StringBuffer();
	if (libraryIsDomain 
			&& this.libraryParts.size() == 1 
			&& this.topicParts.size() == 1 
			&& this.keyParts.size() == 1
			) {
		sb.append("\\itId{");
		sb.append(this.libraryLanguage);
		sb.append("}{");
		sb.append(this.libraryCountry);
		sb.append("}{");
		sb.append(this.libraryRealm);
		sb.append("}{");
		sb.append(topic);
		sb.append("}{");
		sb.append(key);
		sb.append("}{\n");
		sb.append("\\itRid{");
		sb.append(this.topicParts.get(0));
		sb.append("}{");
		sb.append(this.keyParts.get(0));
		sb.append("}\n}%\n");
	}
	return sb.toString();
}

/**
 * Get the OSLW set command for the domain
 * @param column the column of the document
 * @return the OSLW set command for the domain
 */
public String getOslwSetDomain(COLUMNS column) {
	StringBuffer sb = new StringBuffer();
	sb.append("\\ltSet" + column.name() + "Domain{");
	sb.append(this.libraryLanguage);
	sb.append("}{");
	sb.append(this.libraryCountry);
	sb.append("}{");
	sb.append(this.libraryRealm);
	sb.append("}%\n");
	return sb.toString();
}
	/**
	 * If the ID is actually a sequence number, e.g.
	 * 
	 * gr_gr_cog~me.m01.d06~L0031
	 * 
	 * this method will return the int number,
	 * 
	 * i.e. 31
	 * 
	 * If unsuccessful, returns -1
	 * @param id to be converted to a sequence number
	 * @return the sequence number
	 */
	public static int getSeqNbr(String id) {
		int result = -1;
		IdManager idManager = new IdManager(id);
		try {
			if (idManager.getKey().startsWith("L")) {
			result = Integer.parseInt(idManager.getKey().substring(1));
			}
		} catch (Exception e) {
			result = -1;
		}
		return result;
	}
	
	/**
	 * Gets the index to use as the starting sequence number for
	 * a window of values before the specified ID.
	 * 
	 * If the ID occurs at a position less than size, the index will be adjusted
	 * accordingly.
	 * 
	 * @param id to use
	 * @param size to use
	 * @return the window prefix index
	 */
	public static int getWindowPrefixIndex(String id, int size) {
		int result = -1;
		int seq = getSeqNbr(id);
		if (seq > -1) {
			result = seq - size;
			if (result < 1) {
				result = 1;
			}
		}
		return result;
	}
	
	/**
	 * Gets the index to use as the starting sequence number for
	 * a window of values before the specified ID.
	 * 
	 * If the ID occurs at a position less than size, the index will be adjusted
	 * accordingly.
	 * 
	 * @param id to use
	 * @param size to use
	 * @return the window suffix index
	 */
	public static int getWindowSuffixIndex(String id, int size) {
		int result = -1;
		int seq = getSeqNbr(id);
		if (seq > -1) {
			result = seq + size;
		}
		return result;
	}

	/**
	 * Pad the value as a valid sequence number as used in the database
	 * L + 5 digits, left padded with zeros
	 * 
	 * and return library~topic~line number
	 * @param library to use
	 * @param topic to use
	 * @param value to use
	 * @return sequence number
	 */
	public static String createSeqNbr(String library, String topic, int value) {
		return library + "~" + topic + "~" + GeneralUtils.padNumber("L", 5, value);
	}
	
	public Locale getLocale() {
		Locale result = new Locale("en","US");
		if (this.libraryLanguage!= null && this.libraryLanguage.length() > 0) {
			try {
				result = new Locale(
						IsoLangThreeToTwo.threeToTwo(
								this.libraryLanguage)
								, this.libraryCountry
						);
			} catch (Exception e) {
				ErrorUtils.report(logger, e);
			}
		}
		return result;
	}
	
	/**
	 * Returns the specified date, formatted for the locale of the ID language and country,
	 * If not found, it will be formatted for English.
	 * Note, per the Java Locale documentation:
	 * When a language has both an alpha-2 code and an alpha-3 code, the alpha-2 code must be used.
	 * See also org.ocmc.ioc.liturgical.schemas.iso.lang.LocaleDate, which has more capabilities.
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
					.ofLocalizedDate(FormatStyle.FULL)
					.withLocale(this.getLocale());
			result = date.format(pattern);
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}
		return result;
	}
	
	public static String dataKeyToId(String dataKey) {
		StringBuffer result = new StringBuffer();
		try {
			String [] parts = dataKey.split(Constants.PIPE_SPLITTER);
			if (parts.length == 2) {
				String key = parts[1];
				parts = parts[0].split(Constants.DOMAIN_DELIMITER);
				if (parts.length == 4) {
					String topic = parts[0];
					String library = parts[1] + "_" + parts[2] + "_" + parts[3];
					result.append(library);
					result.append(Constants.ID_DELIMITER);
					result.append(topic);
					result.append(Constants.ID_DELIMITER);
					result.append(key);
				}
			}
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}
		return result.toString();
	}
	
}
