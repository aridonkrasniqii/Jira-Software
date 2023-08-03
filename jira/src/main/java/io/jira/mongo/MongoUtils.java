package io.jira.mongo;

import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import io.jira.common.models.BaseEntity;
import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;
import org.bson.conversions.Bson;

import java.util.List;

public class MongoUtils {
    public static <T> Uni<T> createEntity(ReactiveMongoCollection<T> collection, T entity) {
        if (entity instanceof BaseEntity) {
            ((BaseEntity) entity).setCreatedAndUpdatedAt();
            ((BaseEntity) entity).setObjectId();
        }

        return collection.insertOne(entity).onItem().transform(ignored -> entity);
    }

    public static <T> Uni<PaginatedEntity<T>> getEntities(ReactiveMongoCollection<T> collection, PaginationModel paginationModel, Bson filter) {
        List<Bson> pipeline = List.of(); // TODO: implement aggregation pipeline

        Uni<Long> numberOfDocuments = countDocuments(collection);
        Uni<List<T>> entities = collection.aggregate(pipeline).collect().asList();

        return Uni.combine()
            .all()
            .unis(numberOfDocuments, entities)
            .combinedWith((numOfDocuments, data) ->
                paginatedEntity(
                    data,
                    numOfDocuments.intValue(),
                    paginationModel
                )
            );
    }

    public static <T> Uni<Long> countDocuments(ReactiveMongoCollection<T> collection) {
        return collection.countDocuments();
    }

    public static <T> PaginatedEntity<T> paginatedEntity(List<T> data, int numberOfDocuments, PaginationModel paginationModel) {
        return new PaginatedEntity<>(
            data,
            numberOfDocuments,
            paginationModel.getPage(),
            paginationModel.getLimit(),
            countPages(numberOfDocuments, PaginationModel.PAGE_SIZE)
        );
    }

    public static <T> Uni<T> getEntity(ReactiveMongoCollection<T> collection, Bson filter) {
        return collection.find(filter).toUni();
    }

    public static <T> Uni<T> updateEntity(ReactiveMongoCollection<T> collection, Bson filter, T entity) {
        if (entity instanceof BaseEntity) {
            ((BaseEntity) entity).setUpdatedAt();
        }

        return collection.findOneAndReplace(filter, entity, new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER));
    }

    public static <T> Uni<T> updateEntity(ReactiveMongoCollection<T> collection, Bson filter, Bson update) {
        return collection.findOneAndUpdate(filter, update, new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER));
    }

    public static <T> Uni<T> deleteEntity(ReactiveMongoCollection<T> collection, Bson filter) {
        return collection.findOneAndDelete(filter);
    }

    public static int countPages(int numberOfDocuments, int pageSize) {
        return (int) Math.ceil((double) numberOfDocuments / pageSize);
    }
}
