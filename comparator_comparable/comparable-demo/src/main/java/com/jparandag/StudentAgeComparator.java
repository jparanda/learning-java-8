package com.jparandag;

import java.util.Comparator;

public class StudentAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student firstStudent, Student secondStudent) {
        return (firstStudent.getAge()-secondStudent.getAge());
    }
}
