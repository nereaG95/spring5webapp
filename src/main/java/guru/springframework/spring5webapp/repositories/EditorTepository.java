package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.modelo.Book;
import guru.springframework.spring5webapp.modelo.Editor;
import org.springframework.data.repository.CrudRepository;

public interface EditorTepository extends CrudRepository<Editor,Long> {
}
