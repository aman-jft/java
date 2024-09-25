package org.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sequ {

    static List<String> findStrings(List<String> sentences) {
        return sentences.stream()
                .map(sentence -> Arrays.asList(sentence.split(" ")))
                .flatMap(list-> list.stream())
                .filter(str-> str.length()>5)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList("Java 8 is great", "Streams are powerful", "filter and map are useful");
        System.out.println(findStrings(sentences));
    }
}
