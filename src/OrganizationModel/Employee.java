/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrganizationModel;

/**
 *
 * @author Magical Me
 */
public abstract class Employee extends People {
    private int performanceScale;
    private int salary;
    private String designation;
    private boolean isOnVacation;
    private People employeeInfo;

    public Employee(String person_name, String phone_number, String designation) {
        super(person_name, phone_number);
        this.designation=designation;
        this.performanceScale = 0;
        this.salary = 0;
        isOnVacation = false;
    }
       
 //  public abstract void getOwnersMessage(String message);
   
   public int getPerformanceScale() {
		return performanceScale;
	}

	public void setPerformanceScale(int performanceScale) {
		this.performanceScale = performanceScale;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public People getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(People employeeInfo) {
		this.employeeInfo = employeeInfo;
	}
	
	public boolean isOnVacation()
	{
		return this.isOnVacation;
	}
}
