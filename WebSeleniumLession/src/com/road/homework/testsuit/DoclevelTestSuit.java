package com.road.homework.testsuit;

import com.road.homework.test.DoclevelUnitTestSettingPO1;
import com.road.homework.test.DoclevelUnitTestSettingPO2;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

public class DoclevelTestSuit {
	
	public static Test doclevelSuit(){
		TestSuite ts = new TestSuite("doclevelSuit");
		ts.addTest(new JUnit4TestAdapter(DoclevelUnitTestSettingPO2.class));
		return ts;
	}
}
