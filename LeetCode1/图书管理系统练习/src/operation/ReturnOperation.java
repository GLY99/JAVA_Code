package operation;

import book.BookList;

public class ReturnOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("归还图书");
        System.out.println("请输入书名：");
        String name = scanner.next();
        int i;
        for (i = 0;i < bookList.usedsize;i++){
            if (bookList.books[i].getName().equals(name)){
                break;
            }
        }
        if (i >= bookList.usedsize){
            System.out.println("未找到图书！");
        }
        bookList.books[i].setBorrowed(false);
        System.out.println("归还成功！");
    }
}
