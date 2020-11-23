package com.road.report.html;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;



public class HTMLFormatter extends Formatter{
	
	//记录执行的用例数
	private int i = 0;
	//记录用例执行的开始时间
	private long startTime;
	//记录用例执行结束的时间
	private long endTime; 
	
	//设置HTML日志的头部信息
	private final String HTML_HEADER = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gbk\">"
			+ "<META HTTP-EQUIV=\"CACHE-CONTROL\" CONTENT=\"NO-CACHE\">"
			+ "<META HTTP-EQUIV=\"PRAGMA\" CONTENT=\"NO-CACHE\">"
			+ "<link rel=\"stylesheet\" href=\"demo_report_style.css\"/>"
			+ "<html><head><title>测试报告</title></head>"
			+ "<body>"
			+ "<div class=\"page_title\"><center>"
			+ "<h1>测试报告</h1></center></div>"
			+ "<div class=\"statistics\"><table id=\"statistics_table\" class=\"sortable\" align=\"center\" border=\"0\"  style=\"width:100%;\"><tr>"
			+ "<th><b>序号</b></th>"
			+ "<th><b>用例描述</b></th>"
			+ "<th><b>期待结果</b></th>"
			+ "<th><b>实际结果</b></th>"
			+ "<th><b>执行时间</b></th>" + "<th><b>状态</b></th>" + "</tr>";

	private int recordStep() {
		i = i + 1;
		return i;
	}
	
	@Override
	public String getHead(Handler h) {
		// TODO Auto-generated method stub
		this.startTime = System.currentTimeMillis();
		return HTML_HEADER;
	}
	
	@Override
	public String format(LogRecord record) {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer(1000);
		// Bold any levels >= WARNING
		buf.append("<div class=\"statistics\">");
		buf.append("<tr>");
		buf.append("<td>");
		buf.append(recordStep());
		buf.append("</td>");
		buf.append("<td>");
		// buf.append(calcDate(rec.getMillis()));
		// buf.append(' ');
		buf.append(formatMessage(record));
		buf.append('\n');
		buf.append("</td>");
		buf.append("<td>");
		buf.append(RecordStore.expected);
		buf.append("</td>");
		buf.append("<td>");
		buf.append(RecordStore.actual);
		buf.append("</td>");
		buf.append("<td>");
		buf.append(HtmlUtil.getCalcDate(record.getMillis()));
		buf.append("</td>");
		buf.append("<td>");
		if (RecordStore.result.equalsIgnoreCase("PASS")) {
			RecordStore.p_pass = RecordStore.p_pass + 1;
			buf.append("<b>");
			buf.append("<font color=Green>");
			buf.append(RecordStore.result);
			buf.append("</font>");
			buf.append("</b>");
		} else if (RecordStore.result.equalsIgnoreCase("FAIL")) {
			RecordStore.p_fail = RecordStore.p_fail + 1;
			buf.append("<b>");
			buf.append("<font color=Red>");
			buf.append(RecordStore.result);
			buf.append("</font>");
			buf.append("</b>");
		}
		else{
			buf.append("<b>");
			// buf.append("<font color=Black>");
			buf.append("N/A");
			buf.append("</b>");
			
		}
		buf.append("</td>");
		buf.append("</tr>");
		buf.append("</div>\n");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return buf.toString();
	}

	@Override
	public String getTail(Handler h) {
		// TODO Auto-generated method stub
		this.endTime = System.currentTimeMillis();
		String HTML_Tail;
		//获取执行的用例总数
		int p_total = RecordStore.p_pass + RecordStore.p_fail;
		if (p_total > 0){
			//存在用例执行的情况
			if (RecordStore.p_fail > 0){
				//当存在执行错误的用例的时候
				HTML_Tail = "</table></PRE>" + "<br>&nbsp;开始时间   ："+ HtmlUtil.getCalcDate(this.startTime) 
		        + "<br>&nbsp;结束时间      ："+ HtmlUtil.getCalcDate(this.endTime) 
		        + "<br>&nbsp;运行时间      ："+ HtmlUtil.getDeltaTime(this.endTime, this.startTime)
				+ "<br>&nbsp;执行用例      ：" + p_total 
				+"<br>&nbsp;用例成功         ："+ RecordStore.p_pass
				+ "<br>&nbsp;<font color=Red>用例失败      ："+ RecordStore.p_fail + "</font>" 
				+ "<br>&nbsp;成功率(%) ："+ HtmlUtil.getPercnet(RecordStore.p_pass, p_total)
				+ "<br>&nbsp;<font color=Red>失败率(%) ："+ HtmlUtil.getPercnet(RecordStore.p_fail, p_total) + "</font>" 
				+ "<br><br>"
				+ "</BODY></HTML>";
			}else{
				//当没有执行错误的用例的时候
				HTML_Tail = "</table></PRE>" + "<br>&nbsp;开始时间   ："
						+ HtmlUtil.getCalcDate(this.startTime) + "<br>&nbsp;结束时间   ："
						+ HtmlUtil.getCalcDate(this.endTime) + "<br>&nbsp;运行时间   ："
						+ HtmlUtil.getDeltaTime(this.endTime, this.startTime)
						+ "<br>&nbsp;执行用例      ：" + p_total 
						+ "<br>&nbsp;用例成功      ："+ RecordStore.p_pass 
						+ "<br>&nbsp;用例失败      ：" + RecordStore.p_fail
						+ "<br>&nbsp;成功率(%) ：" + HtmlUtil.getPercnet(RecordStore.p_pass, p_total)
						+ "<br>&nbsp;失败率(%) ：" + HtmlUtil.getPercnet(RecordStore.p_fail, p_total)
						+ "<br><br>"
						+ "</BODY></HTML>";
			}
		}else{
			//在没有执行用例的情况下
			HTML_Tail = "</table></PRE>" + "<br>&nbsp;用例执行异常！" + "<br><br>"
					+ "</BODY></HTML>";
		}
		return HTML_Tail;
	}

}
