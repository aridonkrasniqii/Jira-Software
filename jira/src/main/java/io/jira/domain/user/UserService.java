package io.jira.domain.user;


import io.jira.common.models.PaginatedEntity;
import io.jira.common.models.PaginationModel;
import io.jira.domain.user.dtos.CreateUser;
import io.jira.domain.user.dtos.UpdateUser;
import io.jira.domain.user.exceptions.UserException;
import io.jira.domain.user.filters.UserFilter;
import io.jira.domain.user.mappers.UserMapper;
import io.jira.domain.user.models.User;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;


@ApplicationScoped
public class UserService {

    @Inject
    UserRepository repository;

    public Uni<User> add(@Valid CreateUser user) {
        return repository.add(UserMapper.mapToUser(user));
    }

    public Uni<PaginatedEntity<User>> getAll(PaginationModel paginationModel, UserFilter userFilter) {
        return repository.getAll(paginationModel, userFilter);
    }

    public Uni<User> getById(String userId) {
        return repository.getById(userId)
                .onItem().ifNull()
                .failWith(() ->
                    new UserException());
    }

    public Uni<User> update(String userId, @Valid UpdateUser user) {
        return repository.update(userId, UserMapper.mapToUser(user))
                .onItem().ifNull()
                .failWith(() ->
                    new UserException());
    }

    public Uni<User> delete(String userId) {
        return repository.delete(userId)
                .onItem().ifNull()
                .failWith(() ->
                    new UserException());
    }
}
