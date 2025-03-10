package fr.ensai.library;

public class Person {

    // Attributes
    protected String name;
    private int age;

    /**
     * Constructs a new Person object.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
