package com.example.springJDBC.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.Spring;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.springJDBC.Model.Student;
@Repository
public class StudentRepository {
	@Autowired
  private JdbcTemplate template;
	public void save(Student s) {
		String query="insert into student values(?,?,?)";
		template.update(query,s.getRollno(),s.getName(),s.getMarks());
		
		
		
	}
	public List<Student> findAll() {
        String sql="select * from student";
        RowMapper<Student> mapper=new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s=new Student();
                s.setRollno(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
            }
        };
        return template.query(sql,mapper);
    }

}
