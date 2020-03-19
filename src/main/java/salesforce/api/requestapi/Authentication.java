/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.api.requestapi;

import salesforce.utils.AccessToken;

/**
 * Allows to authenticate on salesforce.
 *
 * @author Juan Martinez.
 * @version 1.0 16 March 2020.
 */
public final class Authentication {
    private static final String SPACE = " ";

    /**
     * Authentication constructor.
     */
    private Authentication() {

    }

    /**
     * Gets access token.
     * @return access token value.
     */
    public static String getAccessToken() {
        return AccessToken.getInstance().getClient().getTokenType() + SPACE
                + AccessToken.getInstance().getClient().getAccessToken();
    }
}
