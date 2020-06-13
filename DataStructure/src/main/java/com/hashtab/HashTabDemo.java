package com.hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        String key="";
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("add");
            System.out.println("list");
            System.out.println("search");
            System.out.println("exit");
            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id=scanner.nextInt();
                    System.out.println("输入名字");
                    String name=scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "search":
                    System.out.println("输入id");
                    id=scanner.nextInt();
                    hashTab.searchEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:break;
            }
        }
    }

}
