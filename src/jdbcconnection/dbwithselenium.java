package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class dbwithselenium {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host="localhost";
		String port="3306";
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/QedgeDB", "root", "Shakhal@9");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from Employeeinfo where name='Sameer'");
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium softwares\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=in");
		while(rs.next())
		{
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(rs.getString("Name"));
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(rs.getString("Age"));
		driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
		driver.close();
		}

	}

}