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
public class People {
    private String person_name;
    private  String phone_number;

    public People(String person_name, String phone_number) {
        this.person_name = person_name;
        this.phone_number = phone_number;
    }

    public String getPerson_name() {
        return person_name;
    }

    public String getPhone_number() {
        return phone_number;
    }
    
    
    
    
}
