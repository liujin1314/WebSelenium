package com.road.report.html;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import com.road.report.base.IReport;



public class HtmlReport implements IReport{
	//在写HTMLReport的时候，我们只需要重写部分方法，无需全部重写全部的接口方法
	
	private static Logger logger = Logger.getLogger(HtmlReport.class.getName());
	private static FileHandler fileHandler;

	@Override
	public void createReport(String p_reportPath) {
		// TODO Auto-generated method stub
		try {
			fileHandler = new FileHandler(p_reportPath);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileHandler.setFormatter(new HTMLFormatter());
		logger.addHandler(fileHandler);
	}

	@Override
	public void createReport(String p_reportPath, boolean isAppend) {
		// TODO Auto-generated method stub
		//因为输出的是HTML格式的日志文件，没有必要采用追加的方式去写日志文件
	}

	@Override
	public void write(String reportContent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public  void write(String caseName, String expected, String actual) {
		// TODO Auto-generated method stub
		RecordStore.expected = expected;
		RecordStore.actual = actual;
		
		if(expected.equals(actual)){
			RecordStore.result = "PASS";
		}else{
			RecordStore.result = "FAIL";
		}
		logger.info(caseName);
	}

	@Override
	public String read(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String read(String p_info1, String p_info2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeReport() {
		// TODO Auto-generated method stub
		//清除RecordStore中记录的历史数据
		fileHandler.close();
		RecordStore.actual = "";
		RecordStore.expected = "";
		RecordStore.actual = "";
		RecordStore.p_pass = 0;
		RecordStore.p_fail = 0;
		
	}

}
