package org.ocmc.ioc.liturgical.schemas.models.ws.response.column.editor;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

/**
 * Holds the value for a row in the libraryKeys array
 * @author mac002
 *
 */
public class LibraryTopicKey extends AbstractModel {
	@Expose String _id = "";
	@Expose List<Integer> ids = new ArrayList<Integer>(); // indexes into the templateKeys array
	
	public LibraryTopicKey() {
		super();
	}
	
	public LibraryTopicKey(boolean printPretty) {
		super();
		super.setPrettyPrint(printPretty);
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	public void addIdIndex(int i) {
		ids.add(i);
	}

	}
