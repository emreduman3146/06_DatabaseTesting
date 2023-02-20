package DB_Testing.MariaDBTesting.programs;


import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import static DB_Testing.MariaDBTesting.utils.DBUtil.*;
import static DB_Testing.MariaDBTesting.utils.ExcelUtil.*;
import static DB_Testing.MariaDBTesting.utils.PropertiesReadWrite.getProperty;

public class MariaDBConnectionProgram
{

    //CRUD + EXCEL (QUERIES + EXPECTED DATA)
    @Test
    public void tableIsimleriniDogruluyorum_Test01() {

        //Diyoruz ki bir tane util methodu olusturalim. Kim baglanti kurmak isterse bu methodu kullanmasi yetsin.
        //STEP1-AUTOMATION
        connectToMariaDB(getProperty("NATION_DB_SERVER_URL"), getProperty("USERNAME"), getProperty("PASSWORD"));

        //STEP2-AUTOMATION
        //nation_db'deki table isimlerinin al
        List<String> mariaDB_tableIsimleri = getAllTableNames();
        System.out.println(mariaDB_tableIsimleri);

        //STEP3 - AUTOMATION
        //excel'deki table isimlerini al
        List<String> excelData_tableIsimleri = getColumnValues(getProperty("TESTDATA_EXCELPATH"), "DB_nation", "Table_Names");
        System.out.println(excelData_tableIsimleri);

        //STEP 4 -TESTING(VERIFICATION)
        //assert et
        Assert.assertTrue(excelData_tableIsimleri.equals(mariaDB_tableIsimleri));

        
    }


}

