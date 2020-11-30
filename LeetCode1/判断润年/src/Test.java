import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = scanner.nextInt();
        System.out.println(judgeLeapYear(year));
        System.out.println("===================");
        printLeapyear(1999,2020);
    }
    public static boolean judgeLeapYear(int year){
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            return true;
        }
        return false;
    }
    public static void printLeapyear(int year1,int year2){
        for(int i = year1;i <= year2;i++){
            boolean ret = judgeLeapYear(i);
            if(ret == true){
                System.out.print(i+" ");
            }
        }
    }
}
