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
    private static final String CURRENT_USER = "Current User";

    /**
     * replace words in a message.
     * @param message contains a message String.
     * @param opportunityName contains an opportunity name.
     * @return a new message.
     */
    public static String replaceChangeOwnerMessage(final String message, final String opportunityName) {
        String result;
        JsonFileReader jsonFileReader = new JsonFileReader("config.json");
        result = message.replace(CURRENT_USER_REGEX, jsonFileReader.getUser(CURRENT_USER).getUsername());
        return result.replace(OPPORTUNITY_NAME_REGEX, opportunityName);
    }
}
