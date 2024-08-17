package partten.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:Manager
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/15 21:58
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager implements Employee{
    private String department;
    private String noteContent;
    @Override
    public void report() {
        System.out.println(this.noteContent);
    }
    public Manager(String department){
        this.department=department;
    }
}
