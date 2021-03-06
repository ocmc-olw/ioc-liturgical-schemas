package org.ocmc.ioc.liturgical.schemas.models.supers;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.STATUS;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.constants.VISIBILITY;
import org.ocmc.ioc.liturgical.utils.ErrorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.reinert.jjschema.Attributes;

/**
 * Superclass for all docs in the external database.
 * Also used for the CreateForm subclasses.
 * 
 * The uiSchema order list will be generated from the get and set methods. 
 * So, if there are any methods that are not explicit property getters and setters
 * do not name them using get or set.  For example, getIdAsPath() had to be
 * renamed to toIdAsPath() so the uiSchema did not consider it to be a property.
 * 
 * How to control the order in which properties appear in the UI Schema:
 * 
 * 1. If id="top" is set in an attribute, it will 'float' to the top.
 * 2. If id='bottom' is set in an attribute, it will 'float' to the bottom.
 * 3. If id is not set, it will appear in the middle.
 * 4. The order in which they appear below is the order in which they will occur in the UI Schema in each section (top, middle, bottom).
 * 
 * Note the distinction between labels and tags.
 * Labels become actual Neo4j node labels, whereas
 * tags are stored as an array of strings.  Labels are
 * system created and confined to a limited, predefined set.  
 * Tags are user created and ad hoc.
 * 
 * Labels fall into one of the following categories:
 * 
 * Ontology labels: categorize the doc based on the ontological hierarch.
 * Library label: the library becomes a label.
 * Topic labels: in some cases the entire topic becomes a label, or each part of the topic becomes a separate label.
 * Key labels: in some cases (e.g. Biblical texts), the chapter part of the key becomes a label.
 * 
 * @author mac002
 *
 */
@Attributes(title = "Class Name", description = "A {class name} {description}")
public class LTK extends AbstractModel {
	
	private static final Logger logger = LoggerFactory.getLogger(LTK.class);
	
	@Attributes(id = "bottom", required = true, readonly = true, minLength = 1, description = "The unique identifier, that is, the ID.")
	@Expose public String id = "";

	@Attributes(id = "bottom", required = true, readonly = true, minLength = 1,  description = "The library part of the ID, that is, typically the domain.")
	@Expose public String library = "";

	@Attributes(id = "bottom", required = true, readonly = true, minLength = 1, description = "The topic part of the ID.")
	@Expose public String topic = "";

	@Attributes(id = "bottom", required = true, readonly = true, minLength = 1, description = "The key part of the ID")
	@Expose public String key = "";

	@Attributes(id="top", description="Tags to use when searching for this Doc.")
	@Expose public List<String> tags = new ArrayList<String>();
	
	@Attributes(id = "bottom", required = true, readonly = true, minLength = 1, description = "The ontology topic for the schema.")
	@Expose public TOPICS ontologyTopic = TOPICS.ROOT;
	
	@Attributes(id = "bottom", required = true, readonly = true, minLength = 1, description = "The Part Type of the Topic part of the ID.")
	@Expose public ID_PART_TYPES partTypeOfTopic = ID_PART_TYPES.USER_TEXT;
	
	@Attributes(id = "bottom", required = true, readonly = true, minLength = 1, description = "The Part Type of the Key part of the ID.")
	@Expose public ID_PART_TYPES partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	
	@Attributes(id = "bottom", required = true, readonly = true, minLength = 1, description = "The unique identifier for the schema.")
	@Expose public String _valueSchemaId = "";
	
	@Attributes(id = "bottom", required = false, description = "An additional Neo4j node label")
	@Expose public String adHocLabel = "";

	/**
	 * Visibility is at the record level.  It works in conjunction with the domain of the record ID.
	 * 
	 */
	@Attributes(id="bottom", readonly=false, required=true, description="If the library is your user library, you can set the visibility to personal.  The record will then only be visible to you personally.  If you set it to private, anyone to whom you have granted read or write access to your user library will be able to see it.  If you set visibility to public, it means it is eligible to be moved to the public, read-only database.")
	@Expose public VISIBILITY visibility = VISIBILITY.PERSONAL;

	@Attributes(id="bottom", readonly=false, required=true, description="Status of this record.  'Editing' means it is either a draft or undergoing revision.  'Reviewing' means it is being reviewed for someone's approval.  'Finalized' means work has finished on this record.  It is not being edited or reviewed at this time. 'Ready for...' means it is ready for someone to be assigned to the next step.")
	@Expose public STATUS status = STATUS.EDITING;

	@Attributes(id="bottom", readonly=false, required=false, description="The ID of the user to whom work has been assigned for this record.")
	@Expose public String assignedToUser = "";

	public LTK(
			String library
			, String topic
			, String key
			, String schema
			, double serialVersion
			, TOPICS ontologyTopic
			) {
		super();
		this.library = library;
		this.topic = topic;
		this.key = key;
		this.joinIdParts();
		this._valueSchemaId = schema + ":" + this.serialVersionUID;
		if (ontologyTopic == null) {
			logger.error("Ontology Topic is null for " + this.id);
		} else {
			this.ontologyTopic = ontologyTopic;
		}
	}

	public String getLibrary() {
		return library;
	}

	public void setLibrary(String library) {
		this.library = library;
		joinIdParts();
	}

	public String getTopic() {
		return topic;
	}
	
	/**
	 * 
	 * @return concatenation of the topic and key separated by the ID Delimiter
	 */
	public String toTopicKey() {
		return this.topic + Constants.ID_DELIMITER + this.key;
	}

	public void setTopic(String topic) {
		this.topic = topic;
		joinIdParts();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
		joinIdParts();
	}

	
	private void joinIdParts() {
		this.id = this.library + Constants.ID_DELIMITER + this.topic + Constants.ID_DELIMITER + this.key;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String get_valueSchemaId() {
		return _valueSchemaId;
	}

	public void set_valueSchemaId(String _valueSchemaId) {
		this._valueSchemaId = _valueSchemaId;
	}
	
	public void addTag(String tag) {
		this.tags.add(tag);
	}
	
	public boolean hasTag(String tag) {
		return this.tags.contains(tag);
	}
	
	public void removeTag(String tag) {
		try {
			this.tags.remove(tag);
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}
	}
	
	public String toIdAsPath() {
		return this.library + "/" + this.topic + "/" + this.key;
	}

	public String toSchemaAsLabel() {
		StringBuffer result = new StringBuffer();
		try {
			String [] parts = this._valueSchemaId.split(":");
			if (parts.length > 1) {
				result.append(parts[0]);
			}
		} catch (Exception e) {
			result.append(this._valueSchemaId);
		}
		return result.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TOPICS getOntologyTopic() {
		return ontologyTopic;
	}

	public void setOntologyTopic(TOPICS ontologyTopic) {
		this.ontologyTopic = ontologyTopic;
	}

	/**
	 * Get the ontology labels.  They will be in the proper order.
	 * However, note that Neo4j does not use this order.
	 * It creates an internal ID for each label and uses the ID order.
	 * It is out of our control how they are stored.
	 * 
	 * Also, if the ontology type is Biblical or Liturgical text, additional labels
	 * will be created.  For Biblical, it will add the book abbreviation and chapter number.
	 * 2017-12-20 Removed: For Liturgical, it will create a label for each  part of the topic.
	 * @return the ontology labels
	 */
	public List<String> fetchOntologyLabelsList() {
		List<String> labels = ontologyTopic.toLabelsList();
		labels.add(library);
		if (ontologyTopic.equals(TOPICS.TEXT_BIBLICAL)) { // add label for book and chapter
			labels.add(this.topic); // this is the book abbreviation
			String [] parts = this.key.split(":");
			if (parts.length == 2) {
				labels.add(parts[0]); // this is the chapter number
			}
		} else if (ontologyTopic.equals(TOPICS.TEXT_LITURGICAL)) { // add labels from topic
			String[] parts = this.topic.split("\\.");
			if (parts.length > 1) {
				if (parts[0].equals("le")) { // only use the first two parts as labels for lectionary
					labels.add(parts[0]);
					labels.add(parts[1]);
				} else {
					for (String s : parts) {
						labels.add(s);
					}
				}
			} else {
				labels.add(this.topic);
			}
		}
		labels.add(this.toSchemaAsLabel());
		if (this.adHocLabel == null) {
			this.adHocLabel = "";
		} else {
			if (this.adHocLabel.length() > 0) {
				labels.add(this.adHocLabel);
			}
		}
		return labels;
	}
	
	/**
	 * Get the ontology labels.  They will be in the proper order.
	 * However, note that Neo4j does not use this order.
	 * It creates an internal ID for each label and uses the ID order.
	 * It is out of our control how they are stored.
	 * 
	 * Also, if the ontology type is Biblical or Liturgical text, additional labels
	 * will be created.  For Biblical, it will add the book abbreviation and chapter number.
	 * For Liturgical, it will create a label for each  part of the topic.
	 * @return the ontology labels
	 */
	public String fetchOntologyLabels() {
		return StringUtils.join(this.fetchOntologyLabelsList(),":");
	}
	
	public ID_PART_TYPES getPartTypeOfTopic() {
		return partTypeOfTopic;
	}

	public void setPartTypeOfTopic(ID_PART_TYPES partTypeOfTopic) {
		this.partTypeOfTopic = partTypeOfTopic;
	}

	public ID_PART_TYPES getPartTypeOfKey() {
		return partTypeOfKey;
	}

	public void setPartTypeOfKey(ID_PART_TYPES partTypeOfKey) {
		this.partTypeOfKey = partTypeOfKey;
	}
	
	public VISIBILITY getVisibility() {
		return visibility;
	}

	public void setVisibility(VISIBILITY visibility) {
		this.visibility = visibility;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public String getAssignedToUser() {
		return assignedToUser;
	}

	public void setAssignedToUser(String assignedToUser) {
		this.assignedToUser = assignedToUser;
	}

	public String getAdHocLabel() {
		return adHocLabel;
	}

	public void setAdHocLabel(String adHocLabel) {
		this.adHocLabel = adHocLabel;
	}
}
