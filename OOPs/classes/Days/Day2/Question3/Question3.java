package classes.Days.Day2.Question3;

import classes.Days.Day2.Question3.Classes.Employee;
import classes.Days.Day2.Question3.Classes.Manager;
import interfaces.Start;

public class Question3 implements Start{
	public void start() {
		Employee employee = new Employee();
		employee.setName("Ashu Singh");
		employee.setAge(22);
		employee.setPhoneNumber("1234567890");
		employee.setAddress("Sapiens technologies, Bengaluru");
		employee.setSalary(50000);
		employee.setSpecialization("Java Developer");
		
		Manager manager = new Manager();
		manager.setName("Krishan yadav");
		manager.setAge(30);
		manager.setPhoneNumber("9087654321");
		manager.setAddress("Sapiens technologies, Banglore");
		manager.setSalary(100000);
		manager.setDepartment("L&P");
		
		System.out.println("Employee Details: ");
		System.out.println(employee.getName());
		System.out.println(employee.getAge());
		System.out.println(employee.getPhoneNumber());
		System.out.println(employee.getAddress());
		System.out.println(employee.getSalary());
		System.out.println(employee.getSpecialization()+"\n");
		System.out.println("Manager Details: ");
		System.out.println(manager.getName());
		System.out.println(manager.getAge());
		System.out.println(manager.getPhoneNumber());
		System.out.println(manager.getAddress());
		System.out.println(manager.getSalary());
		System.out.println(manager.getDepartment());
	}

}
