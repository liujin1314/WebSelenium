package com.road.report.base;

public interface IReport {
	//������־�ļ�
	public void createReport(String p_reportPath);
	
	public void createReport(String p_reportPath , boolean isAppend);
	
	//�ر���־�ļ�
	public void closeReport();
	
	//д��־�ļ�
	public void write(String reportContent);
	public void  write(String caseName , String expected , String actual);
	
	//��ȡ��־�ļ�
	public String read(String key);
	public String read(String p_info1,String p_info2);
	
	
}
