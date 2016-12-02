package com.controls.pages.surrounding;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class JSLoader {

    public String getJSFromFile(String fileName, String[][] keywordsToReplace) {

        StringBuilder loadedJS = getJSStringBuilder(fileName);

        int posReplaceFrom = 0;

        for (int i = 0; i < keywordsToReplace.length; i++) {
            loadedJS.replace(posReplaceFrom = loadedJS.indexOf(keywordsToReplace[i][0]),
                    posReplaceFrom + keywordsToReplace[i][0].length(),
                    keywordsToReplace[i][1]);
        }

        return loadedJS.toString();

    }


    private StringBuilder getJSStringBuilder(String fileName) {
        StringBuilder loadedJS = new StringBuilder();

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File jsFile = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(jsFile)) {

            while (scanner.hasNextLine()) {
                loadedJS.append(scanner.nextLine()).append("\n");
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedJS;
    }


}
