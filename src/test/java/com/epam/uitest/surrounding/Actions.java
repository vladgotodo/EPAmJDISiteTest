package com.epam.uitest.surrounding;

import com.epam.web.matcher.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;

import static com.controls.JDITestSite.logPanel;
import static com.epam.web.matcher.testng.Assert.assertContains;
import static java.lang.String.format;

public class Actions {
    private static String _path = null;
    private static String _name = null;

    @Step
    public static void checkAction(String text) {
        assertContains(logPanel::getFirstText, text);
    }

    public static String getFPath() {
        if (_path == null) {
            createFile();
        }
        return _path;
    }

    private static void createFile() {
        try {
            File temp = File.createTempFile("tmp", ".tmp");
            _name = temp.getName();
            _path = temp.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String fileName() {
        if (_name == null) {
            createFile();
        }
        return _name;
    }

    public static void checkFileLoaded(String uploadedFileName, String fileName) {
        checkAction(format("FileUpload: file \"%s\" has been uploaded", fileName));
        Assert.areEquals(uploadedFileName, fileName);
    }
}
