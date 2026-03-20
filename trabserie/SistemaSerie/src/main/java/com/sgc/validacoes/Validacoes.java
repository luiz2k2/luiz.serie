package main.java.com.sgc.validacoes;

public class Validacoes {
    
    private Validacoes() {}
    
    public static boolean isTituloValido(String titulo) {
        return titulo != null && !titulo.trim().isEmpty();
    }
    
    public static boolean isDiretorValido(String criador) {
        return criador != null && !criador.trim().isEmpty();
    }
    
    public static boolean isAnoValido(int ano) {
        int anoAtual = java.time.Year.now().getValue();
        return ano >= 1888 && ano <= anoAtual;
    }
    
    public static boolean isTemporadasValida(int temporadas) {
        return temporadas > 0;
    }
    
    public static boolean isDuracaoValida(int duracao) {
        return duracao > 0;
    }
    
    public static boolean isObjetoValido(Object obj) {
        return obj != null;
    }
}