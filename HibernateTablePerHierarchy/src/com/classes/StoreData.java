package com.classes;
import org.hibernate.*;  
import org.hibernate.cfg.*; 
import org.hibernate.cfg.AnnotationConfiguration;
  
public class StoreData {  
public static void main(String[] args) {  
AnnotationConfiguration cfg=new AnnotationConfiguration();  
Session session=cfg.configure("hibernate.cfg.xml").buildSessionFactory().openSession();  
      
    Transaction t=session.beginTransaction();  
      
    Employee e1=new Employee();  
    e1.setName("sonoo");  
      
    RegularEmployee e2=new RegularEmployee();  
    e2.setName("Vivek Kumar");  
    e2.setSalary(50000);  
    e2.setBonus(5);  
      
    ContractEmployee e3=new ContractEmployee();  
    e3.setName("Arjun Kumar");  
    e3.setPay_per_hour(1000);  
    e3.setContract_duration("15 hours");  
      
    session.persist(e1);  
    session.persist(e2);  
    session.persist(e3);  
      
    t.commit();  
    session.close();  
    System.out.println("success");  
}  
} 
