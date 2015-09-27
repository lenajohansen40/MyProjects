package com.classes;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class StudentJDBCTemplate implements StudentDAO {
   private DataSource dataSource;
   private SimpleJdbcCall jdbcCall;

   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcCall =  new SimpleJdbcCall(dataSource).
                       withProcedureName("getRecord");
   }

   public void create(Integer id,String name, Integer age) {
      JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
      String SQL = "insert into Student (id,name, age) values (?, ?,?)";

      jdbcTemplateObject.update( SQL,id, name, age);
      System.out.println("Created Record Id="+id+" Name = " + name + " Age = " + age);
      return;
   }

   public Student getStudent(Integer id) {
      SqlParameterSource in = new MapSqlParameterSource().
                              addValue("in_id", id);
      Map<String, Object> out = jdbcCall.execute(in);

      Student student = new Student();
      student.setId(id);
      student.setName((String) out.get("OUT_NAME"));
      student.setAge(new BigDecimal(out.get("OUT_AGE").toString()).intValue());

      return student;
   }

   public List<Student> listStudents() {
	  JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
      String SQL = "select * from Student";
      
      List <Student> students = jdbcTemplateObject.query(SQL, 
                                      new StudentMapper());
      return students;
   }

}
