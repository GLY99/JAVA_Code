package operation;

import book.BookList;

public class DelOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("删除图书");
        System.out.println("请输入图书名");
        String name = scanner.next();
        int i;
        for (i = 0;i < bookList.usedsize;i++){
            if (bookList.books[i].getName().equals(name)){
                break;
            }
        }
        if (i >= bookList.usedsize){
           System.out.println("图书不存在！");
           return;
        }
        for (int j = i;j < bookList.usedsize - 1;j++){
            bookList.books[j] = bookList.books[j + 1];
        }
        System.out.println("删除成功！");
        bookList.setSize(bookList.usedsize - 1);

    }
}
