package com.hcl.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.function.Predicate;

public class Person<T> {


    private String name;
    private int weight;
    private String sex;
    private int height;
    //public static Logger logger = Logger.getLogger (Person.class);
    public static Logger logger = LogManager.getLogger (Person.class);

    public Person(String name, int weight, String sex, int height) {
        this.name = name;
        setWeight (weight);
        this.sex = sex;
        setHeight(height);
    }

    public Person() {
        this("", 0, "", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if(weight <= 0) {
            throw new NumberFormatException ("Weight must be positive.");
        }
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height<= 0) {
            throw new NumberFormatException ("Height must be positive.");
        }
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name = " + name +
                ", weight = " + weight +
                ", sex = '" + sex + '\'' +
                ", height = " + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return weight == person.weight &&
                height == person.height &&
                name.equals (person.name) &&
                sex.equals (person.sex);
    }

    @Override
    public int hashCode() {

        return Objects.hash (name, weight, sex, height);
    }

    public static void main(String[] args) {

        Person p1 = new Person ("Joe", 160, "M", 72);
        Person p2 = new Person ("Joe", 160, "M", 72);
        Person p3 = new Person ("Josephine", 122, "F", 65);
        System.out.printf ("Values for p1, p2, p3: %s, %s, %s\n", p1, p2, p3);
        Predicate<Person> personPredicate = x -> x.getWeight () > 150;
        boolean test = personPredicate.test (p1);
        // Try method now.
        figureInfo (p1, personPredicate);
        //System.out.println (test);
        logger.debug ("Debug values for p1, p2, p3: " + p1 + p2 + p3);
        logger.warn ("Values for p1, p2, p3: " + p1 + p2 + p3);
        logger.warn (test);

        // Access generic form - can use any class.
        new Person("Bob", 225, "M", 78).figureInfo2 (p1, personPredicate);

    }

    public static void figureInfo(Person person, Predicate<Person> p) {

        //System.out.println (p.test (person));
    }

    public void figureInfo2(T obj, Predicate<T> p) {

        //System.out.println (p.test (obj));
    }

}

