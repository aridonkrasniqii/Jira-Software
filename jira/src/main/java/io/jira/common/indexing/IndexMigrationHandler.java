package io.jira.common.indexing;

import com.mongodb.client.model.IndexModel;
import io.jira.mongo.MongoClientWrapper;
import io.jira.mongo.MongoUtils;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import org.bson.Document;
import org.jboss.logging.Logger;

import java.util.List;

public abstract class IndexMigrationHandler {

    @Inject
    public MongoClientWrapper mongoClientWrapper;

    @Inject
    Logger logger;

    public Uni<Void> createIndexes() {
        List<IndexModel> issueIndexes = getIndexes();

        return Multi.createFrom().iterable(issueIndexes)
            .onItem().transformToUni(this::createIndex)
            .concatenate().onItem().ignore().toUni();
    }

    public Uni<String> createIndex(IndexModel indexModel) {
        return MongoUtils.createIndex(getCollection(), indexModel);
    }

    public abstract ReactiveMongoCollection<Document> getCollection();
    public abstract List<IndexModel> getIndexes();
}
