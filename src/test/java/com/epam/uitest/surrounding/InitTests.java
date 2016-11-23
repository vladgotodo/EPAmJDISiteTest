package com.epam.uitest.surrounding;

import com.controls.JDITestSite;
import com.epam.jdi.uitests.web.selenium.elements.actions.ActionScenrios;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import org.testng.annotations.*;

import java.util.Map;
import java.util.TreeMap;

import static com.controls.pages.surrounding.Preconditions.HOMEPAGE_OPENED;
import static com.controls.pages.surrounding.Preconditions.LOGIN;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class InitTests extends TestNGBase {

    static Map<Long, String> actionsTime = new TreeMap<>();

    @BeforeSuite(alwaysRun = true)
    public static void setUpBeforeSuite() throws Exception {
        ActionScenrios.actionScenario = (element, actionName, jAction, level) -> {
            long start = System.nanoTime();
            jAction.invoke();
            long end = System.nanoTime() - start;
            logger.info(actionName.format("It took %d to do %s", end, actionName));
            logger.info(actionName.format("%s done", actionName));
            actionsTime.put(end, actionName);
        };
        ActionScenrios.resultScenario = (element, actionName, jAction, logResult, level) -> {
            Object result = jAction.get();
            logger.info(actionName.format("'%s' action result: %s", actionName, result));
            return result;
        };
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
        for (long asd : actionsTime.keySet())
            fullTime += asd;
        logger.info(String.format("Actions count: " + actionsTime.size()));
        logger.info(String.format("Average time for each action : " +
                ((double)fullTime / actionsTime.size()) / 1000000000.0));
        int i = 0;
        logger.info("Top five most slow processes:");
        for(Map.Entry e : actionsTime.entrySet()){
            i++;
            if (actionsTime.size() - 6 < i)
                logger.info("Time: " + ((double)Long.parseLong(e.getKey().toString())/ 1000000000.0)
                        + "-Action name :" + e.getValue());
        }
    }
}
