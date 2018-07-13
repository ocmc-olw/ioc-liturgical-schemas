package org.ocmc.ioc.liturgical.schemas.models.ws.db;

import org.ocmc.ioc.liturgical.schemas.constants.DATA_SOURCES;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

@Attributes(title = "Universal Dependency Treekbank Loader Utility", description = "Data required to request the loading of a Universal Dependency Treebank from Github")
public class UtilityUdLoader extends Utility {
	
	@Attributes(required = true, readonly=false, description = "The data source to load from.")
	@Expose public DATA_SOURCES dataSource = DATA_SOURCES.UNKNOWN;

	@Attributes(required = true, readonly=false, description = "Pull from Github? If false, will use existing local repository if found. If not, will go ahead and pull.")
	@Expose public boolean pullFirst =  true;

	@Attributes(required = true, readonly=false, description = "True - will delete existing database records for this UD treebank. False - will find last written record and resume. ")
	@Expose public boolean deleteFirst =  true;

	@Attributes(required = true, readonly=false, description = "True - DB Managers not initialized, no DB reads / writes occur")
	@Expose public boolean simulate =  true;
	
	public UtilityUdLoader() {
		super();
	}

	public boolean isPullFirst() {
		return pullFirst;
	}


	public void setPullFirst(boolean pullFirst) {
		this.pullFirst = pullFirst;
	}


	public boolean isDeleteFirst() {
		return deleteFirst;
	}


	public void setDeleteFirst(boolean deleteFirst) {
		this.deleteFirst = deleteFirst;
	}


	public boolean isSimulate() {
		return simulate;
	}


	public void setSimulate(boolean simulate) {
		this.simulate = simulate;
	}

	public DATA_SOURCES getDataSource() {
		return dataSource;
	}

	public void setDataSource(DATA_SOURCES dataSource) {
		this.dataSource = dataSource;
	}

}
