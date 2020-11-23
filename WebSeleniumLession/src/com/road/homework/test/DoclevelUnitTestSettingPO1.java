package com.road.homework.test;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.rules.ErrorCollector;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.reflections.vfs.CommonsVfs2UrlType.Dir;
import org.yaml.snakeyaml.tokens.DirectiveToken;

import com.road.homework.bussiness.BussinessLib;
import com.road.homework.bussiness.LoginPageObjectStore;
import com.road.homework.util.AutoTestTools;
import com.road.report.base.IReport;
import com.road.report.entry.ReportEntry;
import com.road.robot.RobotUtil;

public class DoclevelUnitTestSettingPO1 {
	
	@Rule
	public ErrorCollector errorCollector = new ErrorCollector();

	private WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private BussinessLib bl = new BussinessLib();
	static ReportEntry re;
	
	private String actural;
	
	
	  @Before
	  public void setUp() throws Exception {
	    //driver = new FirefoxDriver();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(AutoTestTools.getConfigFromProperties("baseURL"));
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	  @Test
	  public void testUntitledTestCase() throws Exception {
		 
		 //�˴���½���÷�װ�õ�ҵ�񷽷���login()
		 bl.login(driver, AutoTestTools.getConfigFromProperties("user"), AutoTestTools.getConfigFromProperties("password"));
	    //���Ե�½�Ƿ�ɹ�
	    Thread.sleep(2000);
	   // assertTrue(isElementPresent(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[3]")));
	    
	    //ʹ���Լ���HTML��ʽд��־
	    re.write("case1:�ж��û��Ƿ�������¼�ɹ�", "true", String.valueOf(isElementPresent(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[3]"))));
	  //Thread.sleep(1000);
	    
	    String picPath = System.getProperty("user.dir") + File.separator + "p2.jpg";
	    bl.settingInfo(driver, picPath, "30" , "��", "�Ϻ�ͨ�����޹�˾", "76351720514", "763517205122@qq.com", "13391231234");
	    
	    //���ö��Եķ�ʽ��֤�Ƿ񱣴�ɹ� 
	    Object[] expecteds = {"30" , "�Ϻ�ͨ�����޹�˾" , "76351720514" , "13391231234" , "763517205122@qq.com"};
	    Object[] actuals = {
	    		driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_AGE)).getAttribute("value") ,
	    		driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_COMPANY)).getAttribute("value") , 
	    		driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_QQ)).getAttribute("value") , 
	    		driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_PHONE)).getAttribute("value"),
	    		driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_EMAIL)).getAttribute("value")
	    };
	    try {
			assertArrayEquals(expecteds, actuals);
			actural = "true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			errorCollector.addError(e);
			actural = "false";
		}finally{
			re.write("case2:�ж��û������Ƿ�ɹ�", "true", actural);
		}
	    
	    
	    //ͨ��ģ����궯����ʵ��չ��ע����ť����
	    //Actions action = new Actions(driver);
	   //action.moveToElement(driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div/div[3]/div/span/span"))).perform();
	    
	    driver.findElement(BussinessLib.parseObject(LoginPageObjectStore.LOGOUT_LIST)).click();
	    //driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div/div[3]/div/span/span")).click();
	    Thread.sleep(2000);
	    driver.findElement(BussinessLib.parseObject(LoginPageObjectStore.LOGOUT_BTN)).click();
	    //driver.findElement(By.xpath("//ul[starts-with(@id ,'dropdown-menu')]/li[2]")).click();
	    Thread.sleep(1000);
	    //�����Ƿ�����ע���ɹ�
	    //assertTrue(isElementPresent(By.linkText("��¼")));
	    re.write("case3���ж��û��Ƿ�����ע��", "true", String.valueOf(isElementPresent(By.linkText("��¼"))));
	    
	  }
	
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	
	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }
	
	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
