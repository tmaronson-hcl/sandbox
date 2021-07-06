package com.hcl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class WidgetDriver {

    public static void main(String[] args) {
        new WidgetDriver ().show();
    }

    private void show() {

        Widgets w1 = new Widgets (Colors.RED, 122);
        Widgets w2 = new Widgets (Colors.BLUE, 12);
        Widgets w3 = new Widgets (Colors.PINK, 223);
        Widgets w4 = new Widgets (Colors.RED, 90);
        Collection<Widgets> widgets =
                new ArrayList<> (Arrays.asList (w1, w2, w3, w4));
        int sum = widgets.stream()
                // filter takes Predicate so lambda is fine and test method is boolean
                .filter(w -> w.getColor() == Colors.RED)   // w is type Widgets
                //mapToInt takes func. interface ToIntFunction with method int applyAsInt(T value)
                .mapToInt(w -> w.getWeight())
                .sum();
        System.out.printf ("Total weight of REDs is %d", sum);
    }
}
