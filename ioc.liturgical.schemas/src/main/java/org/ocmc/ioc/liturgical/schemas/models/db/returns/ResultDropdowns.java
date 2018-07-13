package org.ocmc.ioc.liturgical.schemas.models.db.returns;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;
import org.ocmc.ioc.liturgical.schemas.models.ws.response.RequestStatus;
import org.ocmc.ioc.liturgical.schemas.constants.BIBTEX_STYLES;
import org.ocmc.ioc.liturgical.schemas.constants.USER_INTERFACE_DOMAINS;
import org.ocmc.ioc.liturgical.schemas.constants.USER_INTERFACE_LANGUAGES;
import org.ocmc.ioc.liturgical.schemas.constants.USER_INTERFACE_SYSTEMS;
import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;
import org.ocmc.ioc.liturgical.utils.ErrorUtils;

/**
 * Holds various dropdowns, the forms to create new instances, and UI labels
 * @author mac002
 *
 */
public class ResultDropdowns extends AbstractModel {
	private static final Logger logger = LoggerFactory.getLogger(ResultDropdowns.class);
	@Expose public String query;
	@Expose public RequestStatus status;
	@Expose public Long valueCount = Long.parseLong("0");
	@Expose public Map<String,JsonObject> valueSchemas = new TreeMap<String,JsonObject>();
	@Expose public Map<String,JsonObject> values = new TreeMap<String,JsonObject>();
	@Expose public JsonObject domains;
	@Expose public List<DropdownItem> ontologyTypesDropdown = new ArrayList<DropdownItem>();
	@Expose public Map<String,JsonArray> ontologyDropdowns = new TreeMap<String,JsonArray>();
	@Expose public List<JsonObject> formsDropdown = new ArrayList<JsonObject>();
	@Expose public List<JsonObject> schemaEditorFormsDropdown = new ArrayList<JsonObject>();
	@Expose public List<DropdownItem> noteTypesDropdown = new ArrayList<DropdownItem>();
	@Expose public List<DropdownItem> noteTypesBilDropdown = new ArrayList<DropdownItem>();
	@Expose public List<DropdownItem> liturgicalBooksDropdown = new ArrayList<DropdownItem>();
	@Expose public List<DropdownItem> biblicalBooksDropdown = new ArrayList<DropdownItem>();
	@Expose public List<DropdownItem> biblicalChaptersDropdown = new ArrayList<DropdownItem>();
	@Expose public List<DropdownItem> biblicalVersesDropdown = new ArrayList<DropdownItem>();
	@Expose public List<DropdownItem> biblicalSubversesDropdown = new ArrayList<DropdownItem>();
	@Expose public JsonArray templateNewTemplateDropdown;
	@Expose public JsonArray templatePartsDropdown;
	@Expose public JsonArray templateWhenDayNameCasesDropdown;
	@Expose public JsonArray templateWhenDayOfMonthCasesDropdown;
	@Expose public JsonArray templateWhenDayOfSeasonCasesDropdown;
	@Expose public JsonArray templateWhenCasesDropdown;
	@Expose public JsonArray templateWhenModeOfWeekCasesDropdown;
	@Expose public JsonArray templateWhenMonthNameCasesDropdown;
	@Expose public JsonArray bibTexStyles = BIBTEX_STYLES.toDropdownJsonArray();
	@Expose public JsonArray uiDomains = USER_INTERFACE_DOMAINS.toDropdownJsonArray();
	@Expose public JsonArray uiLanguages = USER_INTERFACE_LANGUAGES.toDropdownJsonArray();
	@Expose public JsonObject uiLabels = new JsonObject();
	@Expose public JsonArray uiSystems = USER_INTERFACE_SYSTEMS.toDropdownJsonArray();
	@Expose public JsonObject uiLabelTopics = new JsonObject();
	@Expose public JsonArray isoCountries = new JsonArray();
	@Expose public JsonArray isoLanguages = new JsonArray();
	@Expose public JsonObject adminForms = new JsonObject();
	
	public ResultDropdowns(boolean prettyPrint) {
		super();
		super.setPrettyPrint(prettyPrint);
		status = new RequestStatus();
	}
	
	public void addSchemaEditorForm(DropdownItem item) {
		this.schemaEditorFormsDropdown.add(item.toJsonObject());
	}
	public void addSchema(String id, JsonObject schema) {
		if (! valueSchemas.containsKey(id)) {
			valueSchemas.put(id, schema);
		}
	}
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}

	public void setResult(Map<String,JsonObject> result) {
		this.values = result;
		if (result != null) {
			this.valueCount = (long) result.size();
		}
	}

	public Long getCount() {
		return valueCount;
	}

	public void setCount(Long count) {
		this.valueCount = count;
	}

	public Long getResultCount() {
		return valueCount;
	}

	public void setResultCount(Long resultCount) {
		this.valueCount = resultCount;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public Long getValueCount() {
		return valueCount;
	}

	public void setValueCount(Long valueCount) {
		this.valueCount = valueCount;
	}

	public void setStatusCode(int code) {
		this.status.setCode(code);
	}

	/**
	 * Sets status developer message and user message to the same message
	 * @param message the message
	 */
	public void setStatusMessage(String message) {
		this.status.developerMessage = message;
		this.status.userMessage = message;
	}

	public void setStatusDeveloperMessage(String message) {
		this.status.developerMessage = message;
	}

	public void setStatusUserMessage(String message) {
		this.status.userMessage = message;
	}

	public Map<String, JsonObject> getValueSchemas() {
		return valueSchemas;
	}

	public void setValueSchemas(Map<String, JsonObject> valueSchemas) {
		this.valueSchemas = valueSchemas;
		Map<String,DropdownItem> dropdownMap = new TreeMap<String,DropdownItem>();
		try {
			for (Entry<String, JsonObject> entry  : valueSchemas.entrySet()) {
				try {
					String value = entry.getKey();
					String label = entry.getValue().get("schema").getAsJsonObject().get("title").getAsString();
					if (! entry.getValue()
							.get("schema")
							.getAsJsonObject()
							.get("properties")
							.getAsJsonObject()
							.has("excludeFromNewFormDropdown")
							) {
						DropdownItem d = new DropdownItem(label,value);
						dropdownMap.put(label, d);
					}
				} catch (Exception entryException) {
					ErrorUtils.report(logger, entryException, entry.getKey() + " bad schema");
				}
			}
			for (DropdownItem d : dropdownMap.values()) {
				formsDropdown.add(d.toJsonObject());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JsonObject getDomains() {
		return domains;
	}

	public void setDomains(JsonObject domains) {
		this.domains = domains;
	}

	public Map<String, JsonObject> getValues() {
		return values;
	}

	public void setValues(Map<String, JsonObject> values) {
		this.values = values;
	}

	public List<JsonObject> getFormsDropdown() {
		return formsDropdown;
	}

	public void setFormsDropdown(List<JsonObject> formsDropdown) {
		this.formsDropdown = formsDropdown;
	}

	public Map<String, JsonArray> getOntologyDropdowns() {
		return ontologyDropdowns;
	}

	public void setOntologyDropdowns(Map<String, JsonArray> ontologyDropdowns) {
		this.ontologyDropdowns = ontologyDropdowns;
	}

	public List<DropdownItem> getOntologyTypesDropdown() {
		return ontologyTypesDropdown;
	}

	public void setOntologyTypesDropdown(List<DropdownItem> ontologyTypesDropdown) {
		this.ontologyTypesDropdown = ontologyTypesDropdown;
	}

	public List<DropdownItem> getBiblicalBooksDropdown() {
		return biblicalBooksDropdown;
	}

	public void setBiblicalBooksDropdown(List<DropdownItem> biblicalBooksDropdown) {
		this.biblicalBooksDropdown = biblicalBooksDropdown;
	}

	public List<DropdownItem> getBiblicalChaptersDropdown() {
		return biblicalChaptersDropdown;
	}

	public void setBiblicalChaptersDropdown(List<DropdownItem> biblicalChaptersDropdown) {
		this.biblicalChaptersDropdown = biblicalChaptersDropdown;
	}

	public List<DropdownItem> getBiblicalVersesDropdown() {
		return biblicalVersesDropdown;
	}

	public void setBiblicalVersesDropdown(List<DropdownItem> biblicalVersesDropdown) {
		this.biblicalVersesDropdown = biblicalVersesDropdown;
	}

	public List<DropdownItem> getBiblicalSubversesDropdown() {
		return biblicalSubversesDropdown;
	}

	public void setBiblicalSubversesDropdown(List<DropdownItem> biblicalSubversesDropdown) {
		this.biblicalSubversesDropdown = biblicalSubversesDropdown;
	}

	public JsonArray getTemplatePartsDropdown() {
		return templatePartsDropdown;
	}

	public void setTemplatePartsDropdown(JsonArray templatePartsDropdown) {
		this.templatePartsDropdown = templatePartsDropdown;
	}

	public JsonArray getTemplateWhenDayNameCasesDropdown() {
		return templateWhenDayNameCasesDropdown;
	}

	public void setTemplateWhenDayNameCasesDropdown(JsonArray templateWhenDayNameCasesDropdown) {
		this.templateWhenDayNameCasesDropdown = templateWhenDayNameCasesDropdown;
	}

	public JsonArray getTemplateWhenDayOfMonthCasesDropdown() {
		return templateWhenDayOfMonthCasesDropdown;
	}

	public void setTemplateWhenDayOfMonthCasesDropdown(JsonArray templateWhenDayOfMonthCasesDropdown) {
		this.templateWhenDayOfMonthCasesDropdown = templateWhenDayOfMonthCasesDropdown;
	}

	public JsonArray getTemplateWhenDayOfSeasonCasesDropdown() {
		return templateWhenDayOfSeasonCasesDropdown;
	}

	public void setTemplateWhenDayOfSeasonCasesDropdown(JsonArray templateWhenDayOfSeasonCasesDropdown) {
		this.templateWhenDayOfSeasonCasesDropdown = templateWhenDayOfSeasonCasesDropdown;
	}

	public JsonArray getTemplateWhenCasesDropdown() {
		return templateWhenCasesDropdown;
	}

	public void setTemplateWhenCasesDropdown(JsonArray templateWhenCasesDropdown) {
		this.templateWhenCasesDropdown = templateWhenCasesDropdown;
	}

	public JsonArray getTemplateWhenModeOfWeekCasesDropdown() {
		return templateWhenModeOfWeekCasesDropdown;
	}

	public void setTemplateWhenModeOfWeekCasesDropdown(JsonArray templateWhenModeOfWeekCasesDropdown) {
		this.templateWhenModeOfWeekCasesDropdown = templateWhenModeOfWeekCasesDropdown;
	}

	public JsonArray getTemplateWhenMonthNameCasesDropdown() {
		return templateWhenMonthNameCasesDropdown;
	}

	public void setTemplateWhenMonthNameCasesDropdown(JsonArray templateWhenMonthNameCasesDropdown) {
		this.templateWhenMonthNameCasesDropdown = templateWhenMonthNameCasesDropdown;
	}

	public JsonArray getTemplateNewTemplateDropdown() {
		return templateNewTemplateDropdown;
	}

	public void setTemplateNewTemplateDropdown(JsonArray templateNewTemplateDropdown) {
		this.templateNewTemplateDropdown = templateNewTemplateDropdown;
	}

	public List<DropdownItem> getLiturgicalBooksDropdown() {
		return liturgicalBooksDropdown;
	}

	public void setLiturgicalBooksDropdown(List<DropdownItem> liturgicalBooksDropdown) {
		this.liturgicalBooksDropdown = liturgicalBooksDropdown;
	}
	public List<DropdownItem> getNoteTypesDropdown() {
		return noteTypesDropdown;
	}

	public void setNoteTypesDropdown(List<DropdownItem> noteTypesDropdown) {
		this.noteTypesDropdown = noteTypesDropdown;
	}

	public List<DropdownItem> getNoteTypesBilDropdown() {
		return noteTypesBilDropdown;
	}

	public void setNoteTypesBilDropdown(List<DropdownItem> noteTypesBilDropdown) {
		this.noteTypesBilDropdown = noteTypesBilDropdown;
	}

	public List<JsonObject> getSchemaEditorFormsDropdown() {
		return schemaEditorFormsDropdown;
	}

	public void setSchemaEditorFormsDropdown(List<JsonObject> schemaEditorFormsDropdown) {
		this.schemaEditorFormsDropdown = schemaEditorFormsDropdown;
	}

	public JsonArray getBibTexStyles() {
		return bibTexStyles;
	}

	public void setBibTexStyles(JsonArray bibTexStyles) {
		this.bibTexStyles = bibTexStyles;
	}

	public JsonObject getUiLabels() {
		return uiLabels;
	}

	public void setUiLabels(JsonObject uiLabels) {
		this.uiLabels = uiLabels;
	}

	public JsonArray getUiSystems() {
		return uiSystems;
	}

	public void setUiSystems(JsonArray uiSystems) {
		this.uiSystems = uiSystems;
	}

	public JsonArray getUiDomains() {
		return uiDomains;
	}

	public void setUiDomains(JsonArray uiDomains) {
		this.uiDomains = uiDomains;
	}

	public JsonArray getUiLanguages() {
		return uiLanguages;
	}

	public void setUiLanguages(JsonArray uiLanguages) {
		this.uiLanguages = uiLanguages;
	}

	public JsonObject getUiLabelTopics() {
		return uiLabelTopics;
	}

	public void setUiLabelTopics(JsonObject uiLabelTopics) {
		this.uiLabelTopics = uiLabelTopics;
	}

	public JsonArray getIsoCountries() {
		return isoCountries;
	}

	public void setIsoCountries(JsonArray isoCountries) {
		this.isoCountries = isoCountries;
	}

	public JsonArray getIsoLanguages() {
		return isoLanguages;
	}

	public void setIsoLanguages(JsonArray isoLanguages) {
		this.isoLanguages = isoLanguages;
	}

	public JsonObject getAdminForms() {
		return adminForms;
	}

	public void setAdminForms(JsonObject adminForms) {
		this.adminForms = adminForms;
	}


}
