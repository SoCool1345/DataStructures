package com.Stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class OptionalTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("H:\\J2EE\\DataStructures\\DataStructure\\src\\" +
                "main\\java\\com\\AVLTree\\AVLTree.java");
        var contents=new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        List<String> wordList = List.of(contents.split("\\PL+"));
        Optional<String> optionalValue=wordList.stream().filter(s -> s.contains("c")).findFirst();
        System.out.println(optionalValue.orElse("No word")+" contains c");

        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result:"+result);
        result=optionalString.orElseGet(()-> Locale.getDefault().getDisplayName());
        System.out.println("result:"+result);
//        try {
//            result = optionalString.orElseThrow(IllegalStateException::new);
//            System.out.println("result:"+result);
//        }catch (Throwable t){
//            t.printStackTrace();
//        }


        var results=new HashSet<String>();
        //optionalValue.ifPresent(results::add);
        Optional<Boolean> added = optionalValue.map(results::add);

        System.out.println(Arrays.toString(results.toArray()));

        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));
        Optional<Double> result2=Optional.of(-4.0).flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
        System.out.println(result2);

    }
    public static Optional<Double> inverse(Double x){
        return x==0?Optional.empty():Optional.of(1/x);
    }
    public static Optional<Double> squareRoot(Double x){
        return x<0?Optional.empty():Optional.of(Math.sqrt(x));
    }
}
