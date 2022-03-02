package com.hcl;

import java.util.ArrayList;
import java.util.List;

public class StackFromList<T> {

    private List<T> list = new ArrayList<> ();

    void push(T element) {

        list.add (0, element);
    }

    T pop() {
        T element = list.get (0);
        list.remove (0);
        return element;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "list=" + list +
                '}';
    }

    public static void main(String[] args) {
        StackFromList<Integer> stack = new StackFromList<> ();
        stack.push (1);
        stack.push (2);
        stack.push (345);
        stack.push (56);
        System.out.println (stack);
        stack.pop ();
        System.out.println (stack);
        Person p1 = new Person ("Joe", 160, "M", 72);
        Person p2 = new Person ("Joetta", 120, "F", 62);
        StackFromList<Person> stackP = new StackFromList<> ();
        stackP.push (p1);
        stackP.push (p2);
        System.out.println (stackP);
        stackP.pop ();
        System.out.println (stackP);

    }


}
