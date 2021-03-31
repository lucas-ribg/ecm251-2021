package goncalves.ribeiro.lucas;

import java.util.Scanner;

public class Sistema {

    private boolean executarSistema;
    private Scanner scanner;
    private Conta conta;


    public void executar(){
        int op;
        while(executarSistema){
            exibirMenu();
            op = scanner.nextInt();
            avaliarOpcao(op);
        }
    }

    private void avaliarOpcao(int op) {
        switch (op){
            case 1:
                System.out.println("Informe o destinatário:");
                usuario = scanner.nextLine();

                System.out.println("Informe o valor:");
                valor = scanner.nextInt();

                System.out.println("Informe o QRCode: ");
                QRCode = scanner.nextLine();
                break;
            case 2:
                gerarChave();
                break;
            case 0:
                System.out.println("Obrigado pela preferência");
                this.executarSistema = false;
                break;
        }
    }

    private void exibirMenu() {
        System.out.println("Qual operação deseja realizar?");
        System.out.println("1. Pagar");
        System.out.println("2. Receber");
        System.out.println("0. Encerrar");
    }




    public Sistema(){
        this.scanner = new Scanner(System.in);
        this.executarSistema = true;
        this.conta = new Conta("c1", 1000.00 , "Joao");
        this.conta = new Conta("c2", 250.00 , "Catarina");
        this.conta = new Conta("c3", 3000.00 , "Marcio");
    }
}