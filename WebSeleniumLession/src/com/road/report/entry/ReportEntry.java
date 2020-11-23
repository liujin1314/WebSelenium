package com.road.report.entry;

import com.road.report.base.IReport;
import com.road.report.html.HtmlReport;

public class ReportEntry {
	//此处统一报告的入口；所有的报告都需要实现IReport接口；然后入口处统一实现报告中的相关功能，但是功能的具体实现是有实现IReport接口的类去实现
	static IReport ir;
	
	public void createReport(String reportPath){
		if(reportPath.endsWith(".html")){
			ir = new HtmlReport();
			ir.createReport(reportPath);
		}else{
			ir = null;
			System.out.println("暂时不支持此种类型格式的测试报告");
		}
	}
	
	public void closeReport(){
		ir.closeReport();
	}
	
	public static void write(String caseName, String expected, String actual){
		ir.write(caseName, expected, actual);
	}
	
	//其余的方法此处没有去完善了……
}
