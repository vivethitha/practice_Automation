package org.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public static WebDriver driver;
	
	public static void browserlaunch(String browsername) {
		if(browsername.equals("chrome")) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if (browsername.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		else if (browsername.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
			driver.manage().window().maximize();	
		}
		
	public static void lauchurl(String url) {
		driver.get(url);

	}
	
	public static void passtext(WebElement textelement, String text) {
		
		textelement.sendKeys(text);
		

	}
	
	public static void clickWebElement(WebElement btnelement) {
		btnelement.click();
		

	}
	private void takeScreenshot(String imgname) throws IOException {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Admin\\eclipse-workspace\\MavenProject\\images" + imgname + ".png");
		FileUtils.copyFile(src, dest);
	}
	
	public static Actions a;
	
	public static void moveTheCursor(WebElement targetwebelement) {
		a=new Actions(driver);
		a.moveToElement(targetwebelement).perform();
		
		

	}
	
	public static void dragAndDrop(WebElement src, WebElement dest) {
		
		a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();
		

	}
	public static void doubleClick(WebElement txtelement) {
		a=new Actions(driver);
		a.doubleClick(txtelement).perform();
		

	}
	public static void contextClick(WebElement textelement) {
		a=new Actions(driver);
		a.contextClick(textelement).perform();
		

	}
	public static Alert b;	
	
	public static void switchToAlert() {
		b = driver.switchTo().alert();
	}
	
	public static void alertAccept() {
		b= driver.switchTo().alert();
		b.accept();
		
		}
	public static void alertDismiss() {
		b= driver.switchTo().alert();
		b.dismiss();
		
	}
	public static void getText() {
		
		b= driver.switchTo().alert();
		String text = b.getText();
		System.out.println(text);

	}
	
	public static void sendKeys(String sendkeys) {
		b= driver.switchTo().alert();
		b.sendKeys(sendkeys);
		

	}
	
	public static JavascriptExecutor js;
	
	public static void insertValues(String text, WebElement textelement) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value'," + text +" )", textelement);
	}
	
	public static void clickElement(WebElement textelement) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", textelement);
	}
	public static void retrieveText(WebElement textelement) {
		js=(JavascriptExecutor)driver;
		Object str = js.executeScript("return arguments[0].getAttribute('value')", textelement);
		String s =(String)str;
		System.out.println(s);
		

	}
	public static void scrollView(WebElement textelement) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)",textelement);
		
	}
	
	public static String readDataFromCell(String excelsheetname,String sheetName,int getTheRow,int getTheCell) throws IOException {
		File f = new File ("C:\\Users\\Admin\\eclipse-workspace\\TasksPom\\excel\\"+   excelsheetname  +".xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fs);
		Sheet s = w.getSheet(sheetName);
		
		
		
			Row r = s.getRow(getTheRow);
			
			
				Cell c = r.getCell(getTheCell);
				
				
				int cellType = c.getCellType();
				
				String value = "";
				
				if (cellType == 1) {
					value = c.getStringCellValue();
					
					
					
				} 
				else if (DateUtil.isCellDateFormatted(c)) {
					Date dd = c.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
					value = sim.format(dd);
					
					
					
				}
				else {
					double d = c.getNumericCellValue();
					long l =(long) d;
					value = String.valueOf(l);
					
				}

				return value;
			
				
		
	}
		
	public static void createNewExcelSheet(int createrow,int creatcell, String value, String excelsheetname , String sheetname) throws IOException {
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\HotelAdactin\\excel\\"+   excelsheetname  +".xlsx");
		Workbook fi = new XSSFWorkbook();
		
		Sheet newsheet = fi.createSheet(sheetname);
		
		Row newrow = newsheet.createRow(createrow);
		
		Cell newcell = newrow.createCell(creatcell);
		
		newcell.setCellValue(value);
		
		FileOutputStream fis = new FileOutputStream(f);
	
		fi.write(fis);
		System.out.println("done");
		
		
		
	}
	
	public static void createNewCell(int getTheRow,int creatcell,String data, String excelsheetname, String sheetname) throws IOException {
		
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\TasksPom\\excel\\" + excelsheetname + ".xlsx");
		
		FileInputStream file = new FileInputStream(f);
		Workbook fi = new XSSFWorkbook(file);
		
	
		
		Sheet newsheet = fi.getSheet(sheetname);
		
		Row newrow = newsheet.getRow(getTheRow);
		
		Cell newcell = newrow.createCell(creatcell);
		
		newcell.setCellValue(data);
		
		FileOutputStream fis = new FileOutputStream(f);
	
		fi.write(fis);
		System.out.println("done");
		
	}
	
	public static void createNewRow(int createrow,int creatcell, String data, String excelsheetname, String sheetname) throws IOException {
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\TasksPom\\excel\\"+ excelsheetname +".xlsx");
		
		
		FileInputStream file = new FileInputStream(f);
		Workbook fi = new XSSFWorkbook(file);
		Sheet newsheet = fi.getSheet(sheetname);
		
		Row newrow = newsheet.createRow(createrow);
		
		Cell newcell = newrow.createCell(creatcell);
		
		newcell.setCellValue(data);
		
		FileOutputStream fis = new FileOutputStream(f);
	
		fi.write(fis);
		System.out.println("done");

	}
	
	public static void updateExcelfile(int getrow,int getcell, String getdata, String setdata, String excelsheetname, String sheetname) throws IOException {
		
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\TasksPom\\excel\\"+ excelsheetname +".xlsx");
		
		
		FileInputStream file = new FileInputStream(f);
		Workbook fi = new XSSFWorkbook(file);
		Sheet newsheet = fi.getSheet(sheetname);
		
		Row newrow = newsheet.getRow(getrow);
		
		Cell newcell = newrow.getCell(getcell);
		
		String datas = newcell.getStringCellValue();
		
		if (datas.equals(getdata)) {
			newcell.setCellValue(setdata);
		}

		FileOutputStream fis = new FileOutputStream(f);
	
		fi.write(fis);
		System.out.println("done");
		
		
	}
	
	public static void readNoofRows(String excelsheetname, String sheetname) throws IOException {
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\TasksPom\\excel\\"+ excelsheetname+".xlsx");
		
		
		FileInputStream file = new FileInputStream(f);
		Workbook fi = new XSSFWorkbook(file);
		Sheet newsheet = fi.getSheet(sheetname);
		
		int rowno = newsheet.getPhysicalNumberOfRows();
		System.out.println(rowno);

	}
	
	public static void readNoofCells(String excelsheetname, String sheetname) throws IOException {
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\TasksPom\\excel\\"+ excelsheetname + ".xlsx");
		
		
		FileInputStream file = new FileInputStream(f);
		Workbook fi = new XSSFWorkbook(file);
		Sheet newsheet = fi.getSheet(sheetname);
		
		for (int i = 0; i <newsheet.getPhysicalNumberOfRows(); i++) {
			
				Row r = newsheet.getRow(i);
			
			
			
				
				System.out.println(r.getPhysicalNumberOfCells());
				
			}
		
			

}
	public static Select s;
	public static void selectMethod(WebElement element, String text) {
		
		s =new Select(element);
		s.selectByVisibleText(text);
	}

	public static void frameid0rnamelocator(String nameOrId) {
		
		driver.switchTo().frame(nameOrId);

	}
	
	public static void framewebelementref(WebElement webref) {
		
		driver.switchTo().frame(webref);

	}
	
	public static void frameIndex(int index) {
		
		driver.switchTo().frame(index);

	}
	
	public static void switchParentFrame() {
		
		driver.switchTo().parentFrame();

	}
	
	public static void switchFrameToMaincontent() {
		
		driver.switchTo().defaultContent();

	}
	
	public static void twoWindowSwitch() {
		String parid = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for (String itr : allId) {
			if (itr!=parid) {
				driver.switchTo().window(itr);
			}
			
		}
		
		
		
		
	}
	}




