package model.dao;

import model.entity.Subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectDAO extends BaseDAO {

    public SubjectDAO() throws SQLException {
        connection = connectionPool.getConnection();
    }

    public ArrayList<Subject> findAll(String name, String surname, String group) {
        ArrayList<Subject> subjects = new ArrayList<>();
        String findAllSubjects = "select * from subject  where subject_id in(select gs.subject_id " +
                "from group_subject gs where group_id in" +
                "(select group_id from students where group_id in" +
                "(select group_id from groups g where g.name = ?) and name = ? and surname = ?))";

        try (PreparedStatement ps = connection.prepareStatement(findAllSubjects)) {
            ps.setString(1, group);
            ps.setString(2, name);
            ps.setString(3, surname);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    subjects.add(new Subject(
                            resultSet.getString("name"),
                            resultSet.getString("href"),
                            resultSet.getString("image"),
                            resultSet.getString("alt_name")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
    }

    public Subject findEntityByName(String name) throws SQLException {
        Subject subject = null;
        String findSubject = "select * from subject where name=?";
        try (PreparedStatement ps = connection.prepareStatement(findSubject)) {
            ps.setString(1, name);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    subject = new Subject(
                            resultSet.getInt("subject_id"),
                            resultSet.getString("name"),
                            resultSet.getString("href"),
                            resultSet.getString("image"),
                            resultSet.getString("alt_name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;
    }


}
