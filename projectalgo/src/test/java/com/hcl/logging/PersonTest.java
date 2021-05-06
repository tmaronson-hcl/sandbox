package com.hcl.logging;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.params.provider.Arguments.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class PersonTest {

    private Person p1 = null;
    private Person p2 = null;
    private Person p3 = null;
    private final Person p11 = p1;

    @BeforeEach
    void setUp() {
        p1 = new Person ("Joe", 160, "M", 72);
        p2 = new Person ("Joe", 160, "M", 72);
        p3 = new Person ("Josephine", 122, "F", 65);
    }

    // factory method for param. testing
    static List setUp2() {
        return Arrays.asList (new Person ("Joe", 160, "M", 72),
                new Person ("Josephine", 122, "F", 65));
    }

    // factory method showing Stream use
    static Stream<Arguments> checkPersonNames() {
        return Stream.of(
                arguments ("Bontieluka", "Reptilicus", "Monteclaro"),
                arguments ("Bontielukabun", "Olersoner", "Trachisto"),
                arguments ("Rempartoner", "Trainorvista", "Packertechno")
        );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetName() {
        assertEquals (p1.getName (), p2.getName ());
    }

    @Test
    void testEqualsPersons() {
        assertEquals (p1, p2);
    }

    @Test
    void testNotEqualsPersons() {
        assertNotEquals (p1, p3);
    }

    @Test
    void testFigureInfo() {
        // write laters
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 33, 67, 899})
    void testParamTestingInts(int args) {
        assertTrue(args % 2 == 1);
    }

    /* compiles and runs but doesn't make sense - test will fail
    @ParameterizedTest
    @ValueSource(classes = {Person.class})
    void someTest(Person args) {
        assertNotNull (args);
    } */

    @ParameterizedTest
    @MethodSource("setUp2") // factory method
    void testParamTestingObjectsTest(Person args) {
        assertNotNull (args);
    }

    @ParameterizedTest(name="#index")
    @MethodSource("checkPersonNames")  // factory method
    void testPersonNamesForMaxLength(String str1, String str2, String str3) {
        assertTrue(str1.length () < 20);
        assertTrue(str2.length () < 20);
        assertTrue(str3.length () < 20);
    }


    @Test
    void testWeightLessThanZeroException() {
        NumberFormatException nfe = assertThrows (NumberFormatException.class,
                () -> new Person("Joe Gilly", -188, "M", 72));
    }

    @Test
    void testHeightLessThanZeroException() {
        NumberFormatException nfe = assertThrows (NumberFormatException.class,
                () -> new Person("Joe Gilly", 188, "M", -72));
    }
}