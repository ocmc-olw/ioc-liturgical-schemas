package org.ocmc.ioc.liturgical.schemas.models.LDOM;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

public class AgesIndexTableRowData extends AbstractModel {
	@Expose String url = ""; // url to the file
	@Expose String type = ""; // Sacrament name, matins, vespers, liturgy, etc.
	@Expose String typeCode = ""; // 
	@Expose String date = "";
	@Expose String dayOfWeek = "";
	@Expose String fileType = "";
	@Expose String languages = "";
	@Expose long keyCount = 0; 
	@Expose long sentenceCount = 0;
	@Expose long tokenCount = 0;
	@Expose long textCount = 0;
	@Expose long textTokenCount = 0;
	@Expose long uniqueTokenCount = 0;
	@Expose long noEnglishCount = 0;
	
	public AgesIndexTableRowData() {
		super();
	}
	
	public AgesIndexTableRowData(boolean printPretty) {
		super();
		super.setPrettyPrint(printPretty);
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getKeyCount() {
		return keyCount;
	}

	public void setKeyCount(long keyCount) {
		this.keyCount = keyCount;
	}

	public long getSentenceCount() {
		return sentenceCount;
	}

	public void setSentenceCount(long sentenceCount) {
		this.sentenceCount = sentenceCount;
	}

	public long getTokenCount() {
		return tokenCount;
	}

	public void setTokenCount(long tokenCount) {
		this.tokenCount = tokenCount;
	}

	public long getTextCount() {
		return textCount;
	}

	public void setTextCount(long textCount) {
		this.textCount = textCount;
	}

	public long getTextTokenCount() {
		return textTokenCount;
	}

	public void setTextTokenCount(long textTokenCount) {
		this.textTokenCount = textTokenCount;
	}

	public long getUniqueTokenCount() {
		return uniqueTokenCount;
	}

	public void setUniqueTokenCount(long uniqueTokenCount) {
		this.uniqueTokenCount = uniqueTokenCount;
	}

	public long getNoEnglishCount() {
		return noEnglishCount;
	}

	public void setNoEnglishCount(long noEnglishCount) {
		this.noEnglishCount = noEnglishCount;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
}
