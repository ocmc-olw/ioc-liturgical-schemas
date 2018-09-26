package org.ocmc.ioc.liturgical.schemas.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.ocmc.ioc.liturgical.schemas.models.db.docs.notes.UserNote;
import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

/**
 * Holds a copy of 
 * @author mac002
 *
 */
public class MetaCsv   {
	AbstractModel model = null;
	String schema = null;
	String labels = null;
	String delimiter = ",";
	String header = "";
	String content = "";
	String cypher = "";
	int headerPropCount = 0;
	int contentPropCount = 0;
	List<String> headerErrors = new ArrayList<String>();
	List<String> contentErrors = new ArrayList<String>();
	
	public MetaCsv(
			AbstractModel model
			, String schema
			, String labels
			, String delimiter
			) {
		this.model = model;
		this.schema = schema;
		this.labels = labels;
		this.delimiter = delimiter;
		this.setCypher();
		this.setHeader();
		this.setContent();
	}
		
	private void setHeader() {
		/**
		 * From Neo4j manual:
		 * Use one of int, long, float, double, boolean, byte, short, char, string, point, date, localtime, 
		 * time, localdatetime, datetime, and duration to designate the data type for properties. 
		 * If no data type is given, this defaults to string. 
		 * To define an array type, append [] to the type. By default, array values are separated by ;. 
		 * A different delimiter can be specified with --array-delimiter.
		 */
		Map<String,Object> map = new TreeMap<String,Object>();
		map.putAll(ModelHelpers.toHashMap(this.model)); // we want the keys sorted
		this.headerPropCount = map.size();
		String id = (String) map.get("id");
		if (schema.startsWith("UserNote")) {
			System.out.println(schema + ": " + id);
			for (String key : map.keySet()) {
				System.out.println(key);
			}
		}
		if (id.equals("en_us_mcolburn~gr_gr_cog~he.h.m2~VythouAnekalypse.text~2018.05.17.T11.47.22")) {
			UserNote note = (UserNote) model;
			System.out.print("");
		}
		map.remove("id");
		String library = (String) map.get("library");
		map.remove("library");
		String topic = (String) map.get("topic");
		map.remove("topic");
		String key = (String) map.get("key");
		map.remove("key");
		String value = null;
		if (map.containsKey("value")) {
			value = (String) map.get("value");
			map.remove("value");
		}
		StringBuffer header = new StringBuffer();
		header.append("id:ID");
		header.append(delimiter);
		header.append("library:string");
		header.append(delimiter);
		header.append("topic:string");
		header.append(delimiter);
		header.append("key:string");
		if (value != null) {
			header.append(delimiter);
			header.append("value:string");
		}
		for (Entry<String,Object> entry : map.entrySet()) {
			if (header.length() > 0) {
				header.append(delimiter);
			}
			header.append(entry.getKey());
			String name = entry.getValue().getClass().getSimpleName();
			switch (name) {
			case ("ArrayList"): {
				header.append(":string[]");
				break;
			}
			case ("Boolean"): {
				header.append("boolean");
				break;
			}
			case ("Double"): {
				header.append("double");
				break;
			}
			case ("String"): {
				header.append("string");
				break;
			}
			default: {
				this.headerErrors.add(name);
			}
			}
		}
		header.append(delimiter);
		header.append(":LABEL");
		header.append("\n");
		this.header = header.toString();
	}
	
	private void setCypher() {
		// USING PERIODIC COMMIT
		// LOAD CSV WITH HEADERS FROM "file:customers.csv" AS row
		// CREATE (:Customer {companyName: row.CompanyName, customerID: row.CustomerID, fax: row.Fax, phone: row.Phone});

		Map<String,Object> map = new TreeMap<String,Object>();
		map.putAll(ModelHelpers.toHashMap(this.model)); // we want the keys sorted
		String id = (String) map.get("id");
		map.remove("id");
		String library = (String) map.get("library");
		map.remove("library");
		String topic = (String) map.get("topic");
		map.remove("topic");
		String key = (String) map.get("key");
		map.remove("key");
		String value = null;
		if (map.containsKey("value")) {
			value = (String) map.get("value");
			map.remove("value");
		}
		StringBuffer cypher = new StringBuffer();
		cypher.append("USING PERIODIC COMMIT  LOAD CSV WITH HEADERS FROM \"file:///");
		cypher.append(this.schema);
		cypher.append(".csv\"  AS row CREATE (:");
		cypher.append(this.labels);
		cypher.append(" {id: row.id");
		cypher.append(", library: row.library");
		cypher.append(", topic: row.topic");
		cypher.append(", key: row.key");
		if (value != null) {
			cypher.append(", value: row.value");
		}
		for (Entry<String,Object> entry : map.entrySet()) {
			cypher.append(", ");
			cypher.append(entry.getKey());
			cypher.append(": row.");
			cypher.append(entry.getKey());
		}
		cypher.append("});\n");
		this.cypher = cypher.toString();
	}
	
	private void setContent() {
		Map<String,Object> map = new TreeMap<String,Object>();
		map.putAll(ModelHelpers.toHashMap(this.model));
		this.contentPropCount = map.size();
		String id = (String) map.get("id");
		if (id.equals("en_us_mcolburn~gr_gr_cog~me.m01.d06~meMA.Ode9C11.text~2018.09.03.T08.35.25")) {
			UserNote note = (UserNote) model;
			System.out.print("");
		}
		map.remove("id");
		String library = (String) map.get("library");
		map.remove("library");
		String topic = (String) map.get("topic");
		map.remove("topic");
		String key = (String) map.get("key");
		map.remove("key");
		String value = null;
		if (map.containsKey("value")) {
			value = (String) map.get("value");
			map.remove("value");
		}
		StringBuffer sb = new StringBuffer();
		sb.append(ModelHelpers.wrapQuotes((id)));
		sb.append(delimiter);
		sb.append(ModelHelpers.wrapQuotes((library)));
		sb.append(delimiter);
		sb.append(ModelHelpers.wrapQuotes((topic)));
		sb.append(delimiter);
		sb.append(ModelHelpers.wrapQuotes((key)));
		sb.append(delimiter);
		if (value != null) {
//			if (id.equals("en_us_mcolburn~gr_gr_cog~me.m01.d06~meMA.Ode9C11.text~2018.09.03.T08.35.25")) {
//				sb.append(ModelHelpers.wrapQuotes(("DUDE"));
//			} else {
				sb.append(ModelHelpers.wrapQuotes((value)));
//			}
		}
		for (Entry<String,Object> entry : map.entrySet()) {
			sb.append(delimiter);
			String name = entry.getValue().getClass().getSimpleName();
			Object entryValue = entry.getValue();
			switch (name) {
			case ("ArrayList"): {
				@SuppressWarnings("unchecked")
				ArrayList<String> list = (ArrayList<String>) entry.getValue();
				StringBuffer array = new StringBuffer();
				for (String s : list) {
					if (array.length() > 0) {
						array.append(";");
					}
					array.append(ModelHelpers.wrapQuotes((s)));
				}
				sb.append(array.toString());
				break;
			}
			case ("Boolean"): {
				if (entryValue == null) {
					entryValue = false;
				}
				sb.append(entryValue);
				break;
			}
			case ("Double"): {
				if (entryValue == null) {
					entryValue = Double.parseDouble("0");
				}
				sb.append(entryValue);
				break;
			}
			case ("String"): {
				if (entryValue == null) {
					entryValue = "";
				}
				sb.append(ModelHelpers.wrapQuotes((entryValue.toString())));
				break;
			}
			default: {
				this.contentErrors.add(name);
				sb.append(entryValue);
			}
			}
		}
		sb.append(delimiter);
		sb.append(this.labels.replaceAll(":", ";"));
		sb.append("\n");
		this.content  = sb.toString();
		if (id.equals("en_us_mcolburn~gr_gr_cog~me.m01.d06~meMA.Ode9C11.text~2018.09.03.T08.35.25")) {
			String temp = sb.toString().replaceAll("\t", "\n");
			System.out.println(temp);
			System.out.println("");
		}

	}
// TODO: use this method to quote all string values	
	private String qwrap(String s) {
		StringBuffer sb = new StringBuffer();
		sb.append("\"");
		sb.append(s);
		sb.append("\"");
		return sb.toString();
	}

	public AbstractModel getModel() {
		return model;
	}

	public void setModel(AbstractModel model) {
		this.model = model;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCypher() {
		return cypher;
	}

	public void setCypher(String cypher) {
		this.cypher = cypher;
	}

	public int getHeaderPropCount() {
		return headerPropCount;
	}

	public void setHeaderPropCount(int headerPropCount) {
		this.headerPropCount = headerPropCount;
	}

	public int getContentPropCount() {
		return contentPropCount;
	}

	public void setContentPropCount(int contentPropCount) {
		this.contentPropCount = contentPropCount;
	}

	public List<String> getHeaderErrors() {
		return headerErrors;
	}

	public void setHeaderErrors(List<String> headerErrors) {
		this.headerErrors = headerErrors;
	}

	public List<String> getContentErrors() {
		return contentErrors;
	}

	public void setContentErrors(List<String> contentErrors) {
		this.contentErrors = contentErrors;
	}

}
