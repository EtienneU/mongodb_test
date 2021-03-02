package fr.diginamic.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.MongoCollection;

import fr.diginamic.mongodb.model.Book;

public class BookDao extends GenericDao<Book, ObjectId>{
	
	public BookDao() {
		super("Book", Book.class);
	}
	
	public List<Book> findByTitle(String title) {
		MongoCollection<Book> collection = this.getCollection();
		return collection.find(regex("title", ".*" + title + ".*")).into(new ArrayList<>());
	}

}
