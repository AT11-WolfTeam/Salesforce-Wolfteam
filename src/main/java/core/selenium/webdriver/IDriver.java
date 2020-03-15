package core.selenium.webdriver;

import org.openqa.selenium.WebDriver;

/**
 * Manages a WebDriver.
 *
 * @author Enrique Carrizales.
 * @version 1.0 14 March 2020.
 */
public interface IDriver {

    /**
     * Manage a WebDriver.
     *
     * @return Returns an instance WebDriver.
     */
    WebDriver initDriver();
}
