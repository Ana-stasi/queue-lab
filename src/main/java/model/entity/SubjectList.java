package model.entity;

import java.util.ArrayList;

public class SubjectList {
    private String firstName;
    //todo убрать lastname
    private  String lastName;
    private ArrayList<Subject> subjects;

    public SubjectList(String name,String surname, ArrayList<Subject> subjects) {
        this.firstName = name;
        this.lastName = surname;
        this.subjects = subjects;
    }

    public String getName() {
        return firstName;
    }

    public String getSurname() {
        return lastName;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }


    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return firstName+ " "+ lastName+" "+ subjects;
    }
}
