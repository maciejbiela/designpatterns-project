package io.github.maciejbiela.designpatternsproject.dataproviders.simplejava.repositories;

import io.github.maciejbiela.designpatternsproject.core.model.WithId;

import java.util.List;
import java.util.Optional;

abstract class AbstractRepository<T extends WithId> {
    public T get(Long id) {
        return getRepositoryList().stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<T> getAll() {
        return getRepositoryList();
    }

    public void update(T t) {
        final Optional<T> possible = getRepositoryList().stream()
                .filter(tImpl -> tImpl.getId().equals(t.getId()))
                .findFirst();
        if (possible.isPresent()) {
            final T actual = possible.get();
            update(actual, t);
        } else {
            t.setId((long) (getRepositoryList().size() + 1));
            getRepositoryList().add(t);
        }
    }

    abstract List<T> getRepositoryList();

    abstract void update(T actual, T accordingTo);
}
