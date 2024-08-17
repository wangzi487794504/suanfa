package partten.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Employee
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/15 21:02
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Employee {
    private String name;
    private String deptNo;
    private Long salary;
    private List<Employee> employeeList;

    public Employee(String name, String deptNo, Long salary) {
        this.name = name;
        this.deptNo = deptNo;
        this.salary = salary;
        employeeList=new ArrayList<>();
    }
    public void add(Employee e){
        employeeList.add(e);
    }
    public void remove(Employee e){
        employeeList.remove(e);
    }
}
