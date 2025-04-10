package br.pucrs.gwojtysiak.project;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;



@RestController
@RequestMapping("/biblioteca")
public class ExemploController {
    private List<Livro> listaLivros;

    public ExemploController(){
        listaLivros = new ArrayList<>();
        listaLivros.add(new Livro(0, "Devil May Cry", "Hideki Kamiya", 2001));
        listaLivros.add(new Livro(0, "Vergil's Inferno", "Hideki Kamiya", 2005));
        listaLivros.add(new Livro(1, "Guia do Mochileiro das Galáxias", "Douglas Adams", 1979));        
        listaLivros.add(new Livro(2, "Guia do Mochileiro das Galáxias 2: O Inimigo Agora é Outro", "Douglas Adams", 2002));
    }
    @GetMapping("/")
    public String getMensagemInicial() {
        return "Aplicação Spring Boot Funcionando";
    }
    
    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return this.listaLivros;
    }

    @GetMapping("/autores")
    public List<String> getAutores() {
        List<String> autores = new ArrayList<>();

        for(Livro livro : listaLivros){
            autores.add(livro.getAutor());
        }

        return autores;
    }

    @GetMapping("/titulos")
    public List<String> getTitulos() {
        List<String> titulos = new ArrayList<>();

        for(Livro livro : listaLivros){
            titulos.add(livro.getTitulo());
        }

        return titulos;
    }

    @GetMapping("/livrosautor")
    public List<Livro> getLivroByAutor(@RequestParam(value = "autor") String autor) {
        return listaLivros.stream()
        .filter(livro -> livro.getAutor().equals(autor))
        .toList();
    }
    
    @GetMapping("/livrosautorano/{autor}/ano/{ano}")
    public List<Livro> getLivroByAutorAno(@PathVariable(value="autor") String autor,
                                @PathVariable(value="ano") int ano) {
        return listaLivros.stream()
        .filter(livro -> livro.getAutor().equals(autor))
        .filter(livro -> livro.getAno() == ano)
        .toList();
    }

    @PostMapping("/novolivro")
    public ResponseEntity<String> createNewBook(@RequestBody Livro livro) {
        listaLivros.add(livro);

        return ResponseEntity
                .status(200)
                .body("Livro Adicionado com Sucesso!");
    }
    
    @GetMapping("/livrotitulo/{titulo}")
    public ResponseEntity<Optional<Livro>> getMethodName(@PathVariable(value = "titulo") String titulo) {
        Optional<Livro> foundLivro = listaLivros.stream()
                            .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                            .findFirst();

        return ResponseEntity
                .status(200)
                .body(foundLivro);
    }
    
}
