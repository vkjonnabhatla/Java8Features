package org.java8.example;

import java.time.LocalDate;


public class Employee {

    private int empNo;
    private String empName;
    private int departmentNo;
    private LocalDate joiningDate;
    private double salary;

    public Employee(int empNo, String empName, int departmentNo, LocalDate joiningDate, double salary){
        this.empName = empName;
        this.empNo = empNo;
        this.departmentNo = departmentNo;
        this.joiningDate = joiningDate;
        this.salary = salary;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(int departmentNo) {
        this.departmentNo = departmentNo;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", empName='" + empName + '\'' +
                ", departmentNo=" + departmentNo +
                ", joiningDate=" + joiningDate +
                ", salary=" + salary +
                '}';
    }
}
