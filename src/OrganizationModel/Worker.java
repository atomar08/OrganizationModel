/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrganizationModel;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Magical Me
 */
public class Worker extends Employee{
        private List<Task> taskCompleted;
	private List<Worker> colleagues;
	private List<Task> taskAssignedList;
        private Set<Worker> vacationWorkerList;

    public Worker(String person_name, String phone_number, String designation) {
        super(person_name, phone_number, designation);
        this. taskAssignedList = new LinkedList<Task>();
        this.vacationWorkerList = new HashSet<Worker>();

    }
    
    
    
   public List<Task> getDoneTask() 
	{
		return taskCompleted;
	}

	public void addDoneTask(Task taskDone) 
	{
		this.taskCompleted.add(taskDone);
	}

	public List<Worker> getColleagues() {
		return colleagues;
	}

	public void setColleagues(List<Worker> colleagues) {
		this.colleagues = colleagues;
	}

	public List<Task> getAssignedTaskList() {
		return taskAssignedList;
	}

	public void assignTask(Task _task) {
		this.taskAssignedList.add(_task);
	}
        
        public void addWorkerOnVacationList(Worker workerOnLeave) {
		this.vacationWorkerList.add(workerOnLeave);
	}
                                
        public Set<Worker> getVWorkerList() {
		return vacationWorkerList;
	}


        public boolean isOnVacation(Worker _worker)
	{
//		checking worker is on vacation or not
		if(vacationWorkerList.contains(_worker))
		{
			System.out.println(_worker.getPerson_name() + " is on vacation "+vacationWorkerList );
			return true;
		}
                
                else
		{
			//System.out.println("Task assignemnt failed");
			
			return false;
		}
                
        }

                                   
	
	public void work()
	{
		
	}
                            
		
	public void getTasksDone()
	{
		
	}

//	@Override
//	public void getOwnersMessage(String message) {
//		System.out.println("Worker " + this.getPerson_name()+ " received message: " + message);
//	}	

//	helper method to return all task assigned to worker as string, just to printing
	public String taskToString() 
	{
		String taskAssigned = "";
		for(Task assignedTask: this.getAssignedTaskList())
			taskAssigned = taskAssigned + assignedTask.getTaskId();
		return taskAssigned;
	}
    
}


class Greg {

    private final Worker delegateobj;
    
     public Greg(Worker w) {
        
        this.delegateobj = w ;
    }

    public void work(){
        System.out.println(" Tasks assigned to Greg : Greg's t5 task.");
        delegateobj.work();
    }  
}


class Amy extends Worker{

    public Amy(String person_name, String phone_number, String designation) {
        super(person_name, phone_number, designation);
    }


    
    @Override
    public void work(){
        System.out.println("Tasks assigned to Amy: Amy's task t3");
    }
    
}
