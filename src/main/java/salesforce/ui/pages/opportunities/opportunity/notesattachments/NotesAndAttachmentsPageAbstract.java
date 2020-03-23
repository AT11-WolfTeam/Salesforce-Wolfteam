/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package salesforce.ui.pages.opportunities.opportunity.notesattachments;

import salesforce.ui.pages.BasePage;

/**
 * Manages notes and attachments.
 *
 * @author Juan Martinez.
 * @version 1.0 21 March 2020.
 */
public abstract class NotesAndAttachmentsPageAbstract extends BasePage {

    /**
     * Allows to upload a new file.
     */
    public abstract void clickOnUploadFiles();

    public abstract String getUploadedFileName(String fileName);
}
