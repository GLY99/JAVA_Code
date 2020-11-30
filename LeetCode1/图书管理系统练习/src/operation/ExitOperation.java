package operation;

import book.BookList;

public class ExitOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("退出系统!");
        System.exit(0);
    }
}
