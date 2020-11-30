package operation;

import book.BookList;

public class DisplayOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("查阅全部书籍");
        for(int i = 0;i < bookList.usedsize;i++){
            System.out.println(bookList.getBook(i));
        }
    }
}
