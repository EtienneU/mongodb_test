package fr.diginamic.mongodb;

import fr.diginamic.mongodb.dao.BookDao;
import fr.diginamic.mongodb.model.Book;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Appli Java - MongoDB");
        
        BookDao bookDao = new BookDao();
        
        // Insert de livres
        Book book4 = new Book("La Couleur des Sentiments", LocalDate.now());
        Book book5 = new Book("Les Hommes viennent de Mars, les Femmes viennent de Venus", LocalDate.now());
        Book book6 = new Book("L'alchimiste", LocalDate.now());
        List<Book> booksToCreate = Arrays.asList(
        		new Book("Harry Potter 1", LocalDate.now()),
        		new Book("Harry Potter 2", LocalDate.now()),
        		new Book("Harry Potter 3", LocalDate.now()), 
        		book4, 
        		book5,
        		book6);
        for (Book b : booksToCreate) {
        	bookDao.create(b);
        } 		
        
        // Affichage des book de ma collection en DB avec le findAll() du DAO
        List<Book> books = bookDao.findAll();
        for (Book b : books) {
        	System.out.println(b);
        }
        
        // Find a book and remove it
//        for (Book b : books) {
//        	bookDao.remove(b.getId())   ;     
//        }
        
        // Affichage par titre
        String terme = "i";
        System.out.println("\nLivres dont le titre contient le terme \"" + terme + "\" : ");
        List<Book> selectedBooks = bookDao.findByTitle(terme);
        if (selectedBooks.isEmpty()) {
        	System.out.println("Aucun résultat");
        } else {
        	for (Book b : selectedBooks) {
        		System.out.println(b);
        	}
        }
    }
}
