//编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
//
//+----+--------+
//| Id | Salary |
//+----+--------+
//| 1  | 100    |
//| 2  | 200    |
//| 3  | 300    |
//+----+--------+
public class SQL {
    public static void main(String[] args) {
        //第二高的薪水就是小于最大薪水值的最大值
        String sql = "select max(Salary) SecondHighestSalary from Employee where Salary < (select max(Salary) from Employee);";
    }
}
