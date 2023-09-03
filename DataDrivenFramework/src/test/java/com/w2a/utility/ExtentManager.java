package com.w2a.utility;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;
	public static ExtentReports getInstance()
	{
		if(extent == null)
		{
			extent = new ExtentReports("C:\\Users\\pmvan\\eclipse-workspace\\DataDrivenFramework\\test-output\\extentreport\\extent.html");
			extent.loadConfig(new File("C:\\Users\\pmvan\\eclipse-workspace\\DataDrivenFramework\\src\\test\\resources\\properties\\extent-config.xml"));
		}
		return extent;
	}

}
