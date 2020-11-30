package operation;

import book.*;
public class BorrowOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("借阅图书");
        System.out.println("请输入书名：");
        String name = scanner.next();
        int i;
        for (i = 0;i < bookList.usedsize;i++){
            if (bookList.books[i].getName().equals(name)){
                break;
            }
        }
        if(i >= bookList.usedsize){
            System.out.println("未找到该书籍");
            return;
        }
        if (bookList.books[i].isBorrowed() == true){
            System.out.println("图书已经借出！");
            return;
        }
        if (bookList.books[i].isBorrowed() == false){
            System.out.println("借阅成功！");
            bookList.books[i].setBorrowed(true);
            return;
        }
    }
}
