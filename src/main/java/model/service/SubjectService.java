package model.service;

import model.dao.SubjectDAO;
import model.entity.Student;
import model.entity.Subject;
import model.entity.SubjectList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectService {

    public SubjectList getSubject(Student student) {
        SubjectDAO dao = null;
        SubjectList subjects = null;
        try {
            dao = new SubjectDAO();
            ArrayList<Subject> subj = dao.findAll(student.getName(),student.getSurname(),student.getGroup());
            subjects = new SubjectList(student.getName(), student.getSurname(), subj);
            dao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subjects;
    }
}
