package NdzLaunch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class addToCart {
	
	public static void main(String args[]) throws IOException,InterruptedException {
		
		WebDriver driver = new EdgeDriver();
	
		driver.get("http://ecomdemo.ndz.co.in:4007/");
		driver.manage().window().maximize();
//		
		addToCart obj = new addToCart();
		Search_Product searchObj = new Search_Product(driver);
		obj.methodToRead(driver,searchObj);

	}
	
	@SuppressWarnings("deprecation")
	public  void methodToRead(WebDriver driver,Search_Product searchObj) throws IOException, InterruptedException {
	
		List<String> list = new ArrayList<String>();
		
		File obj = new File("E:\\ECLIPSE IDE WORKSPACE\\com.ndz\\src\\Data\\Book1.xlsx");
		
		System.out.println(obj);
		FileInputStream file = new FileInputStream(obj);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		System.out.println("test");
	
		for (Row row: sheet) {
			for (Cell cell : row) {
				list.add(cell.toString());
			}
			System.out.println("");
		}
		System.out.println(list);
		

		List<String> product = new ArrayList<String>();
		List<String> quantity = new ArrayList<String>();

		
		for (int i =0;i<list.size();i++) {
			
			if(i%2==0) {
				product.add(list.get(i));
			}
			else {
				quantity.add(list.get(i));
			}
			
		}
		System.out.println(product);
		System.out.println(quantity);

		

		
		
		for(String value : product) {
			
			WebElement search = searchObj.getSearchBarWebElemnt();
			search.clear();
			search.sendKeys(value, Keys.ENTER);
			
//			WebElement buttonClick = searchObj.getSearchButtonWebElemnt();
//			buttonClick.click();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			
			Actions ac = new Actions(driver);
			ac.moveToElement(searchObj.getAddtocart()).perform();
			searchObj.getAddtocart().click();
			
			
			for (int a = 0; a<=quantity.size(); a++) {
				
				double d = Double.parseDouble(quantity.get(a));
				int val = (int) d;
				System.out.println("prods "+ value +"quans "+ val);
				for(int q = 1; q<val; q++ ) {
					searchObj.getQuantityPlus().click();
				}
//				break;
			}
		}
		
		
	}

}
