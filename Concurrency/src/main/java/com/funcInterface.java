package com;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class funcInterface {
    public static void main(String[] args) {
        //函数式接口
        Function<String,String> function=(s)->{return s;};
        System.out.println(function.apply("a"));
        //断定型接口，一个输入参数，返回值是布尔值
        Predicate<String> predicate=(o)->{return false;};
        predicate.test("");
        //消费型接口，只有输入，没有返回值
        Consumer<String> consumer=(s)->{
            System.out.println(s);
        };
        String a="abc";
        String b="aqp";
        System.out.println(a.compareTo(b));
        consumer.accept("aaa");
        //供给型接口，没有输入，只有返回值
        Supplier supplier=()->{return 1024;};
        System.out.println(supplier.get());
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
    }


}
