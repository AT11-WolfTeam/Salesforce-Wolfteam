/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.utils;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

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
    private static int U_ID = 0;

    /**
     * Private SheetManager account.
     */
    private SheetManager() {

    }

    /**
     * Create hash map.
     * @param rowKey value.
     * @param rowValue value.
     * @return hash map.
     */
    public static HashMap<String, String> createHasMap(final Row rowKey, final Row rowValue) {
        U_ID++;
        HashMap<String, String> entityMap = new HashMap<>();
        for (int cellItem = rowKey.getFirstCellNum() + ONE; cellItem < rowKey.getLastCellNum(); cellItem++) {
            Cell cellValue = rowValue.getCell(cellItem);
            if (cellValue != null) {
                Cell cellKey = rowKey.getCell(cellItem);
                entityMap.put(cellKey.getStringCellValue(), cellValue.getStringCellValue() + U_ID);
            }
        }
        return entityMap;
    }

    /**
     * Generates salesforce entities map.
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
     * @param dataSheet object.
     * @param quantity number.
     * @param accountType value.
     * @return list of maps.
     */
    public static ArrayList<HashMap<String, String>> manageSheet(final Sheet dataSheet, int quantity, String accountType) {
        entitiesList = new ArrayList<>();
        Row rowKey = dataSheet.getRow(ZERO);
        Row rowValue = findAccountType(dataSheet, accountType);

        createQuantityOfMap(rowKey, rowValue, quantity);
        return entitiesList;
    }

    /**
     * Finds type account.
     * @param datatypeSheet object.
     * @param accountType name.
     * @return row found or null if it is not there.
     */
    private static Row findAccountType(final Sheet datatypeSheet, final String accountType) {
        for(int item = datatypeSheet.getFirstRowNum() + ONE; item <= datatypeSheet.getLastRowNum(); item ++){
            Row row = datatypeSheet.getRow(item);
            Cell cell = row.getCell(ZERO);
            if (accountType.equals(cell.getStringCellValue())) {
                return row;
            }
        }
        return null;
    }
}
