package operation;

import book.Book;
import book.BookList;

public class AddOperation implements IOperation{

    public  void work(BookList bookList){
        System.out.println("新增图书");
        System.out.println("请输入书名：");
        String name = scanner.next();
        System.out.println("请输入作者：");
        String author = scanner.next();
        System.out.println("请输入价格：");
        double price = scanner.nextDouble();
        System.out.println("请输入类型：");
        String type = scanner.next();
        Book book = new Book(name,author,price,type);
        int pos = bookList.usedsize;
        bookList.setBook(book,pos);
        bookList.setSize(bookList.usedsize + 1);
    }
}
