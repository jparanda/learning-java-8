package com.jparandag.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PredicateTest {

    private List<Person> persons;

    public static void main(String[] args) {
        PredicateTest test = new PredicateTest();
        test.buildPersonsList();
        List<Person> resultForeach = test.getAdultMalesUsingForeach();
        List<Person> resultWithoutPredicate = test.getAdultMales();
        List<Person> resultWithPredicate = test.getAdultMalesUsingPredicate();
        System.out.println("Printing list from Foreach processing");
        test.printList(resultForeach);
        System.out.println("Printing list Without Predicate processing");
        test.printList(resultWithoutPredicate);
        System.out.println("Printing list with Predicate processing");
        test.printList(resultWithPredicate);
    }

    public List<Person> getAdultMalesUsingForeach(){
        List<Person> result = new ArrayList<>();
        for (Person person : this.persons) {
            if(person.getAge() >= 18 && person.getSex()== SexEnum.MALE.toString()){
                result.add(person);
            }
        }
        return result;
    }

    /**
     * This method doesn't use a Predicate Class
     * @return
     */
    private List<Person> getAdultMales(){
        return persons.stream()
                .filter(person ->
                person.getAge() >= 18
                        && person.getSex() == SexEnum.MALE.toString())
                .collect(Collectors.toList());
    }

    /**
     * This method use the PersonPredicate to filter data
     * @return
     */
    private List<Person> getAdultMalesUsingPredicate(){
        return persons.stream()
                .filter(PersonPredicate.isAdultMale())
                .collect(Collectors.toList());
    }

    private void buildPersonsList(){
        persons = new ArrayList<>();
        persons.add(new Person(22, SexEnum.FEMALE.toString()));
        persons.add(new Person(18, SexEnum.MALE.toString()));
        persons.add(new Person(16, SexEnum.MALE.toString()));
        persons.add(new Person(17, SexEnum.FEMALE.toString()));
        persons.add(new Person(20, SexEnum.MALE.toString()));
        persons.add(new Person(32, SexEnum.FEMALE.toString()));
    }

    private void printList(List<Person> list){
        list.forEach(person ->
                System.out.println("Age :" + person.getAge() +" Sex :" + person.getSex()));
    }
}
