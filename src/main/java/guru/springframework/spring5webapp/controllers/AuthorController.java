package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuhorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuhorRepository authorRepository;


    public AuthorController(AuhorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //En el controller lo que se devuelve es el nombre de la vista que queremos que llame
    //Como se mapee atiende a que cuando se le llama con books se llama a esta funcion
    //La pasamos comoa atributo el modelo y al modelo le añadimos los atributos que queremos que lleguen a la vista
    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors",authorRepository.findAll());
        return "authors/list";
    }
}
