package guru.springframework.spring5webapp.modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Editor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String direccion;
    private String ciudad;
    private String estado;
    private int cp;

    //Hay un editor para muchos libros
    @OneToMany
    @JoinColumn(name="editor_id")
    private Set<Book> books = new HashSet<>();

    public Editor() {
    }
    public Long getId() {
        return id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }



    @Override
    public String toString() {
        return "Editor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", estado='" + estado + '\'' +
                ", cp=" + cp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Editor editor = (Editor) o;

        if (cp != editor.cp) return false;
        if (id != null ? !id.equals(editor.id) : editor.id != null) return false;
        if (name != null ? !name.equals(editor.name) : editor.name != null) return false;
        if (direccion != null ? !direccion.equals(editor.direccion) : editor.direccion != null) return false;
        if (ciudad != null ? !ciudad.equals(editor.ciudad) : editor.ciudad != null) return false;
        return estado != null ? estado.equals(editor.estado) : editor.estado == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (ciudad != null ? ciudad.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + cp;
        return result;
    }
}
