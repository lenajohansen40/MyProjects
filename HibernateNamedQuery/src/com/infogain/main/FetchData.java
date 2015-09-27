package com.infogain.main;

import java.util.Iterator;  
import java.util.List;  
  
import oracle.net.aso.e;

import org.hibernate.cfg.AnnotationConfiguration;  
import org.hibernate.*;  

import com.infogain.Employee;
  
public class FetchData {  
 public static void main(String[] args) {  
  
  AnnotationConfiguration configuration=new AnnotationConfiguration();  
   configuration.configure("hibernate.cfg.xml");  
   SessionFactory sFactory=configuration.buildSessionFactory();  
    Session session=sFactory.openSession();  
    Transaction transaction=session.beginTransaction();
    Employee emp=new Employee();
    emp.setId(0);
    emp.setName("udit");
    emp.setSalary(1000);
    emp.setJob("P");
    session.persist(emp);
    transaction.commit();
    
    //Hibernate Named Query  
    Query query = session.getNamedQuery("findEmployeeByName");  
    query.setString("name", "udit");  
          
    List<Employee> employees=query.list();  
          
    Iterator<Employee> itr=employees.iterator();  
     while(itr.hasNext()){  
    Employee e=itr.next();  
    System.out.println(e);  
     }  
          
    session.close();  
      
  }  
}  
