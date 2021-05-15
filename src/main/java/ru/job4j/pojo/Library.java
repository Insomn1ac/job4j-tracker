package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("War and Peace", 1225);
        Book book2 = new Book("Crime and Punishment", 672);
        Book book3 = new Book("Dead Souls", 352);
        Book book4 = new Book("Clean Code", 384);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " " + book.getCount());
        }
        System.out.println();
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " " + book.getCount());
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getName().equals("Clean Code")) {
                System.out.println(book.getName() + " " + book.getCount());
            }
        }
    }
}
