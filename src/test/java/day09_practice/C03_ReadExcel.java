package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadExcel {

        // Ulkeler dosyasındaki tum dataları map'a alınız ve yazdırınız.


    @Test
    public void test01() throws IOException {

        Map<String,String> ulkelerMap = new TreeMap<>(); //Treemap sirali olarak getiriyordu.

        String dosyaYolu = "src/resources/ulkeler (1).xlsx";//1

        FileInputStream fis = new FileInputStream(dosyaYolu);//2         // 1,2,3 numarali kodlar excel dosyasi ile calisacaksak yapilmasi gerekli.

        Workbook workbook = WorkbookFactory.create(fis);//3


        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();
        // getLastRowNum() son satır numarasını index olarak verir.



        for (int i = 0; i <=sonSatirIndex ; i++) {

            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            String value =  workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);

            // System.out.println(key + " /" + value);

        }

        System.out.println(ulkelerMap);


    }
}
