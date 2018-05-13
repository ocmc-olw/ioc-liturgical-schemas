package org.ocmc.ioc.liturgical.schemas.models.bibliography;

import org.ocmc.ioc.liturgical.schemas.constants.BIBTEX_ENTRY_TYPES;

import org.ocmc.ioc.liturgical.schemas.models.supers.BibliographyEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

@Attributes(title = "In Reference", description = "An article in a work of reference. This is a more specific variant of the generic @incollection entry type. The standard styles will treat this entry type as an alias for @incollection.")
public class BibEntryInreference extends BibliographyEntry {

	private static final Logger logger = LoggerFactory.getLogger(BibEntryInreference.class);
	private static String schema = BibEntryInreference.class.getSimpleName();
	private static double schemaVersion = 1.1;

	public BibEntryInreference(
			String library
			, String key
) {
		super(library, key, schema, schemaVersion, BIBTEX_ENTRY_TYPES.INREFERENCE);
		this.library = library;
		this.key = key;
	}
	@Attributes(required = true, description = "author")
	@Expose public String author = "";

	@Attributes(required = true, description = "title")
	@Expose public String title = "";

	@Attributes(required = true, description = "booktitle")
	@Expose public String booktitle = "";

	@Attributes(required = true, description = "date")
	@Expose public String date = "";

	@Attributes(required = false, description = "editor")
	@Expose public String editor = "";

	@Attributes(required = false, description = "editora")
	@Expose public String editora = "";

	@Attributes(required = false, description = "editorb")
	@Expose public String editorb = "";

	@Attributes(required = false, description = "editorc")
	@Expose public String editorc = "";

	@Attributes(required = false, description = "translator")
	@Expose public String translator = "";

	@Attributes(required = false, description = "annotator")
	@Expose public String annotator = "";

	@Attributes(required = false, description = "commentator")
	@Expose public String commentator = "";

	@Attributes(required = false, description = "introduction")
	@Expose public String introduction = "";

	@Attributes(required = false, description = "foreword")
	@Expose public String foreword = "";

	@Attributes(required = false, description = "afterword")
	@Expose public String afterword = "";

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

	@Attributes(required = false, description = "booksubtitle")
	@Expose public String booksubtitle = "";

	@Attributes(required = false, description = "booktitleaddon")
	@Expose public String booktitleaddon = "";

	@Attributes(required = false, description = "language")
	@Expose public String language = "";

	@Attributes(required = false, description = "origlanguage")
	@Expose public String origlanguage = "";

	@Attributes(required = false, description = "volume")
	@Expose public String volume = "";

	@Attributes(required = false, description = "part")
	@Expose public String part = "";

	@Attributes(required = false, description = "edition")
	@Expose public String edition = "";

	@Attributes(required = false, description = "volumes")
	@Expose public String volumes = "";

	@Attributes(required = false, description = "series")
	@Expose public String series = "";

	@Attributes(required = false, description = "number")
	@Expose public String number = "";

	@Attributes(required = false, description = "note")
	@Expose public String note = "";

	@Attributes(required = false, description = "publisher")
	@Expose public String publisher = "";

	@Attributes(required = false, description = "location")
	@Expose public String location = "";

	@Attributes(required = false, description = "isbn")
	@Expose public String isbn = "";

	@Attributes(required = false, description = "chapter")
	@Expose public String chapter = "";

	@Attributes(required = false, description = "pages")
	@Expose public String pages = "";

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
		sb.append(keyValue("afterword", this.afterword));
		sb.append(keyValue("annotator", this.annotator));
		sb.append(keyValue("author", this.author));
		sb.append(keyValue("booksubtitle", this.booksubtitle));
		sb.append(keyValue("booktitle", this.booktitle));
		sb.append(keyValue("booktitleaddon", this.booktitleaddon));
		sb.append(keyValue("chapter", this.chapter));
		sb.append(keyValue("commentator", this.commentator));
		sb.append(keyValue("date", this.date));
		sb.append(keyValue("doi", this.doi));
		sb.append(keyValue("edition", this.edition));
		sb.append(keyValue("editor", this.editor));
		sb.append(keyValue("editora", this.editora));
		sb.append(keyValue("editorb", this.editorb));
		sb.append(keyValue("editorc", this.editorc));
		sb.append(keyValue("eprint", this.eprint));
		sb.append(keyValue("eprintclass", this.eprintclass));
		sb.append(keyValue("eprinttype", this.eprinttype));
		sb.append(keyValue("foreword", this.foreword));
		sb.append(keyValue("introduction", this.introduction));
		sb.append(keyValue("isbn", this.isbn));
		sb.append(keyValue("language", this.language));
		sb.append(keyValue("location", this.location));
		sb.append(keyValue("mainsubtitle", this.mainsubtitle));
		sb.append(keyValue("maintitle", this.maintitle));
		sb.append(keyValue("maintitleaddon", this.maintitleaddon));
		sb.append(keyValue("note", this.note));
		sb.append(keyValue("number", this.number));
		sb.append(keyValue("origlanguage", this.origlanguage));
		sb.append(keyValue("pages", this.pages));
		sb.append(keyValue("part", this.part));
		sb.append(keyValue("publisher", this.publisher));
		sb.append(keyValue("pubstate", this.pubstate));
		sb.append(keyValue("series", this.series));
		sb.append(keyValue("subtitle", this.subtitle));
		sb.append(keyValue("title", this.title));
		sb.append(keyValue("titleaddon", this.titleaddon));
		sb.append(keyValue("translator", this.translator));
		sb.append(keyValue("url", this.url));
		sb.append(keyValue("urldate", this.urldate));
		sb.append(keyValue("volume", this.volume));
		sb.append(keyValue("volumes", this.volumes));
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

public String getBooktitle() {
	return booktitle;
}

public void setBooktitle(String booktitle) {
	this.booktitle = booktitle;
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

public String getIntroduction() {
	return introduction;
}

public void setIntroduction(String introduction) {
	this.introduction = introduction;
}

public String getForeword() {
	return foreword;
}

public void setForeword(String foreword) {
	this.foreword = foreword;
}

public String getAfterword() {
	return afterword;
}

public void setAfterword(String afterword) {
	this.afterword = afterword;
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

public String getBooksubtitle() {
	return booksubtitle;
}

public void setBooksubtitle(String booksubtitle) {
	this.booksubtitle = booksubtitle;
}

public String getBooktitleaddon() {
	return booktitleaddon;
}

public void setBooktitleaddon(String booktitleaddon) {
	this.booktitleaddon = booktitleaddon;
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

public String getEdition() {
	return edition;
}

public void setEdition(String edition) {
	this.edition = edition;
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
