package org.ocmc.ioc.liturgical.schemas.models.bibliography;

import org.ocmc.ioc.liturgical.schemas.constants.BIBTEX_ENTRY_TYPES;

import org.ocmc.ioc.liturgical.schemas.models.supers.BibliographyEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

@Attributes(title = "Thesis", description = "A thesis written for an educational institution to satisfy the requirements for a degree. Use the type field to specify the type of thesis, e.g. Master's Thesis, Doctoral Thesis, Ph.D Dissertation.")
public class BibEntryThesis extends BibliographyEntry {

	private static final Logger logger = LoggerFactory.getLogger(BibEntryThesis.class);
	private static String schema = BibEntryThesis.class.getSimpleName();
	private static double schemaVersion = 1.1;

	public BibEntryThesis(
			String library
			, String key
) {
		super(library, key, schema, schemaVersion, BIBTEX_ENTRY_TYPES.THESIS);
		this.library = library;
		this.key = key;
	}
	@Attributes(required = true, description = "author")
	@Expose public String author = "";

	@Attributes(required = true, description = "title")
	@Expose public String title = "";

	@Attributes(id="top", required = false, description = "shorttitle")
	@Expose public String shorttitle = "";

	@Attributes(required = true, description = "type")
	@Expose public String type = "";

	@Attributes(required = true, description = "institution")
	@Expose public String institution = "";

	@Attributes(required = true, description = "date")
	@Expose public String date = "";

	@Attributes(required = false, description = "subtitle")
	@Expose public String subtitle = "";

	@Attributes(required = false, description = "titleaddon")
	@Expose public String titleaddon = "";

	@Attributes(required = false, description = "language")
	@Expose public String language = "";

	@Attributes(required = false, description = "note")
	@Expose public String note = "";

	@Attributes(required = false, description = "location")
	@Expose public String location = "";

	@Attributes(required = false, description = "month")
	@Expose public String month = "";

	@Attributes(required = false, description = "isbn")
	@Expose public String isbn = "";

	@Attributes(required = false, description = "chapter")
	@Expose public String chapter = "";

	@Attributes(required = false, description = "pages")
	@Expose public String pages = "";

	@Attributes(required = false, description = "pagetotal")
	@Expose public String pagetotal = "";

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
		sb.append(keyValue("author", this.author));
		sb.append(keyValue("chapter", this.chapter));
		sb.append(keyValue("date", this.date));
		sb.append(keyValue("doi", this.doi));
		sb.append(keyValue("eprint", this.eprint));
		sb.append(keyValue("eprintclass", this.eprintclass));
		sb.append(keyValue("eprinttype", this.eprinttype));
		sb.append(keyValue("institution", this.institution));
		sb.append(keyValue("isbn", this.isbn));
		sb.append(keyValue("language", this.language));
		sb.append(keyValue("location", this.location));
		sb.append(keyValue("month", this.month));
		sb.append(keyValue("note", this.note));
		sb.append(keyValue("pages", this.pages));
		sb.append(keyValue("pagetotal", this.pagetotal));
		sb.append(keyValue("pubstate", this.pubstate));
		sb.append(keyValue("shorttitle", this.shorttitle));
		sb.append(keyValue("subtitle", this.subtitle));
		sb.append(keyValue("title", this.title));
		sb.append(keyValue("keywords", this.getSourceType().keyname));
		sb.append(keyValue("titleaddon", this.titleaddon));
		sb.append(keyValue("type", this.type));
		sb.append(keyValue("url", this.url));
		sb.append(keyValue("urldate", this.urldate));
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

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getInstitution() {
	return institution;
}

public void setInstitution(String institution) {
	this.institution = institution;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
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

public String getLanguage() {
	return language;
}

public void setLanguage(String language) {
	this.language = language;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getMonth() {
	return month;
}

public void setMonth(String month) {
	this.month = month;
}

public String getIsbn() {
	return isbn;
}

public void setIsbn(String isbn) {
	this.isbn = isbn;
}

public String getChapter() {
	return chapter;
}

public void setChapter(String chapter) {
	this.chapter = chapter;
}

public String getPages() {
	return pages;
}

public void setPages(String pages) {
	this.pages = pages;
}

public String getPagetotal() {
	return pagetotal;
}

public void setPagetotal(String pagetotal) {
	this.pagetotal = pagetotal;
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

public String getShorttitle() {
	return shorttitle;
}

public void setShorttitle(String shorttitle) {
	this.shorttitle = shorttitle;
}
}
