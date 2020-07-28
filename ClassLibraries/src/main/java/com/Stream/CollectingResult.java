package com.Stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResult {
    public static Stream<String> noVowels() throws IOException {
        var contents=new String(Files.readAllBytes(Paths.get("H:\\J2EE\\DataStructures\\DataStructure\\src\\" +
                "main\\java\\com\\AVLTree\\AVLTree.java")), StandardCharsets.UTF_8);
        List<String> wordList=List.of(contents.split("\\PL+"));
        Stream<String> words = wordList.stream();
        return words.map(s -> s.replaceAll("[aeiouAEIOU]",""));
    }
    public static <T> void show(String label, Set<T> set){
        System.out.print(label+": "+set.getClass().getName());
        System.out.println("["+
                set.stream().limit(10).map(Object::toString).collect(Collectors.joining(", "))+"]");
    }

    public static void main(String[] args) throws IOException {
        Iterator<Integer> iter = Stream.iterate(0, n -> n + 1).limit(10).iterator();
        while (iter.hasNext()) System.out.println(iter.next());
        Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println("Object array:"+numbers);
        try {
            var number=(Integer)numbers[0];
            System.out.println("number: "+number);
            var number2=(Integer[])numbers;
        }catch (ClassCastException ex){
            System.out.println(ex);
        }

        Integer[] number3 = Stream.iterate(0, n -> n + 1).limit(10).toArray(Integer[]::new);
        System.out.println("number3: "+number3);

        Set<String> noVowelSet = noVowels().collect(Collectors.toSet());
        show("noVoweSet",noVowelSet);

        IntSummaryStatistics sum = noVowels().collect(Collectors.summarizingInt(String::length));
        double average = sum.getAverage();
        int max = sum.getMax();
        System.out.println(average);
        System.out.println(max);
        System.out.println("forEach:");
        noVowels().limit(10).forEach(System.out::println);
    }
}
