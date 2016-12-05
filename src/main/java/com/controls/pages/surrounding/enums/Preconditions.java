package com.controls.pages.surrounding.enums;

import com.controls.pages.surrounding.entities.User;
import com.epam.commons.linqinterfaces.JAction;
import com.epam.jdi.uitests.web.selenium.preconditions.WebPreconditions;
import java.util.function.Supplier;

import static com.controls.JDITestSite.*;

public enum Preconditions implements WebPreconditions {
    LOGIN(
            () -> login.name.isDisplayed(),
            () -> login.submit(User.DEFAULT)
    ),
    LOGOUT(
            () -> login.name.isHidden(),
            () -> login.logout()
    ),
    LOGOUT_BTN(
            () -> login.logout.isHidden() && login.name.isDisplayed(),
            () -> login.profile.click()
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
