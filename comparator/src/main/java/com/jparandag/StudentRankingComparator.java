package com.jparandag;

import java.util.Comparator;

public class StudentRankingComparator implements Comparator<Student> {

    @Override
    public int compare(Student firstStudent, Student secondStudent) {
        return (firstStudent.getRanking()-secondStudent.getRanking());
    }
}
