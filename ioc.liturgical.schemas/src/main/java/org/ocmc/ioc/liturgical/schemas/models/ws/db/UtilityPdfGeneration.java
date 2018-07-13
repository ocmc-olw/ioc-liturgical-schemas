package org.ocmc.ioc.liturgical.schemas.models.ws.db;

import org.ocmc.ioc.liturgical.schemas.constants.FALLBACKS;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

@Attributes(title = "PDF Generation Utility", description = "Data required to submit a PDF generation batch run")
public class UtilityPdfGeneration extends Utility {
	
	@Attributes(required = true, readonly=false, description = "Left Column Library")
	@Expose public String leftLibrary =  "gr_gr_cog";

	@Attributes(required = true, readonly=false, description = "Left Column Fallback")
	@Expose public FALLBACKS leftFallback =  FALLBACKS.AGES_GREEK;

	@Attributes(required = false, readonly=false, description = "Center Column Library")
	@Expose public String centerLibrary =  "en_us_dedes";

	@Attributes(required = false, readonly=false, description = "Center Column Fallback")
	@Expose public FALLBACKS centerFallback =  FALLBACKS.AGES_ENGLISH;

	@Attributes(required = false, readonly=false, description = "Right Column Library")
	@Expose public String rightLibrary =  "";

	@Attributes(required = true, readonly=false, description = "Right Column Fallback")
	@Expose public FALLBACKS rightFallback =  FALLBACKS.AGES_ENGLISH;
	
	@Attributes(required = true, readonly=false, description = "URL Regular Expression (Default is for the Octoechos). ")
	@Expose public String pattern = "/h/b/oc/m./d.).*";

	@Attributes(required = true, readonly=true, description = "URL Regular Expression Example - Services")
	@Expose public String patternEx1 = "/h/s/2018/(04|05)/(01|31)/(ve|pl|co|ma|li|gh|vl|mo).*";

	@Attributes(required = true, readonly=true, description = "URL Regular Expression Example - Triodion. ")
	@Expose public String patternEx2 = "/h/b/tr/(d001|d002)/(ve|ma|pl|gh|em3|vl|co1).*";

	public UtilityPdfGeneration() {
		super();
	}

	public String getLeftLibrary() {
		return leftLibrary;
	}

	public void setLeftLibrary(String leftLibrary) {
		this.leftLibrary = leftLibrary;
	}

	public FALLBACKS getLeftFallback() {
		return leftFallback;
	}

	public void setLeftFallback(FALLBACKS leftFallback) {
		this.leftFallback = leftFallback;
	}

	public String getCenterLibrary() {
		return centerLibrary;
	}

	public void setCenterLibrary(String centerLibrary) {
		this.centerLibrary = centerLibrary;
	}

	public FALLBACKS getCenterFallback() {
		return centerFallback;
	}

	public void setCenterFallback(FALLBACKS centerFallback) {
		this.centerFallback = centerFallback;
	}

	public String getRightLibrary() {
		return rightLibrary;
	}

	public void setRightLibrary(String rightLibrary) {
		this.rightLibrary = rightLibrary;
	}

	public FALLBACKS getRightFallback() {
		return rightFallback;
	}

	public void setRightFallback(FALLBACKS rightFallback) {
		this.rightFallback = rightFallback;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getPatternEx1() {
		return patternEx1;
	}

	public void setPatternEx1(String patternEx1) {
		this.patternEx1 = patternEx1;
	}

	public String getPatternEx2() {
		return patternEx2;
	}

	public void setPatternEx2(String patternEx2) {
		this.patternEx2 = patternEx2;
	}
}
