package book;

import java.util.Arrays;

public class BookList {
    public Book[] books = new Book[3];
    public int usedsize;
    public BookList(){
        this.books[0] = new Book("三国演义","罗贯中",50,"小说");
        this.books[1] = new Book("水浒传","施耐庵",35,"小说");
        this.books[2] = new Book("JAVA编程基础","图灵",150,"学习");
        this.usedsize = 3;
    }
    private boolean isFull(){
        if (usedsize == this.books.length){
            return true;
        }else {
            return false;
        }
    }
    public Book getBook(int pos){
        return this.books[pos];
    }
    public void setBook(Book book,int pos){
        if (isFull()){
            this.books = Arrays.copyOf(this.books,this.usedsize * 2);
        }
        this.books[pos] = book;
    }
    public int getSize(){
        return this.usedsize;
    }
    public void setSize(int size){
        this.usedsize = size;
    }

}
