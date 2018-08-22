package org.ocmc.ioc.liturgical.schemas.constants;

public enum BIBLICAL_BOOKS_ENUM {
	GEN("Genesis", "101")
	, EXO("Exodus", "102")
	, LEV("Leviticus", "103")
	, NUM("Numbers", "104")
	, DEU("Deuteronomy", "105")
	, JOS("Joshua", "106")
	, JDG("Judges", "107")
	, RUT("Ruth", "108")
	, SA1("I Samuel", "109")
	, SA2("II Samuel", "110")
	, KI1("I Kings", "111")
	, KI2("II Kings", "112")
	, CH1("I Chronicles", "113")
	, CH2("II Chronicles", "114")
	, ES1("1 Esdras", "115")
	, ES2("Ezra-Nehemiah", "116")
	, TOB("Tobit or Tobias", "117")
	, JDT("Judith", "118")
	, EST("Esther", "119")
	, MA1("1 Maccabees", "120")
	, MA2("2 Maccabees", "121")
	, MA3("3 Maccabees", "122")
	, MA4("4 Maccabees", "123")
	, PSA("Psalm/Psalms", "124")
	, ODE("Biblical Odes", "125")
	, PRO("Proverbs", "126")
	, ECC("Ecclesiastes", "127")
	, SOS("Song of Solomon or Canticles", "128")
	, JOB("Job", "129")
	, WIS("Wisdom", "130")
	, POS("Psalms of Solomon", "131")
	, SIR("Sirach or Ecclesiasticus", "132")
	, HOS("Hosea", "133")
	, AMO("Amos", "134")
	, MIC("Micah", "135")
	, JOE("Joel", "136")
	, OBA("Obadiah", "137")
	, JON("Jonah", "138")
	, NAH("Nahum", "139")
	, HAB("Habbakuk", "140")
	, ZEP("Zephaniah", "141")
	, HAG("Haggai", "142")
	, ZEC("Zechariah", "143")
	, MAL("Malachi", "144")
	, ISA("Isaiah", "145")
	, JER("Jeremiah", "146")
	, BAR("Baruch", "147")
	, LAM("Lamentations", "148")
	, EZE("Ezekiel", "150")
	, SUS("Susanna", "151")
	, DAN("Daniel", "152")
	, BEL("Bel and the Dragon", "153")
	, MAT("Matthew", "201")
	, MAR("Mark", "202")
	, LUK("Luke", "203")
	, JOH("John", "204")
	, ACT("Acts", "205")
	, ROM("Romans", "206")
	, CO1("1 Corinthians", "207")
	, CO2("2 Corinthians", "208")
	, GAL("Galatians", "209")
	, EPH("Ephesians", "210")
	, PHP("Philippians", "211")
	, COL("Colossians", "212")
	, TH1("1 Thessalonians", "213")
	, TH2("2 Thessalonians", "214")
	, TI1("1 Timothy", "215")
	, TI2("2 Timothy", "216")
	, TIT("Titus", "217")
	, PHM("Philemon", "218")
	, HEB("Hebrews", "219")
	, JAM("James", "220")
	, PE1("1 Peter", "221")
	, PE2("2 Peter", "222")
	, JO1("1 John", "223")
	, JO2("2 John", "224")
	, JO3("3 John", "225")
	, JDE("Jude", "226")
	, REV("Revelation", "227")
	;
	
	public String fullname = "";
	public String seqNbr = "";
	
	private BIBLICAL_BOOKS_ENUM(
			String fullname
			, String seqNbr
			) {
		this.fullname = fullname;
		this.seqNbr = seqNbr;
	}
	
	public static BIBLICAL_BOOKS_ENUM enumForAbbrev(String abr) {
		String abrLower = abr.toLowerCase();
		for (BIBLICAL_BOOKS_ENUM e : BIBLICAL_BOOKS_ENUM.values()) {
			if (e.name().toLowerCase().equals(abrLower)) return e;
		}
		return null;
	}
	public static BIBLICAL_BOOKS_ENUM enumForFullname(String fullName) {
		for (BIBLICAL_BOOKS_ENUM e : BIBLICAL_BOOKS_ENUM.values()) {
			if (e.fullname.equals(fullName)) return e;
		}
		return null;
	}
}
