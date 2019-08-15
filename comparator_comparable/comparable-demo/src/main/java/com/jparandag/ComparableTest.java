package com.jparandag;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
        //sortCollectionUsingComparator(students);

        //Using Java 8 features
        //sortCollectionUsingJava8(students);

        //Using Key Selector
        //sortUsingKeySelectorAndComparatorVariant(students);

        //Using reversed
        //sortUsingComparatorReversed(students);

        //Using Comparing Int
        sortUsingComparingInt(students);


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

    private static void sortCollectionUsingJava8(List<Student> students){
        System.out.println("Before Sorting : " + students);
        Comparator<Student> studentNameComparator
                = Comparator.comparing(Student::getName);
        Collections.sort(students, studentNameComparator);
        System.out.println("After Sorting by Name : " + students);

    }

    private static void sortUsingKeySelectorAndComparatorVariant(List<Student> students){
        System.out.println("Before Sorting : " + students);
        Comparator<Student> studentNameComparator =
                Comparator.comparing( Student::getName, (s1, s2) -> { return s2.compareTo(s1); });
        Collections.sort(students, studentNameComparator);
        System.out.println("After Desc Sorting by Name : " + students);
    }

    private static void sortUsingComparatorReversed(List<Student> students){
        System.out.println("Before Sorting : " + students);
        Comparator<Student> studentNameComparator = Comparator.comparing(Student::getName);
        Collections.sort(students, studentNameComparator);
        System.out.println("After Asc Sorting by Name : " + students);
        Comparator<Student> studentNameReversedComparator = studentNameComparator.reversed();
        Collections.sort(students, studentNameReversedComparator);
        System.out.println("After reversed Sorting by Name : " + students);
    }

    private static void sortUsingComparingInt(List<Student> students){
        System.out.println("Before Sorting : " + students);
        Comparator<Student> ageComparator = Comparator.comparing(Student::getAge);
        Collections.sort(students, ageComparator);
        System.out.println("After Sorting by Age : " + students);

    }
}
