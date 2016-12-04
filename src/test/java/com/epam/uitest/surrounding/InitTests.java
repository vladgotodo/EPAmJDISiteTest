package com.epam.uitest.surrounding;

import com.controls.JDITestSite;
import com.epam.jdi.uitests.core.interfaces.MapInterfaceToElement;
import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.actions.ActionScenrios;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.interfaces.ITable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import org.testng.annotations.*;
import com.controls.pages.surrounding.generalBlocks.CustomElements.*;
import java.util.Map;
import java.util.TreeMap;

import static com.controls.pages.surrounding.enums.Preconditions.HOMEPAGE_OPENED;
import static com.controls.pages.surrounding.enums.Preconditions.LOGIN;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class InitTests extends TestNGBase {

    static Map<Long, String> allActionsTimeNano = new TreeMap<>();

    @BeforeSuite(alwaysRun = true)
    public static void setUpBeforeSuite() throws Exception {
        MapInterfaceToElement.update(
                new Object[][]{
                        {ITextField.class, MyTextField.class},
                        {IButton.class, MyButton.class},
                        {ITable.class, MyTable.class}
                });
        ActionScenrios.actionScenario = (element, actionName, jAction, level) -> {
            long startTimeNano = System.nanoTime();
            jAction.invoke();
            long endTimeNano = System.nanoTime() - startTimeNano;
            logger.info(String.format("It took %f to %s element with name:%s and type:%s",
                    (endTimeNano / 1000000000.0),
                    actionName.toUpperCase(),
                    element.getName().toUpperCase(),
                    element.getClass().getSimpleName().toUpperCase()));
            allActionsTimeNano.put(endTimeNano, actionName.toUpperCase());
        };
        ActionScenrios.resultScenario = (element, actionName, jAction, logResult, level) -> {
            Object result = jAction.get();
            logger.info(String.format("'%s' action result: %s", actionName.toUpperCase(),
                    result.toString().toUpperCase()));
            return result;
        };
        WebSettings.useDriver(System.getProperty("browser"));
        //WebSettings.useDriver("firefox");
        //WebSettings.useDriver("chrome");
        WebSite.init(JDITestSite.class);
        isInState(HOMEPAGE_OPENED);
        isInState(LOGIN);
        Verify.getFails();
        logger.info("Run Tests");
    }

    @AfterSuite
    public void tearDownAfterSuite() {
        Verify.getFails();
        WebSettings.getDriverFactory().close();
        long fullTime = 0;
        for (long asd : allActionsTimeNano.keySet())
            fullTime += asd;
        logger.info("Actions count: " + allActionsTimeNano.size());
        logger.info("Average time for each action : " +
                ((double)fullTime / allActionsTimeNano.size()) / 1000000000.0);
        int i = 0;
        logger.info("Top five most slow processes:");
        for(Map.Entry e : allActionsTimeNano.entrySet()){
            i++;
            if (allActionsTimeNano.size() - 6 < i)
                logger.info("Time: " + ((double)Long.parseLong(e.getKey().toString())/ 1000000000.0)
                        + "\tAction name :" + e.getValue());
        }
    }
}
