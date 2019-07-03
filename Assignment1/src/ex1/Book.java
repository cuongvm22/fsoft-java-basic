/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ex1;

/**
 * 
 * @date Jun 17, 2019
 * @author cuongvm
 * @version 1.0
 * 
 */
public class Book {
    private String nameBook;
    private int isbn;
    private String author;
    private String publisher;

    public Book() {
        this("N/A", 0, "N/A", "N/A");
    }
    
    public Book(String nameBook, int isbn, String author, String publisher) {
        this.nameBook = nameBook;
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
    }

    
    
    public String getBookInfo() {
        return "Book{" + "nameBook=" + nameBook + ", isbn=" + isbn + ", author=" + author + ", publisher=" + publisher + '}';
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    
    

}
