package io.jira.domain.user;

import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.user.dtos.CreateUser;
import io.jira.domain.user.dtos.UpdateUser;
import io.jira.domain.user.filters.UserFilter;
import io.jira.domain.user.models.User;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService service;

    @POST
    public Uni<User> add(CreateUser user) {
        return service.add(user);
    }

    @GET
    public Uni<PaginatedEntity<User>> getAll(@BeanParam PaginationModel paginationModel, @BeanParam UserFilter userFilter) {
        return service.getAll(paginationModel, userFilter);
    }

    @GET
    @Path("/{id}")
    public Uni<User> getById(@PathParam("id") String id) {
        return service.getById(id);
    }

    @PUT
    @Path("/{id}")
    public Uni<User> update(@PathParam("id") String id, UpdateUser user) {
        return service.update(id, user);
    }

    @DELETE
    @Path("/{id}")
    public Uni<User> delete(String id) {
        return service.delete(id);
    }
}
