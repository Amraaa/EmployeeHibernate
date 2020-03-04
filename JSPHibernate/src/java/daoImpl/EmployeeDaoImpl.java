
package daoImpl;

import java.util.ArrayList;
import java.util.List;
import dao.EmployeeDao;
import pojo.Employeedetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
 

public class EmployeeDaoImpl implements EmployeeDao {
 
    @Override
    public void saveEmployee(Employeedetails employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }
 
    @Override
    public List<Employeedetails> showAllEmployees() {
        List<Employeedetails> employeeList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From EmployeeDetails");
        employeeList = query.list();
        return employeeList;
    }
 
    @Override
    public void updateEmployee(int id, String ename, String enumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Employeedetails empdetails = (Employeedetails)session.load(Employeedetails.class, id);
        empdetails.setEname(ename);
        empdetails.setEnumber(enumber);
        session.update(empdetails);
        transaction.commit();
        session.close();  
    }
 
    @Override
    public void deleteEmployee(Employeedetails employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();
    }
    
}
