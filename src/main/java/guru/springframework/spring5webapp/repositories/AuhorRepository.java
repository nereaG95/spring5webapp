package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.modelo.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuhorRepository extends CrudRepository <Author,Long> {

}
