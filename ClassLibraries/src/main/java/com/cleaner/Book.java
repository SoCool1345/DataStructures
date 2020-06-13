package com.cleaner;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book implements Runnable{
    public Book(){
        System.out.println("aaaa");
    }
    //传统析构
    @Override
    protected void finalize() throws Throwable {
        System.out.println("final");
        throw new Exception("useful");
    }

    @Override
    public void run() {
        System.out.println("run:final");
    }

    public void read() {
        System.out.println("ooo");
    }
}
class BookCleaner implements AutoCloseable{
    private static final Cleaner cleaner=Cleaner.create();
    private Cleaner.Cleanable cleanable;

    public BookCleaner(Book book) {
        this.cleanable = cleaner.register(this,book);
    }


    @Override 
    public void close() throws Exception {
        this.cleanable.clean();

    }
}
class demo{
    public static void main(String[] args) {
        Book book=new Book();
        try (BookCleaner bc=new BookCleaner(book)){
           book.read();
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }
}
