package com.lucas;

public class Student {
    private int no;
    private String name;
    private School school;

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", school=" + school +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Student(int no, String name, School school) {
        this.no = no;
        this.name = name;
        this.school = school;
    }

    public Student() {
    }
}
