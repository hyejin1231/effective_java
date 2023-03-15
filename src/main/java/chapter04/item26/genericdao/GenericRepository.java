package chapter04.item26.genericdao;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * item26. 로 타입은 사용하지 말라.
 * 완벽공략 GenericDao
 */
public class GenericRepository<E extends Entity> {

    private Set<E> entities;

    public GenericRepository() {
        this.entities = new HashSet<>();
    }

    public Optional<E> findById(Long id) {
        return entities.stream().filter(a -> a.getId().equals(id)).findAny();
    }

    public void add(E e) {
        entities.add(e);
    }


}
