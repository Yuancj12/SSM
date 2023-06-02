package com.yuan.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuan.ssm.mapper.EmployeeMapper;
import com.yuan.ssm.pojo.Employee;
import com.yuan.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

   @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum,4);
        List<Employee> list = employeeMapper.getAllEmployee();
        //获取分页信息
        PageInfo<Employee> page=new PageInfo<>(list,5);
        return page;
    }

    /**
     * 根据empId删除员工
     * @param empId
     * @return
     */
    @Override
    public void deleteEmployee(Integer empId) {
        employeeMapper.deleteEmployee(empId);

    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public Employee getEmployee(Integer empId) {
        return employeeMapper.getEmployee(empId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }
}
