package com.controls;

import com.controls.pages.*;
import com.controls.pages.surrounding.pageBlocks.generalBlocks.Sidebar;
import com.controls.pages.surrounding.pageBlocks.generalBlocks.Footer;
import com.controls.pages.surrounding.pageBlocks.generalBlocks.Header;
import com.controls.pages.surrounding.pageBlocks.generalBlocks.LoginForm;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import org.openqa.selenium.support.FindBy;

@JSite(domain = "https://jdi-framework.github.io/tests")
public class JDITestSite extends WebSite{
    @JPage(url = "/index.htm", title = "Index Page")
    public static HomePage homePage;
    @JPage(url = "/page1.htm", title = "Contact Form")
    public static ContactPage contactPage;
    @FindBy(css = ".uui-profile-menu")
    public static LoginForm login;
    @FindBy(css = ".uui-header")
    public static Header header;
    @FindBy(css = ".footer-content")
    public static Footer footer;
    @FindBy(css = ".sidebar-menu")
    public static Sidebar sidebar;
    @JPage(url = "/page2.htm", title = "Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;


    @JPage(url = "/page3.htm", title = "Support")
    public static SupportPage supportPage;
    @JPage(url = "/page4.htm", title = "Dates")
    public static DatesPage datesPage;
    @JPage(url = "/page5.htm", title = "Complex Table")
    public static ComplexTablePage complexTablePage;
    @JPage(url = "/page6.htm", title = "Simple Table")
    public static SimpleTablePage simpleTablePage;
    @JPage(url = "/page7.htm", title = "Table with pages")
    public static TablePagesPage tablePagesPage;
    @JPage(url = "/page8.htm", title = "Different Element")
    public static DifferentElementPage differentElementPage;
}
