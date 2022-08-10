package edu.serjmaks.junit.ex04;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindMaxSBefore {

    // before refactoring
    public void findMaxS() {
        String path = "src/main/resources/files_for_comparing";
        Map<String, Integer> fileMap = new HashMap<>();
        File files = new File(path);
        File[] filesArray = files.listFiles();
        for (File file : filesArray) {
            if (!file.isDirectory()) {
                String filePath = file.getPath();
                String fileName = file.getName();
                int totalCharacters = 0;
                char temp;
                for (int i = 0; i < fileName.length(); i++) {
                    temp = fileName.charAt(i);
                    if (temp == 's') {
                        totalCharacters++;
                    }
                }
                fileMap.put(filePath, totalCharacters);
            }
        }
        String result = Collections.max(fileMap.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
        System.out.println(result);
    }
}
