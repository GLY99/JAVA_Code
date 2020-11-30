package operation;

import book.BookList;

public class FindOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("查找图书");
        System.out.println("请输入书名：");
        String name = scanner.next();
        for (int i = 0;i < bookList.usedsize;i++){
            if(bookList.books[i].getName().equals(name)){
                System.out.println(bookList.getBook(i));
                return;
            }
        }
        System.out.println("未找到此图书！");
    }
}
