package org.ocmc.ioc.liturgical.schemas.models.formatting;

import org.ocmc.ioc.liturgical.schemas.constants.META_TEXT_FORMATS;
import org.ocmc.ioc.liturgical.schemas.constants.META_TEXT_SIZES;
import org.ocmc.ioc.liturgical.schemas.constants.META_TEXT_USAGES;
import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

import com.google.gson.annotations.Expose;

/**
 * Abstract representation of a Liturgical LaTeX command.
 * @author mac002
 *
 */
public class MetaCommand extends AbstractModel {
	@Expose public String command = "";
    @Expose public META_TEXT_SIZES size = META_TEXT_SIZES.EM10;
	@Expose public MetaCommandArg [] args = new MetaCommandArg[4];
	
	public MetaCommand() {
		super();
		for (int i = 0; i < 4; i++) {
			this.args[i] = new MetaCommandArg();
		}
	}
	
		public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	
	public META_TEXT_SIZES getSize() {
		return size;
	}

	public void setSize(META_TEXT_SIZES size) {
		this.size = size;
	}


	public MetaCommandArg[] getArgs() {
		return args;
	}

	public void setArgs(MetaCommandArg[] args) {
		this.args = args;
	}
	
	public String toCss() {
		StringBuffer sb = new StringBuffer();
		sb.append("p.");
		sb.append(this.command);
		sb.append(" {\n");
		if (this.size != META_TEXT_SIZES.EM10) {
			sb.append("\tfont-size:");
			sb.append(this.size.cssValue);
			sb.append(";\n");
		}
		sb.append("}");
		return sb.toString();
	}
	
	public MetaCommandArg getArg(int i) {
		return this.args[i];
	}
	
	public void setArg(int i, MetaCommandArg arg) {
		this.args[i] = arg;
	}
	
	public String getSids() {
		StringBuffer sb = new StringBuffer();
		sb.append("\\ltSids");
		int j = 0;
		for (int i = 0; i < 4; i++) {
			sb.append("{");
			if (this.args[i].getUsage().equals(META_TEXT_USAGES.HIDDEN)) {
				sb.append(this.args[i].impliedTopic);
				sb.append("}{");
				sb.append(this.args[i].impliedKey);
			} else {
				sb.append("#");
				sb.append(++j);
				sb.append("}{");
				sb.append("#");
				sb.append(++j);
			}
			sb.append("}");
		}
		sb.append("%");
		return sb.toString();
	}

	public String getLatexCommand() {
		StringBuffer sb = new StringBuffer();
		sb.append("\\DeclareDocumentCommand\\lt");
		sb.append(this.command);
		sb.append("{");
		for (int i=0; i < 4 ; i++) {
			switch (this.args[i].getUsage()) {
			case HIDDEN:
				break;
			case MANDATORY:
				sb.append(" m m ");
				break;
			case OPTIONAL:
				sb.append(" g g ");
				break;
			default:
				break;
			}
		}
		sb.append("}{%\n");
		sb.append("    ");
		sb.append(this.getSidsFormat());
		sb.append("\n");
		sb.append("    ");
		sb.append(this.getSids());
		sb.append("\n}\n");
		return sb.toString();
	}
	public String getSidsFormat() {
		StringBuffer sb = new StringBuffer();
		sb.append("\\ltSidsFormat");
		for (int i = 0; i < 4; i++) {
			if (! this.args[i].getSize().equals(META_TEXT_SIZES.EM10)) {
				sb.append("\\");
				sb.append(this.args[i].getSize().latex);
			}
			sb.append("{");
			sb.append("\\");
			sb.append(this.args[i].getFormat().latex);
			sb.append("}");
		}
		sb.append("%");
		return sb.toString();
	}
	
	private String libraryToAges(String library) {
		StringBuffer sb = new StringBuffer();
		String [] parts = library.split("_");
		if (parts.length == 3) {
			sb.append(parts[0]);
			sb.append("_");
			sb.append(parts[1].toUpperCase());
			sb.append("_");
			sb.append(parts[2]);
		} else {
			sb.append(library);
		}
		return sb.toString();
	}
	
	public String toHtmlPara(String library, String topic, String key, String value) {
		StringBuffer sb = new StringBuffer();
		sb.append("<p> class=\"");
		sb.append(this.command);
		sb.append("\">\n");
		for (int i=0; i < 4; i++) {
			sb.append("<span class=\"kvp");
			if (this.args[i].getFormat() != META_TEXT_FORMATS.TEXT_BLACK) {
				sb.append(", ");
				sb.append(this.args[i].getFormat().latex);
			}
			if (this.args[i].getSize() != META_TEXT_SIZES.EM10) {
				sb.append(", ");
				sb.append(this.args[i].getSize().cssClassName);
			}
			sb.append("\" data-key=\"");
			sb.append(topic);
			sb.append("_");
			sb.append(this.libraryToAges(library));
			sb.append("|");
			sb.append(key);
			sb.append("\">");
			sb.append(value);
			sb.append("</span>\n");
		}
		sb.append("</p>\n");
		return sb.toString();
	}
	
	public static void main (String [] args) {
		MetaCommand mc = new MetaCommand();
		mc.setPrettyPrint(true);
		mc.setCommand("ActorDialog");
		
		MetaCommandArg arg = new MetaCommandArg();
		arg.setPrettyPrint(true);
		arg.setFormat(META_TEXT_FORMATS.TEXT_RED);
		arg.setUsage(META_TEXT_USAGES.MANDATORY);
		mc.setArg(0, arg);
		
		System.out.println(mc.toJsonString());

		mc = new MetaCommand();
		mc.setPrettyPrint(true);
		mc.setCommand("RubricDialogLowVoice");
		mc.setSize(META_TEXT_SIZES.EM12);
		
		arg = new MetaCommandArg();
		arg.setPrettyPrint(true);
		arg.setFormat(META_TEXT_FORMATS.TEXT_RED_BOLD_ITALICS);
		arg.setUsage(META_TEXT_USAGES.MANDATORY);
		mc.setArg(0, arg);
		
		arg = new MetaCommandArg();
		arg.setPrettyPrint(true);
		arg.setFormat(META_TEXT_FORMATS.TEXT_RED);
		arg.setUsage(META_TEXT_USAGES.HIDDEN);
		arg.setImpliedTopic("actors");
		arg.setImpliedKey("InALowVoice.colon");
		mc.setArg(1, arg);

		System.out.println(mc.toJsonString());
		
		MetaCommand renewed = MetaCommand.gson.fromJson(mc.toJsonString(), MetaCommand.class);

		System.out.println(renewed.getLatexCommand());
		
		System.out.println(renewed.toHtmlPara("gr_gr_cog", "actors", "priest", "Priest"));
		
		System.out.println(META_TEXT_FORMATS.toCss());

		System.out.println(META_TEXT_SIZES.toCss());

		System.out.println(renewed.toCss());
}
}
