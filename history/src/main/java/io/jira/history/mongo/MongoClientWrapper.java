package io.jira.history.mongo;

import com.mongodb.client.MongoClient;
import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

public class MongoClientWrapper {

    @Inject
    ReactiveMongoClient reactiveMongoClient;

    @ConfigProperty(name = "database")
    String database;


    public <T> ReactiveMongoCollection<T> getCollection(String collectionName, Class<T> clazz) {
        return reactiveMongoClient.getDatabase(database).getCollection(collectionName, clazz);
    }

}
