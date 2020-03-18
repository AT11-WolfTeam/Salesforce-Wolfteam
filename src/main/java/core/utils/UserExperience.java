/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package core.utils;

/**
 * This enum is used for specifying Audio formats.
 *
 * @author Enrique Carrizales.
 * @version 1.0 17 March 2020.
 */
public enum UserExperience {
    USER_EXPERIENCE_CLASSIC("Classic"),
    USER_EXPERIENCE_LIGHTNING("Lightning");

    private String userExperience;

    /**
     * Builds an Enum.
     *
     * @param userExperience String value
     */
    UserExperience(final String userExperience) {
        this.userExperience = userExperience;
    }

    /**
     * Gets User Experience value.
     *
     * @return String value.
     */
    public String get() {
        return userExperience;
    }
}
