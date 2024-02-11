package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadInvalidData {
Properties pr;
	
	public ReadInvalidData(){
	try
	{
		String filePath=".//TestData//InvalidData.properties";
		FileInputStream fis=new FileInputStream(filePath);
		pr=new Properties();
		pr.load(fis);
	}
	catch(Exception e)
	{
		System.out.println("File Not Found::"+e.getMessage());
	}
	}
	public String getApplicationUrl()
	{
		return pr.getProperty("baseurl");
	}
	
	public String getUSername()
	{
		return pr.getProperty("username");
	}
	
	public String getPassword()
	{
		return pr.getProperty("password");
	}
}
