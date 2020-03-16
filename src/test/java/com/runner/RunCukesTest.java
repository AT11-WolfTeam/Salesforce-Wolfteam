/*
 *  Copyright (c) 2019 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.runner;

import core.report.Report;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class RunCukesTest extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void beforeExecution() {
    }

    @AfterTest
    public void afterExecution() {
        Report.getInstance().generateReport();
    }
}
