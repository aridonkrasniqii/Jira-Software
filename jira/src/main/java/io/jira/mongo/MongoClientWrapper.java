package io.jira.mongo;

import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.Document;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class MongoClientWrapper {

    @Inject
    ReactiveMongoClient reactiveMongoClient;

    @ConfigProperty(name = "mongodb.database")
    String database;

    public <T> ReactiveMongoCollection<T> getCollection(String name, Class<T> clazz) {
        return reactiveMongoClient.getDatabase(database).getCollection(name, clazz);
    }

    public ReactiveMongoCollection<Document> getCollection(String name) {
        return reactiveMongoClient.getDatabase(database).getCollection(name);
    }
}
