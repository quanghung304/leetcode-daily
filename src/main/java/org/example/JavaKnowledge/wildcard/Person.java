package org.example.JavaKnowledge.wildcard;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Person {
    public String name;
    public int age;
    public String address;

    public abstract void say();
}
