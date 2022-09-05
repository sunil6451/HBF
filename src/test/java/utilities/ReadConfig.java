package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	
	/*
	 * Properties pro1;
	 * 
	 * 
	 * public void ReadConfig1() { File src = new
	 * File("./Configuration/config.properties");
	 * 
	 * try { FileInputStream fis = new FileInputStream(src); pro = new Properties();
	 * pro.load(fis); } catch (Exception e) { System.out.println("Exception is " +
	 * e.getMessage()); } }
	 */
	
	public Properties pro;
	public final String propertyFilePath = "configs//Config.properties";

	public ReadConfig() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			pro = new Properties();
			try {
				pro.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUseremail() {
		String username = pro.getProperty("useremail");
		return username;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getChromePath() {
		String chrome = pro.getProperty("chromepath");
		return chrome;
	}

	public String getIEPath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

}
