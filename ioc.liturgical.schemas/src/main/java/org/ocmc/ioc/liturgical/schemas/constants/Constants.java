package org.ocmc.ioc.liturgical.schemas.constants;

/**
 * Provides static constants used in the project.
 * @author mac002
 *
 */
public class Constants {
	public static final String VERSION = "1.0.0"; // should match most recent jar

	public static final String ID_DELIMITER = "~";
	public static final String ID_SPLITTER = "~";
	public static final String PIPE_SPLITTER = "\\|";
	public static final String ALT_ID_DELIMITER = "~"; // TODO reconcile pipe vs tilde
	public static final String DOMAIN_DELIMITER = "_";
	public static final String DOMAIN_SPLITTER = "_";
	
	public static final String LIBRARY_SYNCH = "en_sys_synch";
	public static final String TOPIC_SYNCH = "cypher";
	public static final String TOPIC_SYNCH_LOG = "synch";
	public static final String KEY_SYNCH_LOG = "log";

	public static final String INTERNAL_DATASTORE_API_PATH = "/admin/api/v1";

	public static final String EXTERNAL_LITURGICAL_DAY_PROPERTIES_API_PATH = "/ldp/api/v1";
	public static final String EXTERNAL_DATASTORE_SYNCH_API_PATH = "/synch/api/v1";
	public static final String EXTERNAL_DATASTORE_API_PATH = "/db/api/v1";
	public static final String EXTERNAL_DATASTORE_DROPDOWNS_PATH = "/dropdowns";
	public static final String EXTERNAL_DATASTORE_FORMS_PATH = "/forms";
	public static final String EXTERNAL_DATASTORE_NODE_PATH = "/docs";
	public static final String EXTERNAL_DATASTORE_RELATIONSHIP_PATH = "/links";
	public static final String EXTERNAL_DATASTORE_NATURAL_LANGUAGE_PROCESSING_PATH = "/nlp";
	public static final String EXTERNAL_DATASTORE_ONTOLOGY_PATH = "/ontology";
	
	public static final String PATH_LIBRARY_WILDCARD = "/*";
	public static final String PATH_LIBRARY_TOPIC_WILDCARD = "/*/*";
	public static final String PATH_LIBRARY_TOPIC_KEY_WILDCARD = "/*/*/*";

	public static final String TEMPLATE_KEY = "head";
	
	public static final String UI_WIDGET_TEXTAREA = "textarea";
	public static final String UI_WIDGET_PASSWORD = "password";
	public static final String UI_WIDGET_USERS = "users";
	public static final String UI_WIDGET_DOMAINS = "domains";
	public static final String UI_WIDGET_CHECKBOXES = "checkboxes";
	public static final String UI_WIDGET_RADIO = "radio";
	public static final String UI_WIDGET_SELECT = "select";	

	public static final String VALUE_SCHEMA_ID = "_valueSchemaId";

}
