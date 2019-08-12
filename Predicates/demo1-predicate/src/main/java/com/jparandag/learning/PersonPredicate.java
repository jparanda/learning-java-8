package com.jparandag.learning;


import java.util.function.Predicate;

public class PersonPredicate {

    public static Predicate<Person> isAdultMale(){
        return p ->
                p.getAge() >= 18 &&
                        p.getSex() == SexEnum.MALE.toString();
    }
}
