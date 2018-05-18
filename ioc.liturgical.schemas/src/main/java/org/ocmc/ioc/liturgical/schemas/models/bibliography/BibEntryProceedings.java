package org.ocmc.ioc.liturgical.schemas.models.bibliography;

import org.ocmc.ioc.liturgical.schemas.constants.BIBTEX_ENTRY_TYPES;

import org.ocmc.ioc.liturgical.schemas.models.supers.BibliographyEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

@Attributes(title = "Proceedings", description = "A single-volume conference proceedings. This type is very similar to @collection. It supports an optional organization field which holds the sponsoring institution.")
public class BibEntryProceedings extends BibliographyEntry {

	private static final Logger logger = LoggerFactory.getLogger(BibEntryProceedings.class);
	private static String schema = BibEntryProceedings.class.getSimpleName();
	private static double schemaVersion = 1.1;

	public BibEntryProceedings(
			String library
			, String key
) {
		super(library, key, schema, schemaVersion, BIBTEX_ENTRY_TYPES.PROCEEDINGS);
		this.library = library;
		this.key = key;
	}
	@Attributes(id="top", required = true, description = "title")
	@Expose public String title = "";

	@Attributes(id="top", required = true, description = "date")
	@Expose public String date = "";

	@Attributes(id="top", required = false, description = "editor")
	@Expose public String editor = "";

	@Attributes(id="top", required = false, description = "publisher")
	@Expose public String publisher = "";

	@Attributes(id="top", required = false, description = "location")
	@Expose public String location = "";

	@Attributes(required = false, description = "subtitle")
	@Expose public String subtitle = "";

	@Attributes(required = false, description = "titleaddon")
	@Expose public String titleaddon = "";

	@Attributes(required = false, description = "maintitle")
	@Expose public String maintitle = "";

	@Attributes(required = false, description = "mainsubtitle")
	@Expose public String mainsubtitle = "";

	@Attributes(required = false, description = "maintitleaddon")
	@Expose public String maintitleaddon = "";

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

	@Attributes(required = false, description = "volume")
	@Expose public String volume = "";

	@Attributes(required = false, description = "part")
	@Expose public String part = "";

	@Attributes(required = false, description = "volumes")
	@Expose public String volumes = "";

	@Attributes(required = false, description = "series")
	@Expose public String series = "";

	@Attributes(required = false, description = "number")
	@Expose public String number = "";

	@Attributes(required = false, description = "note")
	@Expose public String note = "";

	@Attributes(required = false, description = "organization")
	@Expose public String organization = "";

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
		sb.append(keyValue("chapter", this.chapter));
		sb.append(keyValue("date", this.date));
		sb.append(keyValue("doi", this.doi));
		sb.append(keyValue("editor", this.editor));
		sb.append(keyValue("eprint", this.eprint));
		sb.append(keyValue("eprintclass", this.eprintclass));
		sb.append(keyValue("eprinttype", this.eprinttype));
		sb.append(keyValue("eventdate", this.eventdate));
		sb.append(keyValue("eventtitle", this.eventtitle));
		sb.append(keyValue("eventtitleaddon", this.eventtitleaddon));
		sb.append(keyValue("isbn", this.isbn));
		sb.append(keyValue("language", this.language));
		sb.append(keyValue("location", this.location));
		sb.append(keyValue("mainsubtitle", this.mainsubtitle));
		sb.append(keyValue("maintitle", this.maintitle));
		sb.append(keyValue("maintitleaddon", this.maintitleaddon));
		sb.append(keyValue("month", this.month));
		sb.append(keyValue("note", this.note));
		sb.append(keyValue("number", this.number));
		sb.append(keyValue("organization", this.organization));
		sb.append(keyValue("pages", this.pages));
		sb.append(keyValue("pagetotal", this.pagetotal));
		sb.append(keyValue("part", this.part));
		sb.append(keyValue("publisher", this.publisher));
		sb.append(keyValue("pubstate", this.pubstate));
		sb.append(keyValue("series", this.series));
		sb.append(keyValue("subtitle", this.subtitle));
		sb.append(keyValue("title", this.title));
		sb.append(keyValue("titleaddon", this.titleaddon));
		sb.append(keyValue("url", this.url));
		sb.append(keyValue("urldate", this.urldate));
		sb.append(keyValue("venue", this.venue));
		sb.append(keyValue("volume", this.volume));
		sb.append(keyValue("volumes", this.volumes));
		sb.append("}\n");
		return sb.toString();
	}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getEditor() {
	return editor;
}

public void setEditor(String editor) {
	this.editor = editor;
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

public String getMaintitle() {
	return maintitle;
}

public void setMaintitle(String maintitle) {
	this.maintitle = maintitle;
}

public String getMainsubtitle() {
	return mainsubtitle;
}

public void setMainsubtitle(String mainsubtitle) {
	this.mainsubtitle = mainsubtitle;
}

public String getMaintitleaddon() {
	return maintitleaddon;
}

public void setMaintitleaddon(String maintitleaddon) {
	this.maintitleaddon = maintitleaddon;
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

public String getVolume() {
	return volume;
}

public void setVolume(String volume) {
	this.volume = volume;
}

public String getPart() {
	return part;
}

public void setPart(String part) {
	this.part = part;
}

public String getVolumes() {
	return volumes;
}

public void setVolumes(String volumes) {
	this.volumes = volumes;
}

public String getSeries() {
	return series;
}

public void setSeries(String series) {
	this.series = series;
}

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}

public String getOrganization() {
	return organization;
}

public void setOrganization(String organization) {
	this.organization = organization;
}

public String getPublisher() {
	return publisher;
}

public void setPublisher(String publisher) {
	this.publisher = publisher;
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
}
