/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.notesattachments;

import salesforce.ui.pages.AbstractBasePage;

/**
 * Manages notes and attachments.
 *
 * @author Juan Martinez.
 * @version 1.0 21 March 2020.
 */
public abstract class NotesAndAttachmentsPageAbstract extends AbstractBasePage {

    /**
     * Clicks on upload files.
     * @param filePath value.
     */
    public abstract void clickOnUploadFiles(String filePath);

    /**
     * Gets uploaded file name.
     * @param fileName value.
     * @return uploaded file name.
     */
    public abstract String getUploadedFileName(String fileName);
}
