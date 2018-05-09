package org.ocmc.ioc.liturgical.schemas.models.bibliography;

import org.ocmc.ioc.liturgical.schemas.constants.BIBTEX_ENTRY_TYPES;

import org.ocmc.ioc.liturgical.schemas.models.supers.BibliographyEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;


public class BibEntryUnpublished extends BibliographyEntry {

	private static final Logger logger = LoggerFactory.getLogger(BibEntryUnpublished.class);
	private static String schema = BibEntryUnpublished.class.getSimpleName();
	private static double schemaVersion = 1.1;

	public BibEntryUnpublished(
			String library
			, String key
) {
		super(library, key, schema, schemaVersion, BIBTEX_ENTRY_TYPES.UNPUBLISHED);
		this.library = library;
		this.key = key;
	}
	@Attributes(required = true, description = "author")
	@Expose public String author = "";

	@Attributes(required = true, description = "title")
	@Expose public String title = "";

	@Attributes(required = false, description = "subtitle")
	@Expose public String subtitle = "";

	@Attributes(required = false, description = "titleaddon")
	@Expose public String titleaddon = "";

	@Attributes(required = false, description = "type")
	@Expose public String type = "";

	@Attributes(required = false, description = "eventtitle")
	@Expose public String eventtitle = "";

	@Attributes(required = false, description = "eventtitleaddon")
	@Expose public String eventtitleaddon = "";

	@Attributes(required = false, description = "eventdate")
	@Expose public String eventdate = "";

	@Attributes(required = false, description = "venue")
	@Expose public String venue = "";

	@Attributes(required = false, description = "language")
	@Expose public String language = "";

	@Attributes(required = false, description = "howpublished")
	@Expose public String howpublished = "";

	@Attributes(required = false, description = "note")
	@Expose public String note = "";

	@Attributes(required = false, description = "location")
	@Expose public String location = "";

	@Attributes(required = false, description = "isbn")
	@Expose public String isbn = "";

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
		sb.append(keyValue("author", this.author));
		sb.append(keyValue("date", this.date));
		sb.append(keyValue("eventdate", this.eventdate));
		sb.append(keyValue("eventtitle", this.eventtitle));
		sb.append(keyValue("eventtitleaddon", this.eventtitleaddon));
		sb.append(keyValue("howpublished", this.howpublished));
		sb.append(keyValue("isbn", this.isbn));
		sb.append(keyValue("language", this.language));
		sb.append(keyValue("location", this.location));
		sb.append(keyValue("month", this.month));
		sb.append(keyValue("note", this.note));
		sb.append(keyValue("pubstate", this.pubstate));
		sb.append(keyValue("subtitle", this.subtitle));
		sb.append(keyValue("title", this.title));
		sb.append(keyValue("titleaddon", this.titleaddon));
		sb.append(keyValue("type", this.type));
		sb.append(keyValue("url", this.url));
		sb.append(keyValue("urldate", this.urldate));
		sb.append(keyValue("venue", this.venue));
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

public String getEventtitle() {
	return eventtitle;
}

public void setEventtitle(String eventtitle) {
	this.eventtitle = eventtitle;
}

public String getEventtitleaddon() {
	return eventtitleaddon;
}

public void setEventtitleaddon(String eventtitleaddon) {
	this.eventtitleaddon = eventtitleaddon;
}

public String getEventdate() {
	return eventdate;
}

public void setEventdate(String eventdate) {
	this.eventdate = eventdate;
}

public String getVenue() {
	return venue;
}

public void setVenue(String venue) {
	this.venue = venue;
}

public String getLanguage() {
	return language;
}

public void setLanguage(String language) {
	this.language = language;
}

public String getHowpublished() {
	return howpublished;
}

public void setHowpublished(String howpublished) {
	this.howpublished = howpublished;
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

public String getIsbn() {
	return isbn;
}

public void setIsbn(String isbn) {
	this.isbn = isbn;
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
