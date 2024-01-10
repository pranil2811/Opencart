package com.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import java.lang.reflect.Field;
import java.nio.file.Paths;

public class CustomTestListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		// Set the custom output directory to the system desktop
		String desktopPath = System.getProperty("user.home") + "/Desktop";
		String customReportsPath = desktopPath + "/custom-reports";

		try {
			// Use reflection to set the absolute path
			Field field = context.getClass().getDeclaredField("m_outputDirectory");
			field.setAccessible(true);
			field.set(context, Paths.get(customReportsPath).toAbsolutePath().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ... (other methods remain unchanged)
}
