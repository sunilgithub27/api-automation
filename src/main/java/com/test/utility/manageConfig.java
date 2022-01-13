package com.test.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class manageConfig {

	public static Properties prop = new Properties();
	public static File file;
	public static FileInputStream fis;
	public static String testEnv;
	public static String tenantUrl;
	public static String facilityUrl;
	
	static  {
		file = new File("./src/test/resources/" + "env.properties");
		
		try {
		   fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		testEnv = prop.getProperty("testEnvironment");
		
		tenantUrl= prop.getProperty("tenantService");
		
		facilityUrl= prop.getProperty("facilityService");
		
	}
	
	
	public static String GetTenantUrl() throws IOException{
	
		tenantUrl= tenantUrl.replace("env", testEnv);
		
		return tenantUrl;
	}
	
	public static String GetfacilityUrl() throws IOException{
		
		facilityUrl= facilityUrl.replace("env", testEnv);
		
		return tenantUrl;
	}
}
