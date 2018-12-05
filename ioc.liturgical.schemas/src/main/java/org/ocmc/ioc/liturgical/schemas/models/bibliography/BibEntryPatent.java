package org.ocmc.ioc.liturgical.schemas.models.bibliography;

import org.ocmc.ioc.liturgical.schemas.constants.BIBTEX_ENTRY_TYPES;

import org.ocmc.ioc.liturgical.schemas.models.supers.BibliographyEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

@Attributes(title = "Patent", description = "A patent or patent request. The number or record token is given in the number field. Use the type field to specify the type and the location field to indicate the scope of the patent, if different from the scope implied by the type")
public class BibEntryPatent extends BibliographyEntry {

	private static final Logger logger = LoggerFactory.getLogger(BibEntryPatent.class);
	private static String schema = BibEntryPatent.class.getSimpleName();
	private static double schemaVersion = 1.1;

	public BibEntryPatent(
			String library
			, String key
) {
		super(library, key, schema, schemaVersion, BIBTEX_ENTRY_TYPES.PATENT);
		this.library = library;
		this.key = key;
	}
	@Attributes(required = true, description = "author")
	@Expose public String author = "";

	@Attributes(required = true, description = "title")
	@Expose public String title = "";

	@Attributes(id="top", required = false, description = "shorttitle")
	@Expose public String shorttitle = "";

	@Attributes(required = true, description = "number")
	@Expose public String number = "";

	@Attributes(required = false, description = "holder")
	@Expose public String holder = "";

	@Attributes(required = false, description = "subtitle")
	@Expose public String subtitle = "";

	@Attributes(required = false, description = "titleaddon")
	@Expose public String titleaddon = "";

	@Attributes(required = false, description = "type")
	@Expose public String type = "";

	@Attributes(required = false, description = "version")
	@Expose public String version = "";

	@Attributes(required = false, description = "location")
	@Expose public String location = "";

	@Attributes(required = false, description = "note")
	@Expose public String note = "";

	@Attributes(required = false, description = "date")
	@Expose public String date = "";

	@Attributes(required = false, description = "month")
	@Expose public String month = "";

	@Attributes(required = false, description = "year")
	@Expose public String year = "";

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
		sb.append(keyValue("date", this.date));
		sb.append(keyValue("doi", this.doi));
		sb.append(keyValue("eprint", this.eprint));
		sb.append(keyValue("eprintclass", this.eprintclass));
		sb.append(keyValue("eprinttype", this.eprinttype));
		sb.append(keyValue("holder", this.holder));
		sb.append(keyValue("location", this.location));
		sb.append(keyValue("month", this.month));
		sb.append(keyValue("note", this.note));
		sb.append(keyValue("number", this.number));
		sb.append(keyValue("pubstate", this.pubstate));
		sb.append(keyValue("shorttitle", this.shorttitle));
		sb.append(keyValue("subtitle", this.subtitle));
		sb.append(keyValue("title", this.title));
		sb.append(keyValue("keywords", this.getSourceType().keyname));
		sb.append(keyValue("titleaddon", this.titleaddon));
		sb.append(keyValue("type", this.type));
		sb.append(keyValue("url", this.url));
		sb.append(keyValue("urldate", this.urldate));
		sb.append(keyValue("version", this.version));
		sb.append(keyValue("year", this.year));
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

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public String getHolder() {
	return holder;
}

public void setHolder(String holder) {
	this.holder = holder;
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

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getVersion() {
	return version;
}

public void setVersion(String version) {
	this.version = version;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
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
