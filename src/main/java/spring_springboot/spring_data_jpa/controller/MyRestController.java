package spring_springboot.spring_data_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_springboot.spring_data_jpa.entity.Employee;
import spring_springboot.spring_data_jpa.service.EmployeeService;


import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> findAllByName(@PathVariable String name) {
        List<Employee> allEmployeesByName = employeeService.findAllByName(name);
        return allEmployeesByName;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

//        if (employee == null) {
//            throw new NoSuchEmployeeException("is not employee with id = " + id);
//        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

//        if (employee == null) {
//            throw new NoSuchEmployeeException("is not employee with id = " + id + " in Database.");
//        }
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted.";
    }


}
