package io.jira.common.services;

import io.jira.common.indexing.IndexMigrationHandler;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.util.List;

@Startup
@ApplicationScoped
public class AppStartService {

    @Inject
    Instance<IndexMigrationHandler> indexMigrationHandlerInstance;

    @Inject
    Logger logger;

    public void createIndexesOnAppStart(@Observes StartupEvent event) {
        List<Uni<Void>> indexUnis = indexMigrationHandlerInstance.stream()
            .map(IndexMigrationHandler::createIndexes)
            .toList();


        Uni.combine().all().unis(indexUnis).collectFailures().discardItems()
            .subscribe()
            .with(
                unused -> System.out.println("Indexes created successfully."),
                failure -> logger.error("Failure in index service: " + failure.getMessage())
            );
    }
}
