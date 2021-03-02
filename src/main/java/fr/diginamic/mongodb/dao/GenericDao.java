package fr.diginamic.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import fr.diginamic.mongodb.client.MongoClientSingleton;

public abstract class GenericDao<T, ID> implements CrudDao<T, ID> {

	private static final String DATABASE_NAME = "library";
	private final String collectionName;
	private final Class<T> javaType;
	private MongoClient client;
	
	public GenericDao(String collectionName, Class<T> javaType) {
		this.collectionName = collectionName;
		this.javaType = javaType;
	}
	
	@Override
	public T create(T t) {
		MongoCollection<T> collection = this.getCollection();
		collection.insertOne(t);
		return t;
	}

	@Override
	public T update(T t) {
		MongoCollection<T> collection = this.getCollection();
//		collection.findOneAndUpdate(t);
		return null;
	}

	@Override
	public T findById(ID id) {
		MongoCollection<T> collection = this.getCollection();
		return collection.find(eq(id)).first();
	}

	@Override
	public List<T> findAll() {
		MongoCollection<T> collection = this.getCollection();
		return collection.find().into(new ArrayList<>());
	}

	@Override
	public void remove(ID id) {
		MongoCollection<T> collection = this.getCollection();
		collection.findOneAndDelete(eq(id));
	}
	
	protected MongoCollection<T> getCollection() {
		client = MongoClientSingleton.getMongoClient();
		MongoDatabase db = client.getDatabase(DATABASE_NAME);
		return db.getCollection(collectionName, javaType);
	}

}
