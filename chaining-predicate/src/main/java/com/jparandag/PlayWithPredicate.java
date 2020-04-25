package com.jparandag;

public class PlayWithPredicate {

    public static void main(String...args) {
        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = s -> !s.isEmpty();

        Predicate<String> p3 = p1.and(p2);

        System.out.println("Test for null :" + p3.test(null));
        System.out.println("Test for empty :" + p3.test(""));
        System.out.println("Test for non empty :" + p3.test("Hello Juan"));
    }
}
