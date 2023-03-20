package notebook.repository;

import java.util.List;
import java.util.Optional;

public interface GBRepository<E, I> {
    List<E> findAll();
    E create(E e);
    Optional<E> findById(I id);
    Optional<E> update(I id, E e);
    boolean delete(I id);
}
