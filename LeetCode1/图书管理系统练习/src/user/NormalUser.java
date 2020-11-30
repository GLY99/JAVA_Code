package user;

import operation.*;

public class NormalUser extends User{
    public NormalUser(String name){
        this.name = name;
        this.operations = new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }
    @Override
    public int menu() {
        System.out.println("====================");
        System.out.println("你好！"+this.name+"欢迎使用图书管理系统！");
        System.out.println("1. 查找图书");
        System.out.println("2. 借阅图书");
        System.out.println("3. 归还图书");
        System.out.println("0. 退出系统");
        System.out.println("====================");
        System.out.println("请输入您的选择：");
        int choice = scanner.nextInt();
        return choice;
    }
}
