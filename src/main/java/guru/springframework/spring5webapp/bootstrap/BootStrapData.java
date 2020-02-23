package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.modelo.Author;
import guru.springframework.spring5webapp.modelo.Book;
import guru.springframework.spring5webapp.modelo.Editor;
import guru.springframework.spring5webapp.repositories.AuhorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.EditorTepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Es un componente administrado por Spring
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuhorRepository authorRepository;
    private final BookRepository bookRepository;
    private final EditorTepository editorRepository;

    public BootStrapData(AuhorRepository authorRepository, BookRepository bookRepository, EditorTepository editorRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.editorRepository = editorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Creamos editores

        Editor editor = new Editor();
        editor.setCiudad("Tenerife");
        editor.setDireccion("Calle mar");
        editor.setName("Editor 1");
        editor.setCp(38620);

        editorRepository.save(editor);

        System.out.println("Started editor");
        System.out.println(editorRepository.count());
        //Creamos autores y libros

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Desing", "123312");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setEditor(editor);
        editor.getBooks().add(ddd);

        //Lo guardamos en la bbdd H2
        authorRepository.save(eric);
        bookRepository.save(ddd);
        editorRepository.save(editor);

        Author rod = new Author("Rod","jhonson" );
        Book noEJB = new Book("J2EE Development without EJB", "39394559");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setEditor(editor);
        editor.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        editorRepository.save(editor);

        System.out.println("Started in Bootrstrap");
        System.out.println("Number of books : " + bookRepository.count());
        System.out.println("Editr numero de libros : " + editor.getBooks().size());
    }
}
