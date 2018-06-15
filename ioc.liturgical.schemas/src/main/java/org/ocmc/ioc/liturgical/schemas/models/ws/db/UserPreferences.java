package org.ocmc.ioc.liturgical.schemas.models.ws.db;

import org.ocmc.ioc.liturgical.schemas.constants.BIBTEX_STYLES;
import org.ocmc.ioc.liturgical.schemas.constants.USER_INTERFACE_LANGUAGES;
import org.ocmc.ioc.liturgical.schemas.models.ws.supers.WsDbAbstractModel;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

public class UserPreferences extends WsDbAbstractModel {
	@Attributes(required = false, description = "User Interface Language")
	@Expose public USER_INTERFACE_LANGUAGES langUserInterface = USER_INTERFACE_LANGUAGES.ENGLISH;

	@Attributes(required = false, description = "When generating a PDF, what name do you want displayed as the author?")
	@Expose public String author = "";

	@Attributes(required = false, description = "When generating a PDF, what personal title do you want displayed?")
	@Expose public String authorTitle = "";

	@Attributes(required = false, description = "When generating a PDF, what organization affiliation do you want displayed?")
	@Expose public String authorAffiliation = "";

	@Attributes(required = false, description = "When generating a PDF, what BibLaTex style do you want to use for citations and bibliography?")
	@Expose public BIBTEX_STYLES bibLatexStyle = BIBTEX_STYLES.AUTHOR_YEAR;

	@Attributes(required = false, description = "When generating a PDF file, do you prefer to combine notes based on the note heading?")
	@Expose public boolean combineNotes = false;

	@Attributes(required = false, description = "When generating a PDF file, do you want a table of contents to be created?")
	@Expose public boolean createToc = false;

	@Attributes(required = false, description = "When generating a PDF file, do you want to include the grammatical analysis, if it exists?")
	@Expose public boolean includeGrammar = false;

	@Attributes(required = false, description = "When generating a PDF file, do you want to include your personal notes, if they exist?")
	@Expose public boolean includeNotesUser = false;

	@Attributes(required = false, description = "When generating a PDF file, do you want to include translation advice notes, if they exist?")
	@Expose public boolean includeNotesTransAdvice = false;

	@Attributes(required = false, description = "When generating a PDF file, do you want to include instructions on how to use the translator's handbook?")
	@Expose public boolean includeTransHandbookInstructions = false;

	public UserPreferences() {
		super();
		this.serialVersionUID = 1.1;
	}

	public USER_INTERFACE_LANGUAGES getLangUserInterface() {
		return langUserInterface;
	}

	public void setLangUserInterface(USER_INTERFACE_LANGUAGES langUserInterface) {
		this.langUserInterface = langUserInterface;
	}

	public String getAuthorTitle() {
		return authorTitle;
	}

	public void setAuthorTitle(String authorTitle) {
		this.authorTitle = authorTitle;
	}

	public String getAuthorAffiliation() {
		return authorAffiliation;
	}

	public void setAuthorAffiliation(String authorAffiliation) {
		this.authorAffiliation = authorAffiliation;
	}

	public BIBTEX_STYLES getBibLatexStyle() {
		return bibLatexStyle;
	}

	public void setBibLatexStyle(BIBTEX_STYLES bibLatexStyle) {
		this.bibLatexStyle = bibLatexStyle;
	}

	public boolean isCombineNotes() {
		return combineNotes;
	}

	public void setCombineNotes(boolean combineNotes) {
		this.combineNotes = combineNotes;
	}

	public boolean isCreateToc() {
		return createToc;
	}

	public void setCreateToc(boolean createToc) {
		this.createToc = createToc;
	}

	public boolean isIncludeGrammar() {
		return includeGrammar;
	}

	public void setIncludeGrammar(boolean includeGrammar) {
		this.includeGrammar = includeGrammar;
	}

	public boolean isIncludeNotesUser() {
		return includeNotesUser;
	}

	public void setIncludeNotesUser(boolean includeNotesUser) {
		this.includeNotesUser = includeNotesUser;
	}

	public boolean isIncludeNotesTransAdvice() {
		return includeNotesTransAdvice;
	}

	public void setIncludeNotesTransAdvice(boolean includeNotesTransAdvice) {
		this.includeNotesTransAdvice = includeNotesTransAdvice;
	}

	public boolean isIncludeTransHandbookInstructions() {
		return includeTransHandbookInstructions;
	}

	public void setIncludeTransHandbookInstructions(boolean includeTransHandbookInstructions) {
		this.includeTransHandbookInstructions = includeTransHandbookInstructions;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
