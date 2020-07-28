package com.Stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CreatingStreams {
    public static <T> void show(String title,Stream<T> stream){
        final int SIZE=10;
        List<T> firstElements = stream.limit(SIZE+1).collect(Collectors.toList());
        System.out.print(title+": ");
        for (int i = 0; i < firstElements.size(); i++) {
            if(i>0) System.out.print(", ");
            if(i<SIZE) System.out.print(firstElements.get(i));
            else System.out.print("...");
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("H:\\J2EE\\DataStructures\\DataStructure\\src\\" +
                "main\\java\\com\\AVLTree\\AVLTree.java");
        var contents=new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        Stream<String> words = Stream.of(contents.split("\\PL+"));
        show("words",words);

        Stream<String> song = Stream.of("g", "d", "t", "s");
        show("song",song);

        Stream<String> empty = Stream.empty();
        show("empty",empty);

        Stream<String> g1 = Stream.generate(() -> "Echo");
        show("g1",g1);
        Stream<Double> g2 = Stream.generate(Math::random);
        show("g2",g2);

        Stream<BigInteger> iterate = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        show("iterate",iterate);
//        Stream<String> c = Stream.ofNullable(contents);
//        show("c",c);
        Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(contents);
        show("wordsAnotherWay",wordsAnotherWay);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)){
            show("lines",lines);
        }

        Iterable<Path> iterable= FileSystems.getDefault().getRootDirectories();
        Stream<Path> rootDirectories= StreamSupport.stream(iterable.spliterator(),false);
        show("rootDirectories",rootDirectories);

        Iterator<Path> iterator=Paths.get("H:\\J2EE\\DataStructures\\DataStructure\\src\\" +
                "main\\java\\com\\AVLTree\\AVLTree.java").iterator();
        Stream<Path> pathComponents = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);
        show("pathComponents",pathComponents);

        Stream<Integer> firstStream = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> secondStream = Stream.of(4, 5, 6, 7, 8, 9);
        Stream<Integer> resultingStream = Stream.concat(firstStream, secondStream)
                .distinct();
        show("resultingStream",resultingStream);

        Stream<String> a = Stream.of(contents.split("\\PL+")).limit(5).sorted(Comparator.comparing(String::length));
        Stream<String> b = Stream.of(contents.split("\\PL+")).limit(5).filter(s ->  s.startsWith("c"));
        Stream<String> concat = Stream.concat(a, b);
        show("concat",concat);
    }
}
