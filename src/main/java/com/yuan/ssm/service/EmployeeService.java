package com.yuan.ssm.service;

import com.github.pagehelper.PageInfo;
import com.yuan.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService{
    List<Employee> getAllEmployee();

    /**
     * 获取员工的分页信息
     * @param pageNum
     * @return
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);

    /**
     * 根据empId删除员工
     * @param empId
     * @return
     */
    void deleteEmployee(Integer empId);
    /**
     * 添加员工
     * @param employee
     * @return
     */
    void addEmployee(Employee employee);

    Employee getEmployee(Integer empId);

    void updateEmployee(Employee employee);
}
