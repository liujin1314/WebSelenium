package com.road.report.html;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import com.road.report.base.IReport;



public class HtmlReport implements IReport{
	//��дHTMLReport��ʱ������ֻ��Ҫ��д���ַ���������ȫ����дȫ���Ľӿڷ���
	
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
		//��Ϊ�������HTML��ʽ����־�ļ���û�б�Ҫ����׷�ӵķ�ʽȥд��־�ļ�
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
		//���RecordStore�м�¼����ʷ����
		fileHandler.close();
		RecordStore.actual = "";
		RecordStore.expected = "";
		RecordStore.actual = "";
		RecordStore.p_pass = 0;
		RecordStore.p_fail = 0;
		
	}

}
