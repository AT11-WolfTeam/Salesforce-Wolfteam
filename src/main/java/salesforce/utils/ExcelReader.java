/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Reads sheets.
 *
 * @author Juan Martinez.
 * @version 1.0 18 March 2020.
 */
public final class ExcelReader {
    private static final String FILE_PATH = "src/test/resources/sheetfiles/SalesforceData.xlsx";
    private static final int ZERO = 0;

    /**
     * Private ExcelReader constructor.
     */
    private ExcelReader() {

    }

    /**
     * Reads sheet and return list.
     * @param sheetName of sheet file.
     * @return list.
     */
    public static Sheet readExcel(final String sheetName) {
        Sheet datatypeSheet = null;
        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_PATH));
            Workbook workbook = new XSSFWorkbook(excelFile);
            datatypeSheet = workbook.getSheet(sheetName);
            excelFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datatypeSheet;
    }
}
