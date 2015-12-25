/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vo;

/**
 *
 * @author pakorn
 */
public class Employee {
    
    private long id;
    private String fNmae;
    private String lName;
    private String address;

    public Employee(long id, String fName, String lName, String address) {
        this.id = id;
        this.fNmae = fName;
        this.lName = lName;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfNmae() {
        return fNmae;
    }

    public void setfNmae(String fNmae) {
        this.fNmae = fNmae;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
