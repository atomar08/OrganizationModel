/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrganizationModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Magical Me
 */
public class WorkingOrganization {
    public static void main(String args[]){
        
        Scanner input=new Scanner(System.in);
        
        System.out.println("Enter company name:");
        String company_name=input.nextLine();
        System.out.println("Enter company location:");
        String company_address=input.nextLine();
        
        Company company=new Company(company_name, company_address);
        
        List<Manager> ownersListOfManagers=new ArrayList<>();
        List<Worker> ownersListOfWorkers=new ArrayList<>();
        
        Owner owner = new Owner("Craig", " +1 8587676509",company);
        
        Manager m1=new Manager("John","9876512345","Manager");
        Manager m2 = new Manager("Mary","9876512445","Manager");
        

        Worker w1=new Worker("Jack", "+1 7876564545","Worker");
        Worker w2 = new Worker( "Katie", " +1 858 2341312","Worker");
        Worker w3 = new Worker( "Amy", " +1 858 2351322","Worker");
        Worker w4 = new Worker( "Jim", " +1 858 2361332","Worker");
        Worker w5 = new Worker( "Greg", " +1 858 2371389","Worker");
        
        ownersListOfWorkers.add(w1);
        ownersListOfWorkers.add(w2);
        ownersListOfWorkers.add(w3);
        ownersListOfWorkers.add(w4);
        ownersListOfWorkers.add(w5);
        
        owner.setWorkerList(ownersListOfWorkers);
        List<Employee> empList= new ArrayList<>();
        empList.addAll(ownersListOfManagers);
        empList.addAll(ownersListOfWorkers);
       
        m1.setOwner(owner);
        m1.addSubOrdinates(w1);
        m1.addSubOrdinates(w4);
        
        m2.setOwner(owner);
        m2.addSubOrdinates(w2);
        m2.addSubOrdinates(w3);
        m2.addSubOrdinates(w5);
        
       ownersListOfManagers.add(m1);
       ownersListOfManagers.add(m2);
       owner.setManagerList(ownersListOfManagers);
       
       Task task1 = new Task("t1", "Task1");
       Task task2 = new Task("t2", "Task2");
       Task task3 = new Task("t3", "Task3");
       Task task4 = new Task("t4", "Task4");
       Task task5 = new Task("t5", "Task5");
        
       
        
        
        System.out.println("Do you want to take a look at our task assignment?");
        String tasks=input.next();
        if(tasks.equalsIgnoreCase("yes")){
            if(m1.assignTask(task1, w1))
            System.out.println("Worker " + w1.getPerson_name()+ ", is working on task " + w1.taskToString() + " assigned");
        if(m2.assignTask(task2, w1))
            System.out.println("Worker " + w1.getPerson_name()+ ", is working on task " + w1.taskToString() + " assigned");
        if(m1.assignTask(task4, w4))
            System.out.println("Worker " + w4.getPerson_name()+ ", is working on task " + w4.taskToString() + " assigned");
        if(m2.assignTask(task2, w2)) 
            System.out.println("Worker " + w2.getPerson_name()+ ", is working on task " + w2.taskToString() + " assigned");
        if(m2.assignTask(task3, w3))
            System.out.println("Worker " + w3.getPerson_name()+ ", is working on task " + w3.taskToString() + " assigned");
       if(m2.assignTask(task5, w5))
           System.out.println("Worker " + w5.getPerson_name()+ ", is working on task " + w5.taskToString() + " assigned");
       if(m2.assignTask(task3, w5))
           System.out.println("Worker " + w5.getPerson_name()+ ", is working on task " + w5.taskToString() + " assigned");
        }
              
        System.out.println("Choose mode number : 1. Owner 2. Manager 3. Worker");
        int mode= input.nextInt();
        switch(mode){
            case 1:
        {
            try {
                owner.announceNews(empList);
            } catch (IOException ex) {
                Logger.getLogger(WorkingOrganization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                System.out.println("Do you wish to evaluate managers?") ;
                String evl_managers=input.next();
                if(evl_managers.equalsIgnoreCase("yes")){
                     System.out.println("\n\nEvaluating performance of Managers:");
                     owner.evaluatePerformance();
                }
                else{
                break;
                }
        
                break;
            case 2:
                System.out.println("Do you wish to evaluate workers?") ;
                String evl_workers=input.next();
                if(evl_workers.equalsIgnoreCase("yes")){
                        System.out.println("\n\nEvaluating performance of workers...");
                        System.out.println("Manager is:" + m1.getPerson_name());
                        m1.evaluatePerformance();
         
                        System.out.println("Manager is:" + m2.getPerson_name());
                        m2.evaluatePerformance();
                }
                        System.out.println("Manager job delegation....");
                        John johnObj = new John (new Mary("","",""));
                        johnObj.updateSalary();
        
                break;
            case 3:
                
                System.out.println("Employee object delegation....");
                Greg gregObj = new Greg(new Amy("","",""));
                gregObj.work();
                break;
        }
        
    }
}
                
        
               
        
        
        
        
        
    
 
    

