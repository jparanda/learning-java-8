package com.jparandag;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student implements Comparable<Student>{

    private int ranking;
    private String name;
    private int age;

    @Override
    public int compareTo(Student otherPlayer) {
        return (this.getRanking()-otherPlayer.getRanking());
    }
}
