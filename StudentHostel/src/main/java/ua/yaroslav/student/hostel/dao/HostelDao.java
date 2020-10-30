package ua.yaroslav.student.hostel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.yaroslav.student.hostel.dao.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class HostelDao {

    @Autowired
    JdbcTemplate template;


    public int save(Student h) {
        String sql = "INSERT INTO HostelData(firstName, secondName, roomNumber, faculty) " +
                "VALUES ('"+h.getFirstName()+"', '"+h.getSecondName()+"', '"+h.getRoomNumber()+"', '"+h.getFaculty()+"')";
        return template.update(sql);
    }
    public int saveDate(Student h){
        String sql = "INSERT INTO HostelData(birthday) VALUES ('"+ h.getLocalDateTime() + "');";
        return template.update(sql);
    }

    public int update(Student h) {
        String sql = "UPDATE HostelData SET FirstName = '"+h.getFirstName()+"', SecondName= '"+h.getSecondName()+"', RoomNumber= '"+h.getRoomNumber()+"', Faculty= '"+h.getFaculty()+"', Birthday= '"+h.getBirthday()+"' WHERE id='"+h.getId()+"'";
        return template.update(sql);
    }
    public int delete(int id){
        String sql = "DELETE FROM HostelData WHERE id="+id+"";
        return template.update(sql);
    }
    public Student getHostelById(int id){
        String sql = "SELECT * FROM HostelData WHERE id= ?";
        return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Student>(Student.class));
    }
    public List<Student> getStudents() {

        return template.query("SELECT * FROM HostelData", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setFirstName(resultSet.getString(2));
                student.setSecondName(resultSet.getString(3));
                student.setRoomNumber(resultSet.getInt(4));
                student.setFaculty(resultSet.getString(5));
                student.setBirthday(resultSet.getString(6));
                return student;
            }
        });
    }
}
