package com.road.report.base;

public interface IReport {
	//创建日志文件
	public void createReport(String p_reportPath);
	
	public void createReport(String p_reportPath , boolean isAppend);
	
	//关闭日志文件
	public void closeReport();
	
	//写日志文件
	public void write(String reportContent);
	public void  write(String caseName , String expected , String actual);
	
	//读取日志文件
	public String read(String key);
	public String read(String p_info1,String p_info2);
	
	
}
