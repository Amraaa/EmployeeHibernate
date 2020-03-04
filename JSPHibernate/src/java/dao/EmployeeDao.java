
package dao;


import java.util.List;
import pojo.Employeedetails;
 
 

public interface EmployeeDao {
    
    public void saveEmployee (Employeedetails employee);
    public List<Employeedetails> showAllEmployees();
    public void updateEmployee (int id, String ename, String enumber);
    public void deleteEmployee (Employeedetails employee);
    
    
}
