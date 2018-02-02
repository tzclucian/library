package tzc.library.persistence.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import tzc.library.persistence.jpa.BookEntity;

/**
 * Repo for the {@link BookEntity} generated by Spring.
 *
 * @author Lucian Tuca
 * @date 01/02/2018
 */
public interface BookJpaRepository extends CrudRepository<BookEntity, String> {
}