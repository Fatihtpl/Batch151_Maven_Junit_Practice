package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

        // Ulkeler dosyasındaki "Başkent (İngilizce)" sutununu yazdırınız.


    @Test
    public void test01() throws IOException {

        String dosyaYolu = "src/resources/ulkeler (1).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);


        int sonSatirIdx =  workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatirIdx);
        // getLastRowNum() son satır numarasını index olarak verir.


        /*
        2.YOL

        for (int i = 0; i <=sonSatirIdx ; i++) {

            String satirdakiData = C01_ReadExcel.banaDataGetir(i,1);

            System.out.println(satirdakiData);

        NOT:
        - static bir methoda farklı bir class'dan ulasabilmek icin class ismi kullanılır.
        - instance bir methoda farklı bir class'dan ulasabilmek icin obje olusturulur.

        }

        burada method kullanarak yaptik diger yolda method kullanmadan yaptik.
         */


        for (int i = 0; i <=sonSatirIdx ; i++) {

            String satirdakiData = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            System.out.println(satirdakiData);


        }



    }
}
