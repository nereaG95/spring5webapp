package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Como es un controlador hay que poner la anotacion de Controller
@Controller
public class BootController {


    private final BookRepository bookRepository;


    public BootController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //En el controller lo que se devuelve es el nombre de la vista que queremos que llame
    //Como se mapee atiende a que cuando se le llama con books se llama a esta funcion
   //La pasamos comoa atributo el modelo y al modelo le añadimos los atributos que queremos que lleguen a la vista
    @RequestMapping("/books")
    public String  getBooks(Model model){
        model.addAttribute("books",bookRepository.findAll());
        return "books/list";
    }

}
