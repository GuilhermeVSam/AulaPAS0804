package br.pucrs.gwojtysiak.project;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano;

    public Livro(int id, String titulo, String autor, int ano){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitulo(){
        return this.titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public int getAno(){
        return this.ano;
    }

    public void setAno(int ano){
        this.ano = ano;
    }
}
