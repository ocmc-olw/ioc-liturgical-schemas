package org.ocmc.ioc.liturgical.schemas.id.managers;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;

/**
 * Manages Library-Topic-Key IDs, where parts are delimited by Constants.ID_DELIMITER.
 * 
 * @author mac002
 *
 */
public class LTKIdManager {
	private String delimiter =  Constants.ID_DELIMITER;
	private String splitter = Constants.ID_SPLITTER;
	private IdManager library;
	private IdManager topic;
	private IdManager key;
	
	/**
	 * Constructor for the LTKId Manager
	 * @param library of the ID
	 * @param topic  of the ID
	 * @param key  of the ID
	 */
	public LTKIdManager(String library, String topic, String key) {
		this.library = new IdManager(library);
		this.topic = new IdManager(topic);
		this.key = new IdManager(key);
	}
	
	/**
	 * Get the delimiter used with this ID's parts
	 * @return the delimiter used with this ID's parts
	 */
	public String getDelimiter() {
		return delimiter;
	}

	/**
	 * Set the delimiter for the ID parts
	 * @param delimiter the delimiter to use to separate the ID parts
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	/**
	 * Get the splitter used for breaking this
	 * ID into its parts
	 * @return the splitter used for breaking the ID into parts
	 */
	public String getSplitter() {
		return splitter;
	}

	/**
	 * Set the splitter used to break this ID into its parts
	 * @param splitter used to break this ID into its parts
	 */
	public void setSplitter(String splitter) {
		this.splitter = splitter;
	}

	/**
	 * Get the library part of the ID
	 * @return the library part of the ID
	 */
	public IdManager getLibrary() {
		return library;
	}

	/**
	 * Set the library part of the ID
	 * @param library the library part of the ID
	 */
	public void setLibrary(IdManager library) {
		this.library = library;
	}
	
	/**
	 * Use the library, topic, and key parts of another doc's ID
	 * as the library for this ID
	 * @param library library part
	 * @param topic topic part
	 * @param key key part
	 */
	public void setLibraryAsId(String library, String topic, String key) {
		this.library = new IdManager(library, topic, key);
	}

	/**
	 * Get the topic part of the ID
	 * @return the topic part of the ID
	 */
	public IdManager getTopic() {
		return topic;
	}

	/**
	 * Set the topic part of the ID
	 * @param topic the topic part of the ID
	 */
	public void setTopic(IdManager topic) {
		this.topic = topic;
	}

	/**
	 * Use the library, topic, and key parts of another doc's ID
	 * as the topic for this ID
	 * @param library library part
	 * @param topic topic part
	 * @param key key part
	 */
	public void setTopicAsId(String library, String topic, String key) {
		this.topic = new IdManager(library, topic, key);
	}

	/**
	 * Get the key for this ID
	 * @return the key for this ID
	 */
	public IdManager getKey() {
		return key;
	}

	/**
	 * Set the key for this ID
	 * @param key the key for this ID
	 */
	public void setKey(IdManager key) {
		this.key = key;
	}

	/**
	 * Use the library, topic, and key parts of another doc's ID
	 * as the key for this ID
	 * @param library part
	 * @param topic part
	 * @param key part
	 */
	public void setKeyAsId(String library, String topic, String key) {
		this.key = new IdManager(library, topic, key);
	}

	/**
	 * Is another's doc's ID being used for this doc's
	 * library?
	 * @return true if this the library part of the ID is another doc's ID
	 */
	public boolean isComplexLibrary() {
		return library.partCount() > 1;
	}
	
	/**
	 * Is another's doc's ID being used for this doc's
	 * topic?
	 * @return  true if this the topic part of the ID is another doc's ID
	 */
	public boolean isComplexTopic() {
		return topic.partCount() > 1;
	}
	
	/**
	 * Is another's doc's ID being used for this doc's
	 * key?
	 * @return  true if this the key part of the ID is another doc's ID
	 */
	public boolean isComplexKey() {
		return key.partCount() > 1;
	}
	
	/**
	 * Is another's doc's ID being used for this doc's
	 * library, topic, or key?
	 * @return true if either the library, topic, or key is the ID of another doc
	 */
	public boolean isComplexId() {
		return isComplexLibrary() || isComplexTopic() || isComplexKey();
	}
	
}
