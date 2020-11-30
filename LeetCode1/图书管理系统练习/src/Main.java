import book.*;
import user.*;
import java.util.Scanner;

public class Main {
    public static User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = scanner.next();
        System.out.println("请选择你的身份：1.管理员 0.普通用户");
        int choice = scanner.nextInt();
        if (choice == 1){
            return new Admin(name);
        }else {
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        BookList booklist = new BookList();
        User user = login();
        while (true){
            int choice = user.menu();
            user.doOperation(choice,booklist);
        }

    }
}
