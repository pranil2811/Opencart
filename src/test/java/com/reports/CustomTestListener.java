package com.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomTestListener implements ITestListener {

	@Override
	public void onFinish(ITestContext context) {
		String desktopPath = System.getProperty("user.home") + "/Desktop";
		String customReportsPath = desktopPath + "/custom-reports";

		Path sourcePath = Paths.get("test-output");
		Path targetPath = Paths.get(customReportsPath);

		try {
			Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Reports moved successfully to " + customReportsPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	// ... (other methods remain unchanged)
}
