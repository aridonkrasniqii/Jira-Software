package io.jira.domain.issue;


import com.mongodb.client.model.IndexModel;
import com.mongodb.client.model.Indexes;
import io.jira.common.indexing.IndexMigrationHandler;
import io.jira.domain.issue.models.Issue;
import io.jira.domain.issue.models.LinkedIssue;
import io.jira.domain.issue.models.Subtask;
import io.jira.mongo.MongoCollections;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.Document;

import java.util.List;

import static io.jira.common.indexing.IndexUtil.caseInSensitiveCollation;
import static io.jira.common.indexing.IndexUtil.createCompoundIndex;

@ApplicationScoped
public class IssueIndexHandler extends IndexMigrationHandler {


    @Override
    public ReactiveMongoCollection<Document> getCollection() {
        return mongoClientWrapper.getCollection(MongoCollections.ISSUE);
    }

    @Override
    public List<IndexModel> getIndexes() {

        IndexModel nameAndSummaryIndex = createCompoundIndex(
            List.of(Indexes.text(Issue.SUMMARY_FIELD),
                Indexes.text(Issue.NAME_FIELD)),
            "nameAndSummaryIndex",
            caseInSensitiveCollation());

        IndexModel sortedEpicIssuesIndex = createCompoundIndex(
            List.of(Indexes.ascending(Issue.EPIC_ID_FIELD),
                Indexes.descending(Issue.CREATED_AT_FIELD)),
            "sortedEpicIssuesIndex");

        IndexModel sortedIssueSubtasksIndex = createCompoundIndex(
            List.of(Indexes.ascending(Subtask.PARENT_ISSUE_ID_FIELD),
                Indexes.descending(Issue.CREATED_AT_FIELD)),
            "sortedSubtasksIndex");

        IndexModel linkedIssuesIndex = createCompoundIndex(
            List.of(Indexes.ascending(LinkedIssue.LINKED_ISSUE_TYPE_FIELD),
                Indexes.descending(LinkedIssue.CREATED_AT_FIELD)),
            "linkedIssuesIndex"
        );

        IndexModel activeSprintIndex = createCompoundIndex(
            List.of(Indexes.ascending(Issue.PROJECT_ID_FIELD),
                Indexes.ascending(Issue.SPRINT_ID_FIELD),
                Indexes.ascending(Issue.EPIC_NAME_FIELD),
                Indexes.ascending(Issue.ASSIGNEE_ID_FIELD),
                Indexes.text(Issue.SUMMARY_FIELD),
                Indexes.text(Issue.NAME_FIELD)),
            "activeSprintIndex",
            caseInSensitiveCollation()
        );

        IndexModel issuesIndex = createCompoundIndex(
            List.of(Indexes.ascending(Issue.PROJECT_ID_FIELD),
                Indexes.descending(Issue.CREATED_AT_FIELD),
                Indexes.text(Issue.SUMMARY_FIELD),
                Indexes.text(Issue.NAME_FIELD)),
            "issuesIndex",
            caseInSensitiveCollation()
        );

        return List.of(nameAndSummaryIndex, sortedEpicIssuesIndex, sortedIssueSubtasksIndex, linkedIssuesIndex, activeSprintIndex, issuesIndex);
    }
}
