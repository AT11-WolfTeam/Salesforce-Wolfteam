/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.utils;

/**
 * Manages ReplacerMessages of features files.
 *
 * @author Enrique Carrizales.
 * @version 1.0 22 March 2020.
 */
public class ReplacerMessages {
    private static final String CURRENT_USER_REGEX = "[Current User]";
    private static final String OPPORTUNITY_NAME_REGEX = "[Opportunity Name]";
    private static final String CAMPAIGN_NAME_REGEX = "[Campaign Name]";
    private static final String CURRENT_USER = "Current User";
    private static final String TASK_NAME = "[Task Name]";

    /**
     * Replaces words in a message.
     *
     * @param message    contains a message String.
     * @param objectName contains an opportunity name.
     * @return a new message.
     */
    public static String replaceTransactionMessage(final String message, final String objectName) {
        String result;
        JsonFileReader jsonFileReader = new JsonFileReader("config.json");
        result = message.replace(CURRENT_USER_REGEX, jsonFileReader.getUser(CURRENT_USER).getUsername());
        result = result.replace(CAMPAIGN_NAME_REGEX, objectName);
        result = result.replace(OPPORTUNITY_NAME_REGEX, objectName);
        return result;
    }

    /**
     * Replaces words in a message.
     *
     * @param message contains a message String.
     * @param taskName contains an opportunity name.
     * @return a new message.
     */
    public static String replaceTaskSavedMessage(final String message, final String taskName) {
        return message.replace(TASK_NAME, taskName);
    }
}
