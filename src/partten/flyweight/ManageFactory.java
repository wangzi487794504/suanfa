package partten.flyweight;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:ManageFactory
 * Package:
 * Description:
 *
 * @Aurhor 王子杰
 * @Create 2024/8/15 22:00
 * @Version 1.0
 */
public class ManageFactory {
    private static final Map<String, Employee> EMPLOYEE_MAP=new HashMap<>();
    public static Employee getManager(String department){
        Manager manager= (Manager) EMPLOYEE_MAP.get(department);
        if (manager == null){
            manager=new Manager(department);
            String noteContent="部门";
            manager.setNoteContent(noteContent);
            EMPLOYEE_MAP.put(department, manager);
        }
        return manager;
    }
}
