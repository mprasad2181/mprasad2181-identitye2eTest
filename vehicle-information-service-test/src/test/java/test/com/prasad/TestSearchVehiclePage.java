package test.com.prasad;

import com.opencsv.CSVReader;
import com.prasad.DirectoryService;
import com.prasad.DirectoryServiceImpl;
import com.prasad.FileModel;
import com.prasad.SearchVehiclePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TestHomePage
 * identitye2e
 * Description :
 */

public class TestSearchVehiclePage {

   private SearchVehiclePage searchVehiclePage;
   private DirectoryService directoryService;

    @BeforeTest
    public void launchBrowser() {
        System.setProperty(Constants.GECKO_KEY, Constants.GECKO_DRIVER_LOCATION);
        directoryService = new DirectoryServiceImpl();
        WebDriver driver= new FirefoxDriver();
        searchVehiclePage = new SearchVehiclePage(driver);
        searchVehiclePage.open();
    }

    @Test
    public void canGoToHomePage() {
        String title = searchVehiclePage.getTitle();
        Assert.assertEquals(title, Constants.TITLE);
    }

    @Test
    public void  isVrmElementVisibleAfterStartButtonClick() {
        boolean isInputElementVisible = searchVehiclePage.isVrmElementVisibleAfterStartButtonClick();
        Assert.assertTrue(isInputElementVisible);
    }

    @Test
    public void  searchForColours() {
        List<FileModel> testDataFiles = directoryService.getFilesByMime("src/test/resources/testData","application/octet-stream");
        List<String> correctModels = new ArrayList<String>();
        for(FileModel fileModel : testDataFiles){
            String filePath= fileModel.getFileName();
            try {
                CSVReader  reader = new CSVReader(new FileReader(filePath));
                String[] line;
                while ((line = reader.readNext()) != null) {
                    String colorOfVehicle = searchVehiclePage.submitVrmAndGetColor(line[0]);
                    if(colorOfVehicle.equalsIgnoreCase(line[1])){
                        correctModels.add(line[0]);
                        searchVehiclePage.selectNoAndClickContinue();
                    }else{
                        searchVehiclePage.clickSearchAgain();
                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        Assert.assertEquals(testDataFiles.size(), correctModels.size());


    }


}
