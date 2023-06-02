package com.yuan.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.yuan.ssm.pojo.Employee;
import com.yuan.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Employee controller.
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * Gets employee page.
     *
     * @param pageNum the page num
     * @param model   the model
     * @return the employee page
     */
    @RequestMapping(value="/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum")Integer pageNum,Model model){
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        model.addAttribute("page",page);
        return "employee_list";
    }

    /**
     * Delete employee string.
     *
     * @param empId the emp id
     * @return the string
     */
    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("empId")Integer empId){
        employeeService.deleteEmployee(empId);
        //1处错误（重定向）
        return "redirect:/employee/page/1";
    }


    /**
     * Add employee string.
     *
     * @param employee the employee
     * @return the string
     */
    @RequestMapping(value = "/employee/add",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        //1处错误（重定向）
        return "redirect:/employee/page/1";
    }

    /**
     * Gets employee.
     *
     * @param empId the emp id
     * @param model the model
     * @return the employee
     */
    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.GET)
    public String getEmployee(@PathVariable("empId")Integer empId,Model model){
        Employee employee = employeeService.getEmployee(empId);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    /**
     * Update employee string.
     *
     * @param employee the employee
     * @param model    the model
     * @return the string
     */
    @RequestMapping(value = "employee/update",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee,Model model){
        employeeService.updateEmployee(employee);
        model.addAttribute("employee",employee);
        return "redirect:/employee/page/1";
    }


    /**
     * Get all employee string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        List<Employee> list=employeeService.getAllEmployee();
        model.addAttribute("list",list);
        return "employee_list";
    }
}
