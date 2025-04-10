package br.pucrs.gwojtysiak.project;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/biblioteca")
public class ExemploController {
    private List<Livro> listaLivros;

    public ExemploController(){
        listaLivros = new ArrayList<>();
        listaLivros.add(new Livro(0, "Devil May Cry", "Hideki Kamiya", 2001));
        listaLivros.add(new Livro(1, "Guia do Mochileiro das Galáxias", "Douglas Adams", 1979));        
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
}
