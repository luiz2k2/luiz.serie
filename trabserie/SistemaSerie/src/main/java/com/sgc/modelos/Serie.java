package main.java.com.sgc.modelos;

public class Serie {

    private String titulo;
    private String criador;
    private int ano;
    private int temporadas;

    public Serie(String titulo, String criador, int ano, int temporadas) {
        this.titulo = titulo;
        this.criador = criador;
        this.ano = ano;
        this.temporadas = temporadas;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
               ", Criador: " + criador +
               ", Ano: " + ano +
               ", Temporadas: " + temporadas;
    }
}