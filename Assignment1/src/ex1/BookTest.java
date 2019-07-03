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
public class BookTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Book b = new Book();
        System.out.println(b.getBookInfo());
        
        Book[] a = new Book[30];
        for (int i = 0; i < 30; i++){
            a[i] = new Book(("Book"+i), i, "author"+i, "publisher" + i);
        }
        for (Book el : a){
            System.out.println(el.getBookInfo());
        }
    }
    
}
