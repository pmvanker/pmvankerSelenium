package com.w2a.utility;

import com.w2a.base.TestBase;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;


public class ScreenShot extends TestBase{
	
	public static void CaptureScreenShot(String name) {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
		try {
			System.out.println("Capturing Screenshot");
			FileUtils.copyFile(scrFile, new File("C:\\Users\\pmvan\\eclipse-workspace\\DataDrivenFramework\\test-output\\screenshot\\" + name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
