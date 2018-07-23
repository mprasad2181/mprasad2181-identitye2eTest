package test.com.prasad;

import com.prasad.DirectoryService;
import com.prasad.DirectoryServiceImpl;
import com.prasad.FileModel;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * DirectoryServiceTest
 * identitye2e
 * Description :
 */


public class DirectoryServiceTest {

    private static DirectoryService directoryService;


    @BeforeClass
    public static void initCalculator() {
        directoryService = new DirectoryServiceImpl();
    }


    @Test
    public void scanFolder() throws Exception {
        List<FileModel>  fileModels = directoryService.getAllFileDetails("src/test/resources/filesFolder");
        assertTrue(fileModels.size() == 2);
    }

    @Test
    public void getFileBySize() throws Exception {
        List<FileModel>  fileModels = directoryService.getFilesBySize("src/test/resources/filesFolder", 24 , 10 );
        assertTrue(fileModels.size() == 1);
    }
    @Test
    public void getFileByMime() throws Exception {
        List<FileModel>  fileModels = directoryService.getFilesByMime("src/test/resources/filesFolder","text/plain");
        assertTrue(fileModels.size() == 1);
    }
}
