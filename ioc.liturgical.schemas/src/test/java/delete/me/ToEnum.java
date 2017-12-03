package delete.me;

public class ToEnum {

	public static void main(String[] args) {
		//     SUNDAY("D1", "D1 - Sunday (Κυριακή)")
	    // ,MONDAY("D2", "D2 - Monday (Δευτέρα)")

		String s = 
				"Jan | Feb | Mar | Apr | May | Jun | Jul | Aug | Sep | Oct | Nov | Dec";
		String [] parts = s.split(" \\| ");
		StringBuffer sb = new StringBuffer();
		for (String part : parts) {
			sb.append("\t\t");
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(part.toUpperCase());
			sb.append("(\"");
			sb.append(part);
			sb.append("\", ");
			sb.append("\"");
			sb.append(part);
			sb.append("\")\n");
		}
		System.out.println(sb.toString());
	}

}
