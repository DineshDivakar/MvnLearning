package com.Automation.Learning.TestCases;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Automation.Base.TestBase;
import com.Automation.reusablecomponents.FileCopy;
@Listeners(com.Automation.ScriptHelper.Listener.class)
public class FileCopyTest extends TestBase {
	Logger logs = (Logger) LogManager.getLogger(FileCopyTest.class);
		
	@Test
	public void DuplicatePDF() {
		FileCopy fc = new FileCopy();
		fc.CopyFile();
		logs.info("test");
		logs.error("Error");
		logs.fatal("Fatal");
		logs.warn("Warning Msg");
		logs.debug("Debug");
		
	}
	
}
