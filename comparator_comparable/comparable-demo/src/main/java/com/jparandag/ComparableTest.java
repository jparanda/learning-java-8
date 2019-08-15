package com.jparandag;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class ComparableTest
{
    public static void main( String[] args ) {
        List<Student> students = ComparableTest.buildAndReturnStudents();
        //Using Comparable interface
        //sortCollectionUsingSortMethod(students);

        //Using Comparator Interface
        sortCollectionUsingComparator(students);


    }

    private static List<Student> buildAndReturnStudents(){
        Student student1 = Student.builder()
                .name("Juan Pablo")
                .ranking(22)
                .age(37)
                .build();

        Student student2 = Student.builder()
                .name("Cristina")
                .ranking(59)
                .age(39)
                .build();

        Student student3 = Student.builder()
                .name("Catalina")
                .age(8)
                .ranking(45)
                .build();

        Student student4 = Student.builder()
                .name("Daniel")
                .age(9)
                .ranking(67)
                .build();

        return Arrays.asList(student1, student2, student3, student4);

    }

    private static void sortCollectionUsingSortMethod(List<Student> students){
        System.out.println("Before Sorting : " + students);
        Collections.sort(students);
        System.out.println("After Sorting : " + students);
    }

    private static void sortCollectionUsingComparator(List<Student> students){
        StudentRankingComparator rankingComparator = new StudentRankingComparator();
        System.out.println("Before Sorting : " + students);
        Collections.sort(students, rankingComparator);
        System.out.println("After Sorting by Ranking : " + students);

        StudentAgeComparator ageComparator = new StudentAgeComparator();
        System.out.println("Before Sorting : " + students);
        Collections.sort(students, ageComparator);
        System.out.println("After Sorting by Age : " + students);

    }
}
