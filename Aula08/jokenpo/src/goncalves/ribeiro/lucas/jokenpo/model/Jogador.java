package goncalves.ribeiro.lucas.jokenpo.model;

public class Jogador {
    private String nome;
    private boolean ehHumano;
    private Jogada jogada;

    public Jogador(String nome, boolean ehHumano){
        this.nome = nome;
        this.ehHumano = ehHumano;
    }

    public Jogador(String nome){
        this.nome = nome;
        this.ehHumano = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean isEhHumano() {
        return ehHumano;
    }

    public void setJogada(Jogada jogada) {
        this.jogada = jogada;
    }
}
