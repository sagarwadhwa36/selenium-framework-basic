package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Utility {

    public static String getScreenshot(WebDriver driver, ITestResult iTestResult)
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir") + File.separator + "screenshots" + File.separator  + iTestResult.getMethod().getMethodName()+".png";
        File destination=new File(path);
        try
        {
            FileUtils.copyFile(src, destination);
        } catch (IOException e)
        {
            System.out.println("Capture Failed "+e.getMessage());
        }
        return path;
    }

    public static boolean findElement(WebElement webElement) {
        boolean flag = false;
        try {
            webElement.isDisplayed();
            flag = true;
        } catch (Exception e) {
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully Found element");

            } else {
                System.out.println("Unable to locate element");
            }
        }
        return flag;
    }

    public static String getTestData(String key) throws Exception {
        return readFile(Constants.testDataPath,key);
    }

    public static String readFile(String path, String keytoRead) throws IOException {
        String result = null;
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = null;
            while((line = br.readLine())!=null){
                String[] values = line.split("~");
                if(values[0].trim().equals(keytoRead)){
                    result =  values[1].trim();
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static int countTestData(String testDataKey){
        return 0;
    }

}
