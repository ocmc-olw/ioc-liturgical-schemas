package org.ocmc.ioc.liturgical.schemas.models.generation;

import java.time.Instant;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.exceptions.BadIdException;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDb;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;

import com.google.gson.annotations.Expose;

/**
 * Provides a model for recording information about the generation of something, e.g. PDF file
 * 
 * The database should have a constraint on n:GenerationStatus property id.
 * 
 * @author mac002
 *
 */
public class GenerationStatus extends LTKLite {
	private static String schema = GenerationStatus.class.getSimpleName();
	private static double version = 1.1;

	public enum TYPE {PDF};
	
	@Expose public String start = "";
	@Expose public String finish = "";
	@Expose public TYPE type = TYPE.PDF;
	
	public GenerationStatus(
			String key
			, GenerationStatus.TYPE type
			) throws BadIdException {
		super(
				Constants.LIBRARY_GENERATOR
				, type.name()
				, key
				, schema
				, version
				);
		this.type = type;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}


}
