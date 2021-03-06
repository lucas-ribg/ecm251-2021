package goncalves.ribeiro.lucas.jokenpo.controlador;

import goncalves.ribeiro.lucas.jokenpo.model.*;
import goncalves.ribeiro.lucas.jokenpo.model.classico.Papel;
import goncalves.ribeiro.lucas.jokenpo.model.classico.Pedra;
import goncalves.ribeiro.lucas.jokenpo.model.classico.Tesoura;

import java.util.Random;
import java.util.Scanner;

public class Sistema {
    private Jogador player1, player2;
    private Scanner scanner;
    Jogada[] jogadas = new Jogada[]{new Pedra(), new Papel(), new Tesoura()};

    public Sistema(){
        scanner = new Scanner(System.in);
        incializarJogadores();
    }
    public void run(){
        boolean continuar = true;
        do {
            System.out.println(player1.getNome() + " vs " + player2.getNome());
            player1.setJogada(escolheJogada());
            player2.setJogada(sortearJogada());
            System.out.println("Jogada Player1: "+ player1.getJogada());
            System.out.println("Jogada Player2: "+ player2.getJogada());
            System.out.println("Resultado: " + player1.getJogada().verificarResultado(player2.getJogada()));
        }while(continuar);
    }

    private Jogada escolheJogada() {
        System.out.println("Informe sua jogada:\n1 - Pedra\n2 - Papel\n3 - Tesoura");
        int escolha = scanner.nextInt();
        Jogada [] jogadas = new Jogada[]{new Pedra(), new Papel(), new Tesoura()};
        return jogadas[escolha];
    }

    private Jogada sortearJogada() {
        return jogadas[new Random().nextInt(jogadas.length)];
    }

    private void incializarJogadores() {
        System.out.println("Informe um nome para o jogador1:");
        String nome = scanner.next();
        this.player1 = new Jogador(nome, true);
        this.player2 = new Jogador("NPC");
    }
}
