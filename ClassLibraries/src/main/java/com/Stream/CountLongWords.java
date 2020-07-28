package com.Stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CountLongWords {
    public static void main(String[] args) throws IOException {
        var contents=new String(Files.readAllBytes(Paths.get("H:\\J2EE\\DataStructures\\DataStructure\\src\\" +
                "main\\java\\com\\AVLTree\\AVLTree.java")), StandardCharsets.UTF_8);
        List<String> words=List.of(contents.split("\\PL+"));
        long count=0;
        count=words.stream().filter(w->w.length()>12).count();
        System.out.println(count);


    }
}
