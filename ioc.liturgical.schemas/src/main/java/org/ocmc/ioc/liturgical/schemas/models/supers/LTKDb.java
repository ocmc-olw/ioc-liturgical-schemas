package org.ocmc.ioc.liturgical.schemas.models.supers;

import com.google.gson.annotations.Expose;

import java.util.Comparator;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.annotations.UiWidget;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.DATA_SOURCES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;

import com.github.reinert.jjschema.Attributes;

/**
 * Copy this code as the starting point for POJOs that have a Library, Topic, Key
 * as their ID and will be used to generate UI Schemas.  The issue is that JJSchema
 * does not support generation of attributes from supertypes.
 * @author mac002
 *
 */
@Attributes(title = "Class Name", description = "A {class name} {description}")
public class LTKDb extends LTK  implements Comparable<LTKDb> {
	
	@UiWidget(Constants.UI_WIDGET_RADIO)
	@Attributes(id="bottom", required = true, description = "Is this record active?")
	@Expose public boolean active = true;

	@Attributes(id="bottom",readonly=true, description="The user ID of the person who created it.")
	@Expose public String createdBy = "";

	@Attributes(id="bottom",readonly=true, description="The date/time when it was created.")
	@Expose public String createdWhen = "";
	
	@Attributes(id="bottom",readonly=true, description="The user ID of the person who last modified it.")
	@Expose public String modifiedBy = "";

	@Attributes(id="bottom",readonly=true, description="The date/time when it was last modified.")
	@Expose public String modifiedWhen = "";

	@Attributes(id="bottom",readonly=true, description="Where the data for this doc originated from.")
	@Expose public DATA_SOURCES dataSource = DATA_SOURCES.ONLINE;

	/**
	 * Values for this are not stored in the database.  They are just set at runtime 
	 * for adhoc sorting purposes.  
	 * Use Collections.sort on a list of Objects of this type.
	 */
	public String adhocSortKey = "";
	
	public LTKDb(
			String library
			, String topic
			, String key
			, String schema
			, double serialVersion
			, TOPICS ontologyTopic
			) {
		super(library, topic, key, schema, serialVersion, ontologyTopic);
		this.active = true; 
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedWhen() {
		return createdWhen;
	}

	public void setCreatedWhen(String createdWhen) {
		this.createdWhen = createdWhen;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedWhen() {
		return modifiedWhen;
	}

	public void setModifiedWhen(String modifiedWhen) {
		this.modifiedWhen = modifiedWhen;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> labels) {
		this.tags = labels;
	}

	public String get_valueSchemaId() {
		return _valueSchemaId;
	}

	public void set_valueSchemaId(String _valueSchemaId) {
		this._valueSchemaId = _valueSchemaId;
	}
	
	/**
	 * subclasses should override this
	 * @param json the json string
	 */
	public void setSubClassProperties(String json) {
		
	}

	public DATA_SOURCES getDataSource() {
		return dataSource;
	}

	public void setDataSource(DATA_SOURCES dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int compareTo(LTKDb o) {
		return this.id.compareTo(o.getId());
	}
	
	public static Comparator<LTKDb> adHocComparator = new Comparator<LTKDb>() {
		public int compare(LTKDb note1, LTKDb note2) {
			String topic1 = note1.adhocSortKey;
			String topic2 = note2.adhocSortKey;
		      //ascending order
		      return topic1.compareTo(topic2);
		}
	};

	public static Comparator<LTKDb> topicComparator = new Comparator<LTKDb>() {
		public int compare(LTKDb note1, LTKDb note2) {
			String topic1 = note1.getTopic();
			String topic2 = note2.getTopic();
		      //ascending order
		      return topic1.compareTo(topic2);
		}
	};

	public static Comparator<LTKDb> keyComparator = new Comparator<LTKDb>() {
		public int compare(LTKDb note1, LTKDb note2) {
			String topic1 = note1.getKey();
			String topic2 = note2.getKey();
		      //ascending order
		      return topic1.compareTo(topic2);
		}
	};

	public static Comparator<LTKDb> topicKeyComparator = new Comparator<LTKDb>() {
		public int compare(LTKDb note1, LTKDb note2) {
			String topic1 = note1.getTopic() + note1.getKey();
			String topic2 = note2.getTopic() + note2.getKey();
		      //ascending order
		      return topic1.compareTo(topic2);
		}
	};
	public static Comparator<LTKDb> modificationDateComparator = new Comparator<LTKDb>() {
		public int compare(LTKDb note1, LTKDb note2) {
			String topic1 = note1.getModifiedWhen();
			String topic2 = note2.getModifiedWhen();
		      //ascending order
		      return topic1.compareTo(topic2);
		}
	};

}
