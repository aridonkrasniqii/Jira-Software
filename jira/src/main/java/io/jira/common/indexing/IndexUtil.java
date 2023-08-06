package io.jira.common.indexing;

import com.mongodb.client.model.*;
import org.bson.conversions.Bson;

import java.util.List;

public class IndexUtil {

    public static Collation caseInSensitiveCollation() {
        return Collation.builder().collationStrength(CollationStrength.SECONDARY).build();
    }

    public static IndexModel createIndex(Bson index, IndexOptions indexOptions) {
        return new IndexModel(index, indexOptions);
    }

    public static IndexModel createIndex(Bson index) {
        return new IndexModel(index);
    }

    public static IndexModel createIndex(Bson index, String indexName, Collation collation ) {
        return new IndexModel(index, new IndexOptions().name(indexName).collation(collation));
    }

    public static IndexModel createIndex(Bson index, String indexName) {
        return new IndexModel(index, new IndexOptions().name(indexName));
    }

    public static IndexModel createCompoundIndex(List<Bson> indexes, String indexName) {
        return new IndexModel(Indexes.compoundIndex(indexes), new IndexOptions().name(indexName));
    }

    public static IndexModel createCompoundIndex(List<Bson> indexes, String indexName, Collation collation) {
        return new IndexModel(Indexes.compoundIndex(indexes), new IndexOptions().name(indexName).collation(collation));
    }

}
