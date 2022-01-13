package com.test.api;

import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;

public class ZoneJsonTest {

	public static void main(String[] args) throws SerializeException, ParseException {
		JsonSerializer jsonSerial= JsonSerializer.DEFAULT_READABLE;
		
		ZoneLayout zl= new ZoneLayout("ahjaba","TesZone1","TestZone1","ghjkjf","jjbbkj","jhsajkba","bjkak");
			
	   String json=	jsonSerial.serialize(zl);
		
		System.out.println(json);
		
		

		JsonParser jsonParser = JsonParser.DEFAULT;
		ZoneLayout zl2= jsonParser.parse(json, ZoneLayout.class);
		
		System.out.println(zl2.getFloorId());
		
	}

	
	

	

	
	
}
