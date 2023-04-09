package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import static utilities.Driver.driver;

public class ReusableMethods {
    public XSSFCell getDataFromExcelFile(String filePath, Integer rowNumber, Integer cellNumber) throws IOException {
        FileInputStream fs = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        return sheet.getRow(rowNumber).getCell(cellNumber);
    }

    public void waitUntil(Integer duration){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }

    public void selectDropdown(String id, String value) {
        Select dropdown = new Select(driver.findElement(By.id(id)));
        dropdown.selectByValue(value);
    }
}
