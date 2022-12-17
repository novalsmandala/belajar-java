package programmer.zaman.now.application;

import programmer.zaman.now.data.Company;

public class NestedClass {
    public static void main(String[] args) {
        Company company = new Company();
        company.setName("Jess");

        Company.Employee employee = company.new Employee();
        employee.setName("Jess Inner");
        System.out.println(employee.getCompany());

        var company2 = new Company();
        company2.setName("Belum ada");

        Company.Employee employee2 = company2.new Employee();
        employee2.setName("Eko");
        System.out.println(employee2.getCompany());
    }
}
