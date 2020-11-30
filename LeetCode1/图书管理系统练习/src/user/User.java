package user;

import book.*;
import operation.IOperation;
import java.util.Scanner;

public abstract class User {
    protected String name;
    protected IOperation[] operations;
    Scanner scanner = new Scanner(System.in);
    abstract public int menu();
    public void doOperation(int choice,BookList booklist){
        operations[choice].work(booklist);
    }
}
