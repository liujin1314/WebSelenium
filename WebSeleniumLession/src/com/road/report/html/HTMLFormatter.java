package com.road.report.html;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;



public class HTMLFormatter extends Formatter{
	
	//��¼ִ�е�������
	private int i = 0;
	//��¼����ִ�еĿ�ʼʱ��
	private long startTime;
	//��¼����ִ�н�����ʱ��
	private long endTime; 
	
	//����HTML��־��ͷ����Ϣ
	private final String HTML_HEADER = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gbk\">"
			+ "<META HTTP-EQUIV=\"CACHE-CONTROL\" CONTENT=\"NO-CACHE\">"
			+ "<META HTTP-EQUIV=\"PRAGMA\" CONTENT=\"NO-CACHE\">"
			+ "<link rel=\"stylesheet\" href=\"demo_report_style.css\"/>"
			+ "<html><head><title>���Ա���</title></head>"
			+ "<body>"
			+ "<div class=\"page_title\"><center>"
			+ "<h1>���Ա���</h1></center></div>"
			+ "<div class=\"statistics\"><table id=\"statistics_table\" class=\"sortable\" align=\"center\" border=\"0\"  style=\"width:100%;\"><tr>"
			+ "<th><b>���</b></th>"
			+ "<th><b>��������</b></th>"
			+ "<th><b>�ڴ����</b></th>"
			+ "<th><b>ʵ�ʽ��</b></th>"
			+ "<th><b>ִ��ʱ��</b></th>" + "<th><b>״̬</b></th>" + "</tr>";

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
		//��ȡִ�е���������
		int p_total = RecordStore.p_pass + RecordStore.p_fail;
		if (p_total > 0){
			//��������ִ�е����
			if (RecordStore.p_fail > 0){
				//������ִ�д����������ʱ��
				HTML_Tail = "</table></PRE>" + "<br>&nbsp;��ʼʱ��   ��"+ HtmlUtil.getCalcDate(this.startTime) 
		        + "<br>&nbsp;����ʱ��      ��"+ HtmlUtil.getCalcDate(this.endTime) 
		        + "<br>&nbsp;����ʱ��      ��"+ HtmlUtil.getDeltaTime(this.endTime, this.startTime)
				+ "<br>&nbsp;ִ������      ��" + p_total 
				+"<br>&nbsp;�����ɹ�         ��"+ RecordStore.p_pass
				+ "<br>&nbsp;<font color=Red>����ʧ��      ��"+ RecordStore.p_fail + "</font>" 
				+ "<br>&nbsp;�ɹ���(%) ��"+ HtmlUtil.getPercnet(RecordStore.p_pass, p_total)
				+ "<br>&nbsp;<font color=Red>ʧ����(%) ��"+ HtmlUtil.getPercnet(RecordStore.p_fail, p_total) + "</font>" 
				+ "<br><br>"
				+ "</BODY></HTML>";
			}else{
				//��û��ִ�д����������ʱ��
				HTML_Tail = "</table></PRE>" + "<br>&nbsp;��ʼʱ��   ��"
						+ HtmlUtil.getCalcDate(this.startTime) + "<br>&nbsp;����ʱ��   ��"
						+ HtmlUtil.getCalcDate(this.endTime) + "<br>&nbsp;����ʱ��   ��"
						+ HtmlUtil.getDeltaTime(this.endTime, this.startTime)
						+ "<br>&nbsp;ִ������      ��" + p_total 
						+ "<br>&nbsp;�����ɹ�      ��"+ RecordStore.p_pass 
						+ "<br>&nbsp;����ʧ��      ��" + RecordStore.p_fail
						+ "<br>&nbsp;�ɹ���(%) ��" + HtmlUtil.getPercnet(RecordStore.p_pass, p_total)
						+ "<br>&nbsp;ʧ����(%) ��" + HtmlUtil.getPercnet(RecordStore.p_fail, p_total)
						+ "<br><br>"
						+ "</BODY></HTML>";
			}
		}else{
			//��û��ִ�������������
			HTML_Tail = "</table></PRE>" + "<br>&nbsp;����ִ���쳣��" + "<br><br>"
					+ "</BODY></HTML>";
		}
		return HTML_Tail;
	}

}
