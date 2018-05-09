package delete.me;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jgit.util.StringUtils;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Concept;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.ConceptCreateForm;
import org.ocmc.ioc.liturgical.utils.FileUtils;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

/**
 * This class uses the required vs optional fields listed for each type of bibliography
 * entry listed in the biblatex.pdf manual.
 * 
 * It generates a class for each type of entry.
 * 
 * @author mac002
 *
 */
public class BibTexClassGenerator {
	private String name = "";
	private String path = "";
	private String required = "";
	private String optional = "";
	private List<String> varNames = new ArrayList<String>();
	
	BibTexClassGenerator (String path, String name, String required, String optional) {
		this.path = path;
		this.name = name;
		this.required = required;
		this.optional = optional;
		this.process();
	}
	
	private String generateSchemaClass(String var) {
		StringBuffer sb = new StringBuffer();
			sb.append("\n, ");
			sb.append(var);
			sb.append("(\n");
			sb.append("new ");
			sb.append(var);
			sb.append("(\" \",\" \")\n");
			sb.append(", new ");
			sb.append(var);
			sb.append("(\" \",\" \")\n");
			sb.append(")\n");
		return sb.toString();
	}
	
	private String declareVariable(String var, boolean required) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t@Attributes(required = ");
		sb.append(required);
		sb.append(", description = \"");
		sb.append(var);
		sb.append("\")\n");
		sb.append("\t@Expose public String ");
		sb.append(var);
		sb.append(" = \"\";\n\n");
		return sb.toString();
	}
	
	private String declareVariables(String vars, boolean required) {
		StringBuffer sb = new StringBuffer();
		try {
			String [] variables = vars.split(",");
			for (String v : variables) {
				String var = v.trim();
				if (var.contains("/")) {
					String [] parts = var.split("/"); // this is year/date, we will use date
					if (parts.length == 2) {
						var = parts[1];
					}
				}
				sb.append(this.declareVariable(var, required));
				this.varNames.add(var);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	private String getBibTexMethod() {
		StringBuffer sb = new StringBuffer();sb.append("public String toBibtex() {\n");
		String indent = "\t\t";
		  sb.append(indent);
		  sb.append("StringBuffer sb = new StringBuffer();\n");
		  sb.append(indent);
		  sb.append("sb.append(\"@\");\n");
		  sb.append(indent);
		  sb.append("sb.append(this.entryType.keyname);\n");
		  sb.append(indent);
		  sb.append("sb.append(\"{\");\n");
		  sb.append(indent);
		  sb.append("sb.append(this.key);\n");
		  sb.append(indent);
		  sb.append("sb.append(\", \\n\");\n");
		  Collections.sort(this.varNames);
		  for (String var : this.varNames) {
			  sb.append(indent);
			  sb.append("sb.append(keyValue(\"");
			  sb.append(var);
			  sb.append("\", this.");
			  sb.append(var);
			  sb.append("));\n");
		  }
		  sb.append(indent);
		  sb.append("sb.append(\"}\\n\");\n");
		  sb.append(indent);
		  sb.append("return sb.toString();\n");
		  indent = "\t";
		  sb.append(indent);
		  sb.append("}\n");
		return sb.toString();
	}
	
	public void process() {
	   try {
			String capName = "BibEntry" + StringUtils.capitalize(this.name);
			String out = this.path + capName + ".java";
			StringBuffer sb = new StringBuffer();
			String indent = "";
			sb.append("package org.ocmc.ioc.liturgical.schemas.models.bibliography;\n\n");
			sb.append("import org.ocmc.ioc.liturgical.schemas.constants.BIBTEX_ENTRY_TYPES;\n\n");
			sb.append("import org.ocmc.ioc.liturgical.schemas.models.supers.BibliographyEntry;\n");
			sb.append("import org.slf4j.Logger;\n");
			sb.append("import org.slf4j.LoggerFactory;\n");
			sb.append("import com.github.reinert.jjschema.Attributes;\n");
			sb.append("import com.google.gson.annotations.Expose;\n");
			sb.append("\n\npublic class ");
			sb.append(capName);
			sb.append(" extends BibliographyEntry {\n\n");
			indent = "\t";
			sb.append(indent);
		    sb.append("private static final Logger logger = LoggerFactory.getLogger(");
		    sb.append(capName);
		    sb.append(".class);\n");
		    sb.append(indent);
		    sb.append("private static String schema = ");
		    sb.append(capName);
		    sb.append(".class.getSimpleName();\n");
			sb.append(indent);
		    sb.append("private static double schemaVersion = 1.1;\n\n");
		    
		    // constructor
		    sb.append(indent);
		    sb.append("public "); 
		    sb.append(capName); 
		    sb.append("(\n");
		    indent = "\t\t\t";
		    sb.append(indent);
			sb.append("String library\n");
		    sb.append(indent);
			sb.append(", String key\n");
			sb.append(") {\n");
			indent = "\t\t";
		    sb.append(indent);
			sb.append("super(library, key, schema, schemaVersion, BIBTEX_ENTRY_TYPES.");
			sb.append(this.name.toUpperCase());
			sb.append(");\n");
		    sb.append(indent);
			sb.append("this.library = library;\n");
		    sb.append(indent);
			sb.append("this.key = key;\n");
			indent = "\t";
		    sb.append(indent);
		    sb.append("}\n");
		    
		    // declare all the variables
		    sb.append(this.declareVariables(this.required, true));
		    sb.append(this.declareVariables(this.optional, false));
		    
		    // generate the toBibTex method;
		    sb.append(this.getBibTexMethod());
		    
		    // close out the file
		   indent = "";
		   sb.append("}\n");
		   
		  //  FileUtils.writeFile(out, sb.toString());
		   System.out.println(this.generateSchemaClass(capName));
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	}
	
	public static void main(String[] args) {
		String path = "/Users/mac002/Git/ocmc-translation-projects/ioc-liturgical-schemas/ioc.liturgical.schemas/src/main/java/org/ocmc/ioc/liturgical/schemas/models/bibliography/";
		// article
		String req = "author, title, journaltitle, year/date";
		String opt = "translator, annotator, commentator, subtitle, titleaddon, editor, editora, editorb, editorc, journalsubtitle,issuetitle, issuesubtitle, language, origlanguage, series,volume, number, eid, issue, month, pages, version, note, issn,addendum, pubstate, doi, eprint, eprintclass, eprinttype, url, urldate";
		BibTexClassGenerator g = new BibTexClassGenerator(path, "article", req, opt);

		// book
		req = "author, title, year/date";
		opt = "editor, editora, editorb, editorc, translator,annotator, commentator, introduction, foreword, afterword,subtitle, titleaddon, maintitle, mainsubtitle, maintitleaddon,language, origlanguage, volume, part, edition, volumes, series,number, note, publisher, location, isbn, chapter, pages,pagetotal, addendum, pubstate, doi, eprint, eprintclass,eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "book", req, opt);

		// mvbook
		req = "author, title, year/date";
		opt = "editor, editora, editorb, editorc, translator,annotator, commentator, introduction, foreword, afterword,subtitle, titleaddon, language, origlanguage, edition, volumes,series, number, note, publisher, location, isbn, pagetotal,addendum, pubstate, doi, eprint, eprintclass, eprinttype, url,urldate";
		g = new BibTexClassGenerator(path, "mvbook", req, opt);

		// inbook
		req = "author, title, booktitle, year/date";
		opt = "bookauthor, editor, editora, editorb, editorc,translator, annotator, commentator, introduction, foreword,afterword, subtitle, titleaddon, maintitle, mainsubtitle,maintitleaddon, booksubtitle, booktitleaddon, language,origlanguage, volume, part, edition, volumes, series, number,note, publisher, location, isbn, chapter, pages, addendum,pubstate, doi, eprint, eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "inbook", req, opt);

		// book in book
		req = "author, title, booktitle, year/date";
		opt = "bookauthor, editor, editora, editorb, editorc,translator, annotator, commentator, introduction, foreword,afterword, subtitle, titleaddon, maintitle, mainsubtitle,maintitleaddon, booksubtitle, booktitleaddon, language,origlanguage, volume, part, edition, volumes, series, number,note, publisher, location, isbn, chapter, pages, addendum,pubstate, doi, eprint, eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "bookinbook", req, opt);

		// supp book
		req = "author, title, booktitle, year/date";
		opt = "bookauthor, editor, editora, editorb, editorc,translator, annotator, commentator, introduction, foreword,afterword, subtitle, titleaddon, maintitle, mainsubtitle,maintitleaddon, booksubtitle, booktitleaddon, language,origlanguage, volume, part, edition, volumes, series, number,note, publisher, location, isbn, chapter, pages, addendum,pubstate, doi, eprint, eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "suppbook", req, opt);

		// booklet
		req = "author/editor, title, year/date";
		opt = "subtitle, titleaddon, language, howpublished,type, note, location, chapter, pages, pagetotal, addendum,pubstate, doi, eprint, eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "booklet", req, opt);

		// collection
		req = "editor, title, year/date";
		opt = "editora, editorb, editorc, translator, annotator,commentator, introduction, foreword, afterword, subtitle,titleaddon, maintitle, mainsubtitle, maintitleaddon, language,origlanguage, volume, part, edition, volumes, series, number,note, publisher, location, isbn, chapter, pages, pagetotal,addendum, pubstate, doi, eprint, eprintclass, eprinttype, url,urldate";
		g = new BibTexClassGenerator(path, "collection", req, opt);

		// mvcollection
		req = "editor, title, year/date";
		opt = "editora, editorb, editorc, translator, annotator,commentator, introduction, foreword, afterword, subtitle,titleaddon, language, origlanguage, edition, volumes, series,number, note, publisher, location, isbn, pagetotal, addendum,pubstate, doi, eprint, eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "mvcollection", req, opt);

		// incollection
		req = "author, title, booktitle, year/date";
		opt = "editor, editora, editorb, editorc, translator,annotator, commentator, introduction, foreword, afterword,subtitle, titleaddon, maintitle, mainsubtitle, maintitleaddon,booksubtitle, booktitleaddon, language, origlanguage, volume,part, edition, volumes, series, number, note, publisher,location, isbn, chapter, pages, addendum, pubstate, doi, eprint,eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "incollection", req, opt);

		// suppcollection
		req = "author, title, booktitle, year/date";
		opt = "editor, editora, editorb, editorc, translator,annotator, commentator, introduction, foreword, afterword,subtitle, titleaddon, maintitle, mainsubtitle, maintitleaddon,booksubtitle, booktitleaddon, language, origlanguage, volume,part, edition, volumes, series, number, note, publisher,location, isbn, chapter, pages, addendum, pubstate, doi, eprint,eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "suppcollection", req, opt);

		// manual
		req = "author/editor, title, year/date";
		opt = "subtitle, titleaddon, language, edition, type,series, number, version, note, organization, publisher,location, isbn, chapter, pages, pagetotal, addendum, pubstate,doi, eprint, eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "manual", req, opt);

		// misc
		req = "author/editor, title";
		opt = "subtitle, titleaddon, language, howpublished,type, version, note, organization, location, date, month, year,addendum, pubstate, doi, eprint, eprintclass, eprinttype, url,urldate";
		g = new BibTexClassGenerator(path, "misc", req, opt);

		// online
		req = "author/editor, title, url";
		opt = "subtitle, titleaddon, language, version, note,organization, date, month, year, addendum, pubstate, urldate";
		g = new BibTexClassGenerator(path, "online", req, opt);

		// patent
		req = "author, title, number";
		opt = "holder, subtitle, titleaddon, type, version,location, note, date, month, year, addendum, pubstate, doi, eprint,eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "patent", req, opt);

		// periodical
		req = "editor, title";
		opt = "editora, editorb, editorc, subtitle, issuetitle,issuesubtitle, language, series, volume, number, issue, date,month, year, note, issn, addendum, pubstate, doi, eprint,eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "periodical", req, opt);

		// suppperiodical
		req = "author, title, journaltitle, year/date";
		opt = "translator, annotator, commentator, subtitle, titleaddon, editor, editora, editorb, editorc, journalsubtitle,issuetitle, issuesubtitle, language, origlanguage, series,volume, number, eid, issue, month, pages, version, note, issn,addendum, pubstate, doi, eprint, eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "suppperiodical", req, opt);

		// proceedings
		req = "title, year/date";
		opt = "editor, subtitle, titleaddon, maintitle,mainsubtitle, maintitleaddon, eventtitle, eventtitleaddon,eventdate, venue, language, volume, part, volumes, series,number, note, organization, publisher, location, month, isbn,chapter, pages, pagetotal, addendum, pubstate, doi, eprint,eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "proceedings", req, opt);

		// mvproceedings
		req = "title, year/date";
		opt = "editor, subtitle, titleaddon, eventtitle,eventtitleaddon, eventdate, venue, language, volumes, series,number, note, organization, publisher, location, month, isbn,pagetotal, addendum, pubstate, doi, eprint, eprintclass,eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "mvproceedings", req, opt);

		// inproceedings
		req = "author, title, booktitle, year/date";
		opt = "editor, subtitle, titleaddon, maintitle,mainsubtitle, maintitleaddon, booksubtitle, booktitleaddon,eventtitle, eventtitleaddon, eventdate, venue, language,volume, part, volumes, series, number, note, organization,publisher, location, month, isbn, chapter, pages, addendum,pubstate, doi, eprint, eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "inproceedings", req, opt);

		// reference
		req = "editor, title, year/date";
		opt = "editora, editorb, editorc, translator, annotator,commentator, introduction, foreword, afterword, subtitle,titleaddon, maintitle, mainsubtitle, maintitleaddon, language,origlanguage, volume, part, edition, volumes, series, number,note, publisher, location, isbn, chapter, pages, pagetotal,addendum, pubstate, doi, eprint, eprintclass, eprinttype, url,urldate";
		g = new BibTexClassGenerator(path, "reference", req, opt);

		// mvreference
		req = "editor, title, year/date";
		opt = "editora, editorb, editorc, translator, annotator,commentator, introduction, foreword, afterword, subtitle,titleaddon, language, origlanguage, edition, volumes, series,number, note, publisher, location, isbn, pagetotal, addendum,pubstate, doi, eprint, eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "mvreference", req, opt);

		// inreference
		req = "author, title, booktitle, year/date";
		opt = "editor, editora, editorb, editorc, translator,annotator, commentator, introduction, foreword, afterword,subtitle, titleaddon, maintitle, mainsubtitle, maintitleaddon,booksubtitle, booktitleaddon, language, origlanguage, volume,part, edition, volumes, series, number, note, publisher,location, isbn, chapter, pages, addendum, pubstate, doi, eprint,eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "inreference", req, opt);

		// report
		req = "author, title, type, institution, year/date";
		opt = "subtitle, titleaddon, language, number, version,note, location, month, isrn, chapter, pages, pagetotal, addendum,pubstate, doi, eprint, eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "report", req, opt);

		// thesis
		req = "author, title, type, institution, year/date";
		opt = "subtitle, titleaddon, language, note, location,month, isbn, chapter, pages, pagetotal, addendum, pubstate, doi,eprint, eprintclass, eprinttype, url, urldate";
		g = new BibTexClassGenerator(path, "thesis", req, opt);

		// unpublished
		req = "author, title";
		opt = "subtitle, titleaddon, type, eventtitle,eventtitleaddon, eventdate, venue, language, howpublished,note, location, isbn, date, month, year, addendum, pubstate, url,urldate";
		g = new BibTexClassGenerator(path, "unpublished", req, opt);
}

}
