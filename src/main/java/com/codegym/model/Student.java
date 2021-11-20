package com.codegym.model;

public class Student {
    private int sId;
    private String fullName;
    private String className;

    public Student() {
    }

    public Student(int sId, String fullName, String className) {
        this.sId = sId;
        this.fullName = fullName;
        this.className = className;
    }

    public Student(String fullName, String className) {
        this.fullName = fullName;
        this.className = className;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
