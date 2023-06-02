package com.yuan.ssm.mapper;

import com.yuan.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    /**
     * 查询所有员工信息
     * @return 所有员工信息
     */
    List<Employee> getAllEmployee();

    /**
     * 根据empId删除员工
     * @param empId
     * @return
     */
    void deleteEmployee(@Param("empId") Integer empId);

    /**
     * 添加员工
     * @param employee
     * @return
     */
    void addEmployee(Employee employee);

    Employee getEmployee(Integer empId);

    void updateEmployee(Employee employee);
}
