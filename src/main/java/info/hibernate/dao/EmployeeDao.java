package info.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.hibernate.entity.Employee;

@Repository
@Transactional
public class EmployeeDao {
	 @Autowired
	    private SessionFactory sessionFactory;
	    private org.hibernate.Session getSession() {
	        return  sessionFactory.getCurrentSession();
	    }
	    public String saveEmployee(Employee employee) {
	        Long isSuccess = (Long)getSession().save(employee);
	        if(isSuccess >= 1){
	            return "Success";
	        }else{
	            return "Error while Saving Person";
	        }
	        
	    }
	    public boolean delete(Employee employee) {
	        getSession().delete(employee);
	        return true;
	    }
	    @SuppressWarnings("unchecked")
	    public List<Employee> getAllEmployees() {
	        return getSession().createQuery("from Employee").list();
	    }
}
