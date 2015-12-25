/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import vo.Employee;
import vo.Track;

/**
 *
 * @author pakorn
 */
@Path("/getEmployeeJsonWSData")
public class EmployeeService {
    
    private static final AtomicLong counter = new AtomicLong();
    private static List<Employee> employeeList;
    
    static{
        employeeList = employee();
    }
    
    
    @GET
    @Path("/getListEmpnJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getListEmpInJSON() {
        return employeeList;
    }
    
    private static List<Employee> employee(){
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(counter.incrementAndGet(), "กมล", "ทองพุ้ม", "123/456 ซ.7"));
        employeeList.add(new Employee(counter.incrementAndGet(), "ชิดชอบ", "ทองแดง", "456 ซ.7"));
        
        
        return employeeList;
    }
    
    public static void main(String[] args) {
        List<Employee> list = EmployeeService.employeeList;
        System.out.println("--------" + list.get(0).getId());
    }
    
}
