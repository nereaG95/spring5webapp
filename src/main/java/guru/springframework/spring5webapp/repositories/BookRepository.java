package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.modelo.Author;
import guru.springframework.spring5webapp.modelo.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
