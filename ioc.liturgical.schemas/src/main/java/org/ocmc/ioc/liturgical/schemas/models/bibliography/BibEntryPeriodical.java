package org.ocmc.ioc.liturgical.schemas.models.bibliography;

import org.ocmc.ioc.liturgical.schemas.constants.BIBTEX_ENTRY_TYPES;

import org.ocmc.ioc.liturgical.schemas.models.supers.BibliographyEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

@Attributes(title = "Periodical", description = "An complete issue of a periodical, such as a special issue of a journal. The title of the periodical is given in the title field. If the issue has its own title in addition to the main title of the periodical, it goes in the issuetitle field")
public class BibEntryPeriodical extends BibliographyEntry {

	private static final Logger logger = LoggerFactory.getLogger(BibEntryPeriodical.class);
	private static String schema = BibEntryPeriodical.class.getSimpleName();
	private static double schemaVersion = 1.1;

	public BibEntryPeriodical(
			String library
			, String key
) {
		super(library, key, schema, schemaVersion, BIBTEX_ENTRY_TYPES.PERIODICAL);
		this.library = library;
		this.key = key;
	}
	@Attributes(required = true, description = "editor")
	@Expose public String editor = "";

	@Attributes(required = true, description = "title")
	@Expose public String title = "";

	@Attributes(required = false, description = "editora")
	@Expose public String editora = "";

	@Attributes(required = false, description = "editorb")
	@Expose public String editorb = "";

	@Attributes(required = false, description = "editorc")
	@Expose public String editorc = "";

	@Attributes(required = false, description = "subtitle")
	@Expose public String subtitle = "";

	@Attributes(required = false, description = "issuetitle")
	@Expose public String issuetitle = "";

	@Attributes(required = false, description = "issuesubtitle")
	@Expose public String issuesubtitle = "";

	@Attributes(required = false, description = "language")
	@Expose public String language = "";

	@Attributes(required = false, description = "series")
	@Expose public String series = "";

	@Attributes(required = false, description = "volume")
	@Expose public String volume = "";

	@Attributes(required = false, description = "number")
	@Expose public String number = "";

	@Attributes(required = false, description = "issue")
	@Expose public String issue = "";

	@Attributes(required = false, description = "date")
	@Expose public String date = "";

	@Attributes(required = false, description = "month")
	@Expose public String month = "";

	@Attributes(required = false, description = "year")
	@Expose public String year = "";

	@Attributes(required = false, description = "note")
	@Expose public String note = "";

	@Attributes(required = false, description = "issn")
	@Expose public String issn = "";

	@Attributes(required = false, description = "addendum")
	@Expose public String addendum = "";

	@Attributes(required = false, description = "pubstate")
	@Expose public String pubstate = "";

	@Attributes(required = false, description = "doi")
	@Expose public String doi = "";

	@Attributes(required = false, description = "eprint")
	@Expose public String eprint = "";

	@Attributes(required = false, description = "eprintclass")
	@Expose public String eprintclass = "";

	@Attributes(required = false, description = "eprinttype")
	@Expose public String eprinttype = "";

	@Attributes(required = false, description = "url")
	@Expose public String url = "";

	@Attributes(required = false, description = "urldate")
	@Expose public String urldate = "";

public String toBibtex() {
		StringBuffer sb = new StringBuffer();
		sb.append("@");
		sb.append(this.entryType.keyname);
		sb.append("{");
		sb.append(this.key);
		sb.append(", \n");
		sb.append(keyValue("addendum", this.addendum));
		sb.append(keyValue("date", this.date));
		sb.append(keyValue("doi", this.doi));
		sb.append(keyValue("editor", this.editor));
		sb.append(keyValue("editora", this.editora));
		sb.append(keyValue("editorb", this.editorb));
		sb.append(keyValue("editorc", this.editorc));
		sb.append(keyValue("eprint", this.eprint));
		sb.append(keyValue("eprintclass", this.eprintclass));
		sb.append(keyValue("eprinttype", this.eprinttype));
		sb.append(keyValue("issn", this.issn));
		sb.append(keyValue("issue", this.issue));
		sb.append(keyValue("issuesubtitle", this.issuesubtitle));
		sb.append(keyValue("issuetitle", this.issuetitle));
		sb.append(keyValue("language", this.language));
		sb.append(keyValue("month", this.month));
		sb.append(keyValue("note", this.note));
		sb.append(keyValue("number", this.number));
		sb.append(keyValue("pubstate", this.pubstate));
		sb.append(keyValue("series", this.series));
		sb.append(keyValue("subtitle", this.subtitle));
		sb.append(keyValue("title", this.title));
		sb.append(keyValue("url", this.url));
		sb.append(keyValue("urldate", this.urldate));
		sb.append(keyValue("volume", this.volume));
		sb.append(keyValue("year", this.year));
		sb.append("}\n");
		return sb.toString();
	}

public String getEditor() {
	return editor;
}

public void setEditor(String editor) {
	this.editor = editor;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getEditora() {
	return editora;
}

public void setEditora(String editora) {
	this.editora = editora;
}

public String getEditorb() {
	return editorb;
}

public void setEditorb(String editorb) {
	this.editorb = editorb;
}

public String getEditorc() {
	return editorc;
}

public void setEditorc(String editorc) {
	this.editorc = editorc;
}

public String getSubtitle() {
	return subtitle;
}

public void setSubtitle(String subtitle) {
	this.subtitle = subtitle;
}

public String getIssuetitle() {
	return issuetitle;
}

public void setIssuetitle(String issuetitle) {
	this.issuetitle = issuetitle;
}

public String getIssuesubtitle() {
	return issuesubtitle;
}

public void setIssuesubtitle(String issuesubtitle) {
	this.issuesubtitle = issuesubtitle;
}

public String getLanguage() {
	return language;
}

public void setLanguage(String language) {
	this.language = language;
}

public String getSeries() {
	return series;
}

public void setSeries(String series) {
	this.series = series;
}

public String getVolume() {
	return volume;
}

public void setVolume(String volume) {
	this.volume = volume;
}

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public String getIssue() {
	return issue;
}

public void setIssue(String issue) {
	this.issue = issue;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getMonth() {
	return month;
}

public void setMonth(String month) {
	this.month = month;
}

public String getYear() {
	return year;
}

public void setYear(String year) {
	this.year = year;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}

public String getIssn() {
	return issn;
}

public void setIssn(String issn) {
	this.issn = issn;
}

public String getAddendum() {
	return addendum;
}

public void setAddendum(String addendum) {
	this.addendum = addendum;
}

public String getPubstate() {
	return pubstate;
}

public void setPubstate(String pubstate) {
	this.pubstate = pubstate;
}

public String getDoi() {
	return doi;
}

public void setDoi(String doi) {
	this.doi = doi;
}

public String getEprint() {
	return eprint;
}

public void setEprint(String eprint) {
	this.eprint = eprint;
}

public String getEprintclass() {
	return eprintclass;
}

public void setEprintclass(String eprintclass) {
	this.eprintclass = eprintclass;
}

public String getEprinttype() {
	return eprinttype;
}

public void setEprinttype(String eprinttype) {
	this.eprinttype = eprinttype;
}

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}

public String getUrldate() {
	return urldate;
}

public void setUrldate(String urldate) {
	this.urldate = urldate;
}
}
