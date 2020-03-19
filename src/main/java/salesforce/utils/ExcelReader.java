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
    private static final String FILE_PATH = "src/test/resources/sheetfiles/";
    private static final int ZERO = 0;

    /**
     * Reads sheet and return list.
     * @param fileName of sheet file.
     * @return list.
     */
    public static Sheet readExcel(final String fileName) {
        Sheet datatypeSheet = null;
        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_PATH + fileName));
            Workbook workbook = new XSSFWorkbook(excelFile);
            datatypeSheet = workbook.getSheetAt(ZERO);
            excelFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datatypeSheet;
    }
}
