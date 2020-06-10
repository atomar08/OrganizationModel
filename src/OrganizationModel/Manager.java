/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrganizationModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Magical Me
 */
public class Manager extends Employee {

    List<Manager> managerList = new ArrayList<>();
    Owner o;
    private Set<Worker> subOrdinatesWorkerList;
    private Map<Worker, Task> taskAssignedToworkerDic;
    private Set<Manager> colleaguesList;

    public Manager(String person_name, String phone_number, String designation) {
        super(person_name, phone_number, designation);
        this.subOrdinatesWorkerList = new HashSet<Worker>();
        this.colleaguesList = new HashSet<Manager>();
        this.taskAssignedToworkerDic = new HashMap<Worker, Task>();
    }

//    @Override
//    public void getOwnersMessage(String message) {
//        System.out.println("Manager name:" + this.getPerson_name() + "\nRecieved Message is : " + message);
//    }

    public Set<Worker> getSubOrdinatesWorkerList() {
        return subOrdinatesWorkerList;
    }

    public void addSubOrdinates(Worker subOrdinateWorker) {
        this.subOrdinatesWorkerList.add(subOrdinateWorker);
    }

    public Set<Manager> getColleaguesList() {
        return colleaguesList;
    }

    public void addColleagues(Manager colleague) {
        this.colleaguesList.add(colleague);
    }

    public Owner getOwner() {
        return o;
    }

    public void setOwner(Owner owner) {
        this.o = owner;
    }

    public boolean assignTask(Task _task, Worker _worker) {
//		checking worker reporting to this manager or not
        if (!subOrdinatesWorkerList.contains(_worker)) {
            System.out.println(_worker.getPerson_name() + " not assigned to manager " + this.getPerson_name()
                    + ". Assignment failed.");
            return false;
        }

//checking is task is already assigned to worker, if not then only assign new task other wise skip
        if (!taskAssignedToworkerDic.containsKey(_worker)) {
//only assign task to a worker if worker is not on vacation
            if (!_worker.isOnVacation()) {
                taskAssignedToworkerDic.put(_worker, _task);
                _worker.assignTask(_task);
                System.out.println("Task " + _task.getTaskId() + " assigned to worker " + _worker.getPerson_name());
                return true;
            }
        } else {
                System.out.println("Task " + _task.getTaskId() + " is already assigned to some other employee");
            }
            //return false;
        

        return false;
    }

    public void collectCompletedTask() {

    }

    public void evaluatePerformance() {
        int score = 0;
        String performance = null;
        Iterator<Worker> workerIterator = subOrdinatesWorkerList.iterator();
        while (workerIterator.hasNext()) {
            Worker worker = workerIterator.next();

            System.out.println("Evaluating performance of  Worker" + worker.getPerson_name());

            Scanner answers = new Scanner(System.in);

            System.out.println("Does the worker finish his work on time?");
            String time = answers.next();
            if (time.equalsIgnoreCase("yes")) {
                score += 1;
            }
            System.out.println("Does the worker produce 75% bug free and effecient code?");
            String work = answers.next();
            if (work.equalsIgnoreCase("yes")) {
                score += 1;
            }
            System.out.println("Is the worker an effecient team player?");
            String people = answers.next();
            if (people.equalsIgnoreCase("yes")) {
                score += 1;
            }
            System.out.println("Is the worker a quick learner");
            String learn = answers.next();
            if (people.equalsIgnoreCase("yes")) {
                score += 1;
            }
            System.out.println("Does the worker respect the secuirty aspects of the organization?");
            String security = answers.next();
            if (people.equalsIgnoreCase("yes")) {
                score += 1;
            }
            if (score == 1) {
                System.out.println("Performance status : Needs improvement ");
            } else if (score == 2) {
                System.out.println("Performance status : Average performance");
            } else if (score == 3) {
                System.out.println("Performance status : Good");
            }else if (score == 4) {
                System.out.println("Performance status : Exceeds Expectations");
            } else {
                System.out.println("Performance status : Excellent!");
            }
        }
    }

    public void updateSalary() {
            
    }
   }


class John {
    private final Manager delegateobj2;
    
     public John(Manager m) {
        
        this.delegateobj2 = m;
    }

    public void updateSalary(){
        Employee e= new Employee("","",""){} ;

//            @Override
//            public void getOwnersMessage(String message) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
        
        e.setSalary(500);
         System.out.println("Jack's Salary is increased by $" +e.getSalary());
        delegateobj2.updateSalary();
    }   
}


class Mary extends Manager{

    public Mary(String person_name, String phone_number, String designation) {
        super(person_name, phone_number, designation);
    }
    
    public void updateSalary(){
         Employee e= new Employee("","","") {}; 

//             @Override
//             public void getOwnersMessage(String message) {
//                 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//             }
         
        
         e.setSalary(1000);
         System.out.println("Greg's Salary is increased by $" +e.getSalary());
    }    
}