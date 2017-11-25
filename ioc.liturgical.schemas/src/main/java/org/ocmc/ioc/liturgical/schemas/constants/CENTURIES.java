package org.ocmc.ioc.liturgical.schemas.constants;

public enum CENTURIES {
    BC20("-20", "20 BC (π.Χ.)")
    , BC19("-19", "19 BC (π.Χ.)")
    , BC18("-18", "18 BC (π.Χ.)")
    , BC17("-17", "17 BC (π.Χ.)")
    , BC16("-16", "16 BC (π.Χ.)")
    , BC15("-15", "15 BC (π.Χ.)")
    , BC14("-14", "14 BC (π.Χ.)")
    , BC13("-13", "13 BC (π.Χ.)")
    , BC12("-12", "12 BC (π.Χ.)")
    , BC11("-11", "11 BC (π.Χ.)")
    , BC10("-10", "10 BC (π.Χ.)")
    , BC09("-09", "09 BC (π.Χ.)")
    , BC08("-08", "08 BC (π.Χ.)")
    , BC07("-07", "07 BC (π.Χ.)")
    , BC06("-06", "06 BC (π.Χ.)")
    , BC05("-05", "05 BC (π.Χ.)")
    , BC04("-04", "04 BC (π.Χ.)")
    , BC03("-03", "03 BC (π.Χ.)")
    , BC02("-02", "02 BC (π.Χ.)")
    , BC01("-01", "01 BC (π.Χ.)")
    , AD01("01", "01 AD (μ.Χ.)")
    , AD02("02", "02 AD (μ.Χ.)")
    , AD03("03", "03 AD (μ.Χ.)")
    , AD04("04", "04 AD (μ.Χ.)")
    , AD05("05", "05 AD (μ.Χ.)")
    , AD06("06", "06 AD (μ.Χ.)")
    , AD07("07", "07 AD (μ.Χ.)")
    , AD08("08", "08 AD (μ.Χ.)")
    , AD09("09", "09 AD (μ.Χ.)")
    , AD10("10", "10 AD (μ.Χ.)")
    , AD11("11", "11 AD (μ.Χ.)")
    , AD12("12", "12 AD (μ.Χ.)")
    , AD13("13", "13 AD (μ.Χ.)")
    , AD14("14", "14 AD (μ.Χ.)")
    , AD15("15", "15 AD (μ.Χ.)")
    , AD16("16", "16 AD (μ.Χ.)")
    , AD17("17", "17 AD (μ.Χ.)")
    , AD18("18", "18 AD (μ.Χ.)")
    , AD19("19", "19 AD (μ.Χ.)")
    , AD20("20", "20 AD (μ.Χ.)")
    , AD21("21", "21 AD (μ.Χ.)")
    , UNKNOWN("unknown","Unknown");
	;

	public String code = "";
	public String label = "";
	
	private CENTURIES(
			String code
			, String label
			) {
		this.code = code;
		this.label = label;
	}
		
}

