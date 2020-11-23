package com.road.homework.test;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DoclevelUnitTestSettingPO2 {

	private static WebDriver driver;
	private boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();
	private BussinessLib bl = new BussinessLib();
	static ReportEntry re;
	
	private String actural = "FALSE";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 //driver = new FirefoxDriver();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(AutoTestTools.getConfigFromProperties("baseURL"));
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	}
	
	
	  @Before
	  public void setUp() throws Exception {
	   
	  }
	
	  @Test
	  public void test1_login() throws Exception {
		 
		 bl.login(driver, AutoTestTools.getConfigFromProperties("user"), AutoTestTools.getConfigFromProperties("password"));
	    Thread.sleep(2000);
	    re.write("case1:判断用户是否正常登录成功", "true", String.valueOf(isElementPresent(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[3]"))));
	  }
	  
	  
	  @Test
	  public void test2_setting(){
		  	String picPath = System.getProperty("user.dir") + File.separator + "p2.jpg";
		    bl.settingInfo(driver, picPath, "30" , "男", "上海通信有限公司", "76351720514", "763517205122@qq.com", "13391231234");
		    Object[] expecteds = {"30" , "上海通信有限公司" , "76351720514" , "13391231234" , "763517205122@qq.com"};
		    Object[] actuals = {
		    		driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_AGE)).getAttribute("value") ,
		    		driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_COMPANY)).getAttribute("value") , 
		    		driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_QQ)).getAttribute("value") , 
		    		driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_PHONE)).getAttribute("value"),
		    		driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_EMAIL)).getAttribute("value")
		    };
		   /* try {
				assertArrayEquals(expecteds, actuals);
				actural = "true";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				re.write("case2:判断用户设置是否成功", "true", actural);
			}*/
		    boolean equals = Arrays.equals(expecteds, actuals);
		    re.write("case2:判断用户设置是否成功", "true", String.valueOf(equals));
	  }
	
	  @Test
	  public void test3_logout(){
		  	driver.findElement(BussinessLib.parseObject(LoginPageObjectStore.LOGOUT_LIST)).click();
		    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    driver.findElement(BussinessLib.parseObject(LoginPageObjectStore.LOGOUT_BTN)).click();
		    //driver.findElement(By.xpath("//ul[starts-with(@id ,'dropdown-menu')]/li[2]")).click();
		    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    //断言是否正常注销成功
		    //assertTrue(isElementPresent(By.linkText("登录")));
		    re.write("case3：判断用户是否正常注销", "true", String.valueOf(isElementPresent(By.linkText("登录"))));
	  }
	  
	  
	  @After
	  public void tearDown() throws Exception {
	    
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
