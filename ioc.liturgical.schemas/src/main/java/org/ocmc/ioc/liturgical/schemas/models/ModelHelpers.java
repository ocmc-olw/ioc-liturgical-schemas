package org.ocmc.ioc.liturgical.schemas.models;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;
import org.ocmc.ioc.liturgical.utils.ErrorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * The purpose of this class is to provide static methods to supplement those
 * found in the model classes.
 * 
 * The reason they are not methods in the model classes is that Jjschema throws
 * an error if there is a method that has a complex return value.
 * 
 * @author mac002
 *
 */
public class ModelHelpers {
	private static final Logger logger = LoggerFactory.getLogger(ModelHelpers.class);

	protected static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

	/**
	 * Converts the POJO to a Map using Gson
	 * 
	 * @param model the model to convert
	 * @return the model to a map of properties
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> toHashMap(AbstractModel model) {
		try {
			Type type = new TypeToken<Map<String, Object>>() {
			}.getType();
			Map<String, Object> map = new HashMap<String, Object>();
			map = (Map<String, Object>) gson.fromJson(model.toJsonString(), type);
			for (Entry<String, Object> entry : map.entrySet()) {
				if (entry.getValue() instanceof com.google.gson.internal.LinkedTreeMap) {
					String value = gson.toJson(entry.getValue());
					map.put(entry.getKey(), value);
				}
			}
			return map;
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> toHashMap(JsonObject o) {
		try {
			JsonObject newO = new JsonObject();
			for (Entry<String,JsonElement> e : o.entrySet()) {
				if (e.getValue().isJsonObject()) {
					JsonObject value = e.getValue().getAsJsonObject();
					if (value.has("val")) {
						newO.add(e.getKey(), value.get("val"));
					} else {
						newO.add(e.getKey(), value);
					}
				} else {
					newO.add(e.getKey(), e.getValue());
				}
			}
			Type type = new TypeToken<Map<String, Object>>() {
			}.getType();
			Map<String, Object> map = new HashMap<String, Object>();
			map = (Map<String, Object>) gson.fromJson(newO.toString(), type);
			for (Entry<String, Object> entry : map.entrySet()) {
				if (entry.getValue() instanceof com.google.gson.internal.LinkedTreeMap) {
					String value = gson.toJson(entry.getValue());
					map.put(entry.getKey(), value);
				}
			}
			return map;
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
			return null;
		}
	}
	/**
	 * Gets a properties map using 'props' as the key This is useful when
	 * passing a properties parameter, e.g. to Neo4j
	 * 
	 * @param model the model to convert
	 * @return a properties map created from the model
	 */
	public static Map<String, Object> getAsPropertiesMap(AbstractModel model) {
		return getAsPropertiesMap("props", model);
	}

	/**
	 * Gets a properties map with the parameter key as its key. This is useful
	 * when passing a properties parameter, e.g. to Neo4j
	 * 
	 * @param key the key to use
	 * @param model the model to convert
	 * @return a map of the properties for that model
	 */
	public static Map<String, Object> getAsPropertiesMap(String key, AbstractModel model) {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put(key, toHashMap(model));
		return props;
	}
	

	/**
	 * Get the properties of the model as a String list.
	 * They will not be sorted.
	 * @param model to be converted
	 * @return a list of the properties
	 */
	public static List<String> getPropertiesList(AbstractModel model) {
		List<String> result = new ArrayList<String>();
		List<String> props = new ArrayList<String>(toHashMap(model).keySet());
		for (String prop : props) {
			result.add(prop);
		}
		return result;
	}

	/**
	 * Get the properties as a list of Dropdown Items in a JsonArray.
	 * They will be sorted.
	 * @param model to be converted
	 * @return the properties as a JsonArrays
	 */
	public static JsonArray getPropertiesAsDropdownItems(AbstractModel model) {
		JsonArray result = new JsonArray();
		result.add(new DropdownItem("Any","*").toJsonObject());
		List<String> props = getPropertiesList(model);
		java.util.Collections.sort(props);
		for (String prop : props) {
			result.add(new DropdownItem(prop).toJsonObject());
		}
		return result;
	}
	public static JsonArray getPropertiesAsDropdownItems(AbstractModel model, List<String> exclusions) {
		JsonArray result = new JsonArray();
		result.add(new DropdownItem("Any","*").toJsonObject());
		List<String> props = getPropertiesList(model);
		java.util.Collections.sort(props);
		for (String prop : props) {
			if (! exclusions.contains(prop)) {
				result.add(new DropdownItem(prop).toJsonObject());
			}
		}
		return result;
	}
	public final static String QUOTE = "\"";


	/**
	 * Remove leading and trailing quote from a quoted string
	 * @param s the string
	 * @return the string
	 */
	public static String trimQuotes(String s) {
		String result = s;
		if (s.length() > 2) {
			if (s.startsWith(QUOTE) || s.startsWith("“")) {
				result = s.substring(1, s.length());
			}
			if (s.endsWith(QUOTE) || s.endsWith("”")) {
				result = result.substring(0, s.length()-2);
			}
		} else if (s.compareTo(QUOTE+QUOTE) == 0) {
			result = "";
		}
		return result;
	}
	
	/**
	 * Wrap the string in quotes
	 * @param s the string
	 * @return the string
	 */
	public static String wrapQuotes(String s) {
		String result = "";
		if (s.length() > 0) {
			result = QUOTE + escapeQuotes(s) + QUOTE;
		} else {
			result = QUOTE+QUOTE;
		}
		result = result.replaceAll("\\n", "");
		result = result.replaceAll("\\r", "");
		return result;
	}
	
	public static String escapeQuotes(String text) {
		return text.replaceAll(QUOTE, "\\\\"+QUOTE);
	}
	
	public static String unescapeQuotes(String text) {
			return text.replaceAll("\\\\"+QUOTE,QUOTE);
	}

}
