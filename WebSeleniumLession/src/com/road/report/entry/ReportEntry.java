package com.road.report.entry;

import com.road.report.base.IReport;
import com.road.report.html.HtmlReport;

public class ReportEntry {
	//�˴�ͳһ�������ڣ����еı��涼��Ҫʵ��IReport�ӿڣ�Ȼ����ڴ�ͳһʵ�ֱ����е���ع��ܣ����ǹ��ܵľ���ʵ������ʵ��IReport�ӿڵ���ȥʵ��
	static IReport ir;
	
	public void createReport(String reportPath){
		if(reportPath.endsWith(".html")){
			ir = new HtmlReport();
			ir.createReport(reportPath);
		}else{
			ir = null;
			System.out.println("��ʱ��֧�ִ������͸�ʽ�Ĳ��Ա���");
		}
	}
	
	public void closeReport(){
		ir.closeReport();
	}
	
	public static void write(String caseName, String expected, String actual){
		ir.write(caseName, expected, actual);
	}
	
	//����ķ����˴�û��ȥ�����ˡ���
}
