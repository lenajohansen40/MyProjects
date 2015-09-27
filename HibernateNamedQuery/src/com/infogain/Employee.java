package com.infogain;
import javax.persistence.*;  
  
@NamedQueries(  
    {  
        @NamedQuery(  
        name = "findEmployeeByName",  
        query = "from Employee e where e.name = :name"  
        )  
    }  
)  
  
@Entity  
@Table(name="employee")  
public class Employee {  
      
    public String toString(){return id+" "+name+" "+salary+" "+job;}  
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)   
    int id;  
    
    @Column(name="name") 
    String name; 
    @Column(name="salary") 
    int salary; 
    @Column(name="job") 
    String job;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}  
    
    
       
   
}  