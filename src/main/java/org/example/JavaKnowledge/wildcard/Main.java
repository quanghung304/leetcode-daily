package org.example.JavaKnowledge.wildcard;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> lstPerson = new ArrayList< >();
        lstPerson.add(new Student("Nam", 21, "Thai Nguyen"));
        lstPerson.add(new Teacher("Trung", 40, "Ha Noi"));
        findMaxAge(lstPerson);

        List<Student> lstStudent = new ArrayList<>();
        lstStudent.add(new Student("Nam", 21, "Thai Nguyen"));
        lstStudent.add(new Student("Mai", 20, "Nam Dinh"));
//        findMaxAge(lstStudent); Error
        findMaxAgeWildCard(lstStudent); // OK

        List<Teacher> lstTeacher = new ArrayList<>();
        lstTeacher.add(new Teacher("Trung", 40, "Ha Noi"));
        lstTeacher.add(new Teacher("Thanh", 35, "Ha Noi"));
//        findMaxAge(lstTeacher); Error
        findMaxAgeWildCard(lstTeacher); // OK

        lstPerson = new ArrayList<>(lstStudent);
        lstPerson.addAll(lstTeacher);
        findMaxAge(lstPerson);

        checkTeacher(lstTeacher);
        checkTeacher(lstPerson);
//        checkTeacher(lstStudent); Error
    }

    // co the truyen 1 doi tuong cua lop Student hoac Teacher vao method nay
    public static void showInfor(Person p) {
        System.out.println(String.format("%s, %d years old, from %s", p.name, p.age, p.address));
        p.say();
        System.out.println("\n");
    }

    //ham findMaxAge truyen vao List<Person> tuy nhien ko truyen dc List<Student> hay List<Teacher> vao vi loi sai kieu
    //ko phai luc nao cung co the tao 1 list Person tu cac instance cua lop Student và Teacher de xu ly cho cac method dung chung
    public static void findMaxAge(List <Person> lstPerson) {
        Person maxAge = null;
        for (Person p: lstPerson) {
            if (maxAge == null || maxAge.age < p.age) {
                maxAge = p;
            }
        }
        if (maxAge != null) {
            System.out.println("Normal way: ");
            showInfor(maxAge);
        }
    }

    //ky thuat wildcard: giup ta co the truyen 1 collection cua lop con vao collection lap cha (giong nhu method showInfor())
    // ? extends Person means: any class that extend class Person
    public static void findMaxAgeWildCard(List<? extends Person> lstPerson){
        Person maxAge = null;
        for (Person p: lstPerson) {
            if (maxAge == null || maxAge.age < p.age) {
                maxAge = p;
            }
        }
        if (maxAge != null) {
            System.out.println("Wildcard way: ");
            showInfor(maxAge);
        }
    }

    //? super Teacher means: the super class of class Teacher
    public static void checkTeacher(List<? super Teacher> lstTeacher){
        System.out.println("They 're teacher");
    }
}