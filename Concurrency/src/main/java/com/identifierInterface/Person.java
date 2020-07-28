package com.identifierInterface;

import java.io.*;

class Person implements Serializable {

    public int getAge() {
        return age;
        
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int age;
    private String name;

}
class PersonTest {
    private static void SerializePerson() throws IOException {
        Person person = new Person();
        person.setAge(11);
        person.setName("xx");
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("o.txt")));
        oo.writeObject(person);
        System.out.println("person对象序列化成功！");
        oo.close();
    }
    private static Person DeserializePerson() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("o.txt")));
        Person person = (Person) ois.readObject();
        System.out.println("person反序列化成功！");
        return person;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializePerson();
        Person p = DeserializePerson();
        System.out.println(p.getName());
    }

}
