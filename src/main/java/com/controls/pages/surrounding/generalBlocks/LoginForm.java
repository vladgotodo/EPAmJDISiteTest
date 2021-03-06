package com.controls.pages.surrounding.generalBlocks;

import com.controls.pages.surrounding.entities.User;
import com.epam.jdi.uitests.core.interfaces.base.IClickable;
import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {
    @FindBy(id = "Login")
    private ITextField login;
    @FindBy(id = "Password")
    private ITextField password;
    @FindBy(css = ".btn-login")
    public IButton submit;
    @FindBy(css = ".logout")
    public IButton logout;
    @FindBy(css = ".profile-photo")
    public IClickable profile;
    @FindBy(css = "body>div>header>div>nav>ul.uui-navigation.nav.navbar-nav.navbar-right>li>a>div>span")
    public IText name;
    //

    @Override
    public void submit(User user) {
        profile.click();
        super.submit(user);
    }

    public void logout() {
        if (logout.isDisplayed())
            logout.click();
        else{
            profile.click();
            logout.click();
        }
    }
}