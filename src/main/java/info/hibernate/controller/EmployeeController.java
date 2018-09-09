package info.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import info.hibernate.dao.EmployeeDao;
import info.hibernate.entity.Employee;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(long eno) {
        try {
            Employee employee = new  Employee();
            employee.setEno(eno);
            employeeDao.delete(employee);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully deleted!";
    }
    @RequestMapping(value = "/save")
    @ResponseBody
    public String create(String name,Double salary) {
        try {
        	Employee employee = new Employee();
        	employee.setName(name);
        	employee.setSalary(salary);
        	employeeDao.saveEmployee(employee);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully saved!";
    }
    @RequestMapping(value = "/allEmployees")
    @ResponseBody
    public List<Employee> getAllEmployees() {
        try {
            return employeeDao.getAllEmployees();
        } catch (Exception ex) {
            return null;
        }
    }
}