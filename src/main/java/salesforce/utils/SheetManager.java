/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manages sheet.
 *
 * @author Juan Martinez.
 * @version 1.0 19 March 2020.
 */
public final class SheetManager {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static ArrayList<HashMap<String, String>> entitiesList;
    private static int uniqueId = 0;
    private static int counter = 0;

    /**
     * Private SheetManager constructor.
     */
    private SheetManager() {

    }

    /**
     * Create hash map.
     *
     * @param rowKey value.
     * @param rowValue value.
     * @return hash map.
     */
    public static HashMap<String, String> createHasMap(final Row rowKey, final Row rowValue) {
        uniqueId++;
        counter = 0;
        HashMap<String, String> entityMap = new HashMap<>();
        for (int cellItem = rowKey.getFirstCellNum() + ONE; cellItem < rowKey.getLastCellNum(); cellItem++) {
            counter++;
            Cell cellValue = rowValue.getCell(cellItem);
            if (cellValue == null)
                continue;
            Cell cellKey = rowKey.getCell(cellItem);
            if (counter == ONE) {
                entityMap.put(cellKey.getStringCellValue(), cellValue.getStringCellValue() + uniqueId);
            }
            else if(cellValue.getCellType()== CellType.STRING)
                entityMap.put(cellKey.getStringCellValue(), cellValue.getStringCellValue());
            else if(cellValue.getCellType()==CellType.NUMERIC)
                entityMap.put(cellKey.getStringCellValue(), String.valueOf(cellValue.getNumericCellValue()));
        }
        return entityMap;
    }

    /**
     * Generates salesforce entities map.
     *
     * @param rowKey values.
     * @param rowValue values.
     * @param quantity number value.
     */
    private static void createQuantityOfMap(final Row rowKey, final Row rowValue, final int quantity) {
        int entityQuantity = quantity;
        while (entityQuantity > ZERO) {
            HashMap<String, String> entityMap = createHasMap(rowKey, rowValue);
            entitiesList.add(entityMap);
            entityQuantity--;
        }
    }

    /**
     * Manage sheet to convert in map entities.
     *
     * @param sheetName object.
     * @param quantity number.
     * @param entityType value.
     * @return list of maps.
     */
    public static ArrayList<HashMap<String, String>> manageSheet(final String sheetName, final int quantity,
                                                                 final String entityType) {
        Sheet dataSheet = ExcelReader.readExcel(sheetName);
        entitiesList = new ArrayList<>();
        Row rowKey = dataSheet.getRow(ZERO);
        Row rowValue = findEntityType(dataSheet, entityType);

        createQuantityOfMap(rowKey, rowValue, quantity);
        return entitiesList;
    }

    /**
     * Finds type of entity.
     *
     * @param datatypeSheet object.
     * @param entityType name.
     * @return row found or null if it is not there.
     */
    private static Row findEntityType(final Sheet datatypeSheet, final String entityType) {
        for (int item = datatypeSheet.getFirstRowNum() + ONE; item <= datatypeSheet.getLastRowNum(); item++) {
            Row row = datatypeSheet.getRow(item);
            Cell cell = row.getCell(ZERO);
            if (entityType.equals(cell.getStringCellValue())) {
                return row;
            }
        }
        return null;
    }
}
