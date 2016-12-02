package com.controls.pages.surrounding.enums;

import com.controls.pages.surrounding.entities.User;
import com.epam.commons.linqinterfaces.JAction;
import com.epam.jdi.uitests.web.selenium.preconditions.WebPreconditions;

import java.util.function.Supplier;

import static com.controls.JDITestSite.*;

public enum Preconditions implements WebPreconditions {
    LOGIN(
            () -> login.logout.isDisplayed(),
            () -> login.submit(User.DEFAULT)
    ),
    LOGOUT(
            () -> !login.logout.isDisplayed(),
            () -> login.logout.click()
    ),
    HOMEPAGE_OPENED(
            () -> homePage.verifyOpened(),
            () -> homePage.open()
    ),
    MCPAGE_OPENED(
            () -> metalsColorsPage.verifyOpened(),
            () -> metalsColorsPage.open()
    ),
    CPPAGE_OPENED(
            () -> contactPage.verifyOpened(),
            () -> contactPage.open()
    ),
    CTPAGE_OPENED(
            () -> complexTablePage.verifyOpened(),
            () -> complexTablePage.open()
    ),
    STPAGE_OPENED(
            () -> simpleTablePage.verifyOpened(),
            () -> simpleTablePage.open()
    ),
    DaPAGE_OPENED(
            () -> datesPage.verifyOpened(),
            () -> datesPage.open()
    ),
    TPPAGE_OPENED(
            () -> tablePagesPage.verifyOpened(),
            () -> tablePagesPage.open()
    ),
    SPPAGE_OPENED(
            () -> supportPage.verifyOpened(),
            () -> supportPage.open()
            );

    public Supplier<Boolean> checkAction;
    public JAction moveToAction;

    Preconditions(Supplier<Boolean> checkAction, JAction moveToAction) {
        this.checkAction = checkAction;
        this.moveToAction = moveToAction;
    }

    public Boolean checkAction() {
        return checkAction.get();
    }

    public void moveToAction() {
        moveToAction.invoke();
    }
}
