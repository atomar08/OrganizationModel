/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrganizationModel;


import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Magical Me
 */
public class Owner extends People {
    
    List<Company> companies;
    List<Employee> employeeList=new ArrayList<>();
    List<Manager> managerList;

    public List<Manager> getManagerList() {
        return managerList;
    }

    public void setManagerList(List<Manager> managerList) {
        this.managerList = managerList;
    }

   
    List<Worker> workerList = new ArrayList<>();

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }
    
    public Owner(String person_name, String phone_number, Company company) {
       super(person_name, phone_number);
       this.companies= new ArrayList<Company>();
       companies.add(company);
        
    }
    public void startProject(){
        System.out.println("Project 1 started today...");
        System.out.println("Project 1 ");
    }
   
   
 public List<Employee> addNewEmployee(){
    Manager m;
    Worker w;
    System.out.println("Enter the employee name:");
    Scanner input=new Scanner(System.in);
    String name=input.nextLine();
    System.out.println("Enter employee phone number:");
    String phone=input.nextLine();
    System.out.println("Enter the designation: Manager or Worker");
    String des=input.nextLine();
    if(des.equalsIgnoreCase("Manager")){
    m=new Manager(name, phone,des);
    managerList.add(m);
    
    }
    else{
    w=new Worker(name,phone,des);
    workerList.add(w);
   
    }
    employeeList.addAll(workerList);
    employeeList.addAll(managerList);
    return employeeList;
 }
   
  public  void evaluatePerformance() {
       int score=0;
       String performance = null;
       Iterator<Manager> managerIterator = managerList.iterator();
       while(managerIterator.hasNext()){
           Manager manager=managerIterator.next();
           System.out.println("Evaluating performance of  Manager  "+ manager.getPerson_name());
           
           Scanner answers=new Scanner(System.in);
           System.out.println("Does the manager deliver projects on time?Yes/no");
           String time=answers.next();
           if(time.equalsIgnoreCase("yes")) 
                    score+=1;
            System.out.println("Does the manager equally allocate work to all his employees? Yes/No?)");
            String work=answers.next();
            if(work.equalsIgnoreCase("yes")) 
                    score+=1;
            System.out.println("Does the manager a healthy inter-personal skills with his employees?");
            String people=answers.next();
            if(people.equalsIgnoreCase("yes")) 
                    score+=1;
            if(score==0)
                    System.out.println("Performance status : Needs improvement ");
            else if(score==1)
                System.out.println("Performance status : Good");
            else if(score==2)
                System.out.println("Performance status : Exceeds Expectations");
            else
                System.out.println("Performance status : Excellent!");
       }   
  }
  public void announceNews (List<Employee> empList) throws IOException{
      String news=null;
      String status=null;
      Employee emp;
      
      
      //Scanner broadcast=new Scanner(System.in);
      
      DataInputStream dis=new DataInputStream(System.in);
      System.out.println("Do you have a news to broadcast?");
      status=dis.readLine();
      if(status.equalsIgnoreCase("yes")){
          System.out.println("Enter the news you wish to broadcast:");
          news=dis.readLine();
          Iterator<Employee> empIterator = empList.iterator();
          while(empIterator.hasNext()){
              emp=empIterator.next();
             // emp.getOwnersMessage(news);
          }
                  
      }
              
  }
//      String news=null;
//      String status=null;
//      Manager manager;
//      Worker worker;
//      
//               
//      
//      Scanner broadcast=new Scanner(System.in);
//      System.out.println("Do you have any news to send to your employees?  Yes/No");
//      status=broadcast.next();
//      if(status.equalsIgnoreCase("yes")){
//          System.out.println("Enter the news to broadcast:");
//          news=broadcast.nextLine();
//          System.out.println("News to be broadcasted:"  + news);
//          System.out.println("Sending news to all employees....");
// Iterator<Manager> managerIterator = managerList.iterator();
//          while(managerIterator.hasNext()){
//                 manager=managerIterator.next();
//                manager.getOwnersMessage(news);
//              }
//          }
//      Iterator<Worker> workerIterator = workerList.iterator();
//          while(workerIterator.hasNext()){
//                worker=workerIterator.next();
//                worker.getOwnersMessage(news);
//              }
//          }

   
    
}
