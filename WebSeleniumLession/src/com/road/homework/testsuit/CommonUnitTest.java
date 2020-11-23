package com.road.homework.testsuit;

import java.io.File;

import com.road.report.entry.ReportEntry;

import junit.textui.TestRunner;

public class CommonUnitTest {

	public static void main(String[] args) {
		ReportEntry re = new ReportEntry();
		re.createReport(System.getProperty("user.dir") + File.separator + "report" + File.separator + "liujintest.html");
		TestRunner.run(DoclevelTestSuit.doclevelSuit());
		re.closeReport();
	}
	
}
