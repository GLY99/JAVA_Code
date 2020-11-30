import java.util.*;
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
public class Solution {
    public int getImportance(List<Employee> employees, int id){
        for (Employee e : employees){
            if (e.id == id){
                if (e.subordinates.isEmpty()){
                    return e.importance;
                }
                for (int i : e.subordinates){
                    e.importance += getImportance(employees,i);
                }
                return e.importance;
            }
        }
        return 0;
    }
}
