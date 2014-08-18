package com.cloudwick.java.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.VisibilityChecker;

public class JacksonParserExample {

	public static void main(String[] args) throws JsonGenerationException,
			JsonMappingException, IOException {

		List<String> msg = new ArrayList<>();
		msg.add("msg1");
		msg.add("msg2");

		UserJSON obj = new UserJSON(24, "fremont", msg);

		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance()
				.withFieldVisibility(Visibility.ANY));

		// convert object to json and write to file

		mapper.writeValue(new File("testj.json"), obj);

		// convert and writer to console

		System.out.println(mapper.defaultPrettyPrintingWriter()
				.writeValueAsString(obj));

		System.out.println(mapper.writeValueAsString(obj));

	}

}
