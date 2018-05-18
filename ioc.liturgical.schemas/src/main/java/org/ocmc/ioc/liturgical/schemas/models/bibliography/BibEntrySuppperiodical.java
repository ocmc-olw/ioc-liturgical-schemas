package org.ocmc.ioc.liturgical.schemas.models.bibliography;

import org.ocmc.ioc.liturgical.schemas.constants.BIBTEX_ENTRY_TYPES;

import org.ocmc.ioc.liturgical.schemas.models.supers.BibliographyEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

@Attributes(title = "Periodical Supplement", description = "Supplemental material in a @periodical. This type is similar to @suppbook but related to the @periodical entry type. The role of this entry type may be more obvious if you bear in mind that the @article type could also be called @inperiodical. This type may be useful when referring to items such as regular columns, obituaries, letters to the editor, etc. which only have a generic title. Style guides may require such items to be formatted differently from articles in the strict sense of the word. The standard styles will treat this entry type as an alias for @article.")
public class BibEntrySuppperiodical extends BibliographyEntry {

	private static final Logger logger = LoggerFactory.getLogger(BibEntrySuppperiodical.class);
	private static String schema = BibEntrySuppperiodical.class.getSimpleName();
	private static double schemaVersion = 1.1;

	public BibEntrySuppperiodical(
			String library
			, String key
) {
		super(library, key, schema, schemaVersion, BIBTEX_ENTRY_TYPES.SUPPPERIODICAL);
		this.library = library;
		this.key = key;
	}
	@Attributes(required = true, description = "author")
	@Expose public String author = "";

	@Attributes(required = true, description = "title")
	@Expose public String title = "";

	@Attributes(required = true, description = "journaltitle")
	@Expose public String journaltitle = "";

	@Attributes(required = true, description = "date")
	@Expose public String date = "";

	@Attributes(required = false, description = "translator")
	@Expose public String translator = "";

	@Attributes(required = false, description = "annotator")
	@Expose public String annotator = "";

	@Attributes(required = false, description = "commentator")
	@Expose public String commentator = "";

	@Attributes(required = false, description = "subtitle")
	@Expose public String subtitle = "";

	@Attributes(required = false, description = "titleaddon")
	@Expose public String titleaddon = "";

	@Attributes(required = false, description = "editor")
	@Expose public String editor = "";

	@Attributes(required = false, description = "editora")
	@Expose public String editora = "";

	@Attributes(required = false, description = "editorb")
	@Expose public String editorb = "";

	@Attributes(required = false, description = "editorc")
	@Expose public String editorc = "";

	@Attributes(required = false, description = "journalsubtitle")
	@Expose public String journalsubtitle = "";

	@Attributes(required = false, description = "issuetitle")
	@Expose public String issuetitle = "";

	@Attributes(required = false, description = "issuesubtitle")
	@Expose public String issuesubtitle = "";

	@Attributes(required = false, description = "language")
	@Expose public String language = "";

	@Attributes(required = false, description = "origlanguage")
	@Expose public String origlanguage = "";

	@Attributes(required = false, description = "series")
	@Expose public String series = "";

	@Attributes(required = false, description = "volume")
	@Expose public String volume = "";

	@Attributes(required = false, description = "number")
	@Expose public String number = "";

	@Attributes(required = false, description = "eid")
	@Expose public String eid = "";

	@Attributes(required = false, description = "issue")
	@Expose public String issue = "";

	@Attributes(required = false, description = "month")
	@Expose public String month = "";

	@Attributes(required = false, description = "pages")
	@Expose public String pages = "";

	@Attributes(required = false, description = "version")
	@Expose public String version = "";

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

	@Override
public String toBibtex() {
		StringBuffer sb = new StringBuffer();
		sb.append("@");
		sb.append(this.entryType.keyname);
		sb.append("{");
		sb.append(this.key);
		sb.append(", \n");
		sb.append(keyValue("addendum", this.addendum));
		sb.append(keyValue("annotator", this.annotator));
		sb.append(keyValue("author", this.author));
		sb.append(keyValue("commentator", this.commentator));
		sb.append(keyValue("date", this.date));
		sb.append(keyValue("doi", this.doi));
		sb.append(keyValue("editor", this.editor));
		sb.append(keyValue("editora", this.editora));
		sb.append(keyValue("editorb", this.editorb));
		sb.append(keyValue("editorc", this.editorc));
		sb.append(keyValue("eid", this.eid));
		sb.append(keyValue("eprint", this.eprint));
		sb.append(keyValue("eprintclass", this.eprintclass));
		sb.append(keyValue("eprinttype", this.eprinttype));
		sb.append(keyValue("issn", this.issn));
		sb.append(keyValue("issue", this.issue));
		sb.append(keyValue("issuesubtitle", this.issuesubtitle));
		sb.append(keyValue("issuetitle", this.issuetitle));
		sb.append(keyValue("journalsubtitle", this.journalsubtitle));
		sb.append(keyValue("journaltitle", this.journaltitle));
		sb.append(keyValue("language", this.language));
		sb.append(keyValue("month", this.month));
		sb.append(keyValue("note", this.note));
		sb.append(keyValue("number", this.number));
		sb.append(keyValue("origlanguage", this.origlanguage));
		sb.append(keyValue("pages", this.pages));
		sb.append(keyValue("pubstate", this.pubstate));
		sb.append(keyValue("series", this.series));
		sb.append(keyValue("subtitle", this.subtitle));
		sb.append(keyValue("title", this.title));
		sb.append(keyValue("titleaddon", this.titleaddon));
		sb.append(keyValue("translator", this.translator));
		sb.append(keyValue("url", this.url));
		sb.append(keyValue("urldate", this.urldate));
		sb.append(keyValue("version", this.version));
		sb.append(keyValue("volume", this.volume));
		sb.append("}\n");
		return sb.toString();
	}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getJournaltitle() {
	return journaltitle;
}

public void setJournaltitle(String journaltitle) {
	this.journaltitle = journaltitle;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getTranslator() {
	return translator;
}

public void setTranslator(String translator) {
	this.translator = translator;
}

public String getAnnotator() {
	return annotator;
}

public void setAnnotator(String annotator) {
	this.annotator = annotator;
}

public String getCommentator() {
	return commentator;
}

public void setCommentator(String commentator) {
	this.commentator = commentator;
}

public String getSubtitle() {
	return subtitle;
}

public void setSubtitle(String subtitle) {
	this.subtitle = subtitle;
}

public String getTitleaddon() {
	return titleaddon;
}

public void setTitleaddon(String titleaddon) {
	this.titleaddon = titleaddon;
}

public String getEditor() {
	return editor;
}

public void setEditor(String editor) {
	this.editor = editor;
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

public String getJournalsubtitle() {
	return journalsubtitle;
}

public void setJournalsubtitle(String journalsubtitle) {
	this.journalsubtitle = journalsubtitle;
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

public String getOriglanguage() {
	return origlanguage;
}

public void setOriglanguage(String origlanguage) {
	this.origlanguage = origlanguage;
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

public String getEid() {
	return eid;
}

public void setEid(String eid) {
	this.eid = eid;
}

public String getIssue() {
	return issue;
}

public void setIssue(String issue) {
	this.issue = issue;
}

public String getMonth() {
	return month;
}

public void setMonth(String month) {
	this.month = month;
}

public String getPages() {
	return pages;
}

public void setPages(String pages) {
	this.pages = pages;
}

public String getVersion() {
	return version;
}

public void setVersion(String version) {
	this.version = version;
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
