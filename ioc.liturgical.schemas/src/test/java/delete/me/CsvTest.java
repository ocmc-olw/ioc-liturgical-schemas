package delete.me;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.ocmc.ioc.liturgical.schemas.models.ModelHelpers;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.TextLiturgical;
import org.ocmc.ioc.liturgical.utils.FileUtils;

public class CsvTest {

	@Test
	public void test() {
		String out = "/Users/mac002/neo4j/import/";
//		int j = 3000000;
//		StringBuffer sb = new StringBuffer();
//		TextLiturgical txt = new TextLiturgical("en_us_dedes","actors","Priest");
//		txt.setCreatedBy("wsadmin");
//		txt.setCreatedWhen(Instant.now().toString());
//		txt.setModifiedBy("wsadmin");
//		txt.setModifiedWhen(txt.getCreatedWhen());
//		txt.setValue("PRIEST");
//		List<String> tags = new ArrayList<String>();
//		tags.add("t1");
//		tags.add("t2");
//		txt.setTags(tags);
//		
//		String schema = txt.toSchemaAsLabel();
//		String header = ModelHelpers.getCsvHeader(txt);
//		String cypher = ModelHelpers.getCypher(txt, schema, txt.fetchOntologyLabels());
//		String originalId = txt.getId();
//		String originalKey = txt.getKey();
//		
//		sb.append(header);
//		
//		for (int i = 0; i < j; i++) {
//			txt.setId(originalId + i);
//			txt.setKey(originalKey + i);
//			sb.append(ModelHelpers.toCsv(txt, txt.fetchOntologyLabels()));
//		}
//		FileUtils.writeFile(out + schema + ".cypher", cypher.toString());
//		FileUtils.writeFile(out + schema + ".csv", sb.toString());
		assertTrue(out.length() > 0);
	}

}
