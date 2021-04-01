package goncalves.ribeiro.lucas;

import java.util.Scanner;

public class Main {

    //Atributos
    private static Conta[] conta = new Conta[100];
    private boolean executarSistema;
    private Scanner scanner;
    //private Conta conta;
    private Transacao transacao;

    public static void main(String[] args) {
        conta[0] = new Conta("0", 1000.00, "Lucas");
        conta[1] = new Conta("1", 250.00, "Marcio");
        conta[2] = new Conta("2", 3000.00, "Catarina");
        Main main = new Main();
        main.executar();

    }

    //Métodos

    //roda o programa
    public void executar(){
        int op;
        while(executarSistema){
            exibirMenu();
            exibirInicial();
            op = scanner.nextInt();
            avaliarOpcao(op);
        }
    }
    //permite que a operaçao escolhida pelo usuario seja realizada
    private void avaliarOpcao(int op) {
        switch (op){
            case 1:
                int i = 0;
                System.out.println("Informe seu nome:");
                String pagador = scanner.nextLine();
                while (pagador.equals(conta[i].getUsuario().getNome())){ i++; }  //relaciona o usuario a conta correspondente
                Conta contaPagador = conta[i];

                int j = 0;
                System.out.println("Informe o nome recebedor:");
                String recebedor = scanner.nextLine();
                while (recebedor.equals(conta[j].getUsuario().getNome())){ j++;} //relaciona o usuario a conta correspondente
                Conta contaRecebedor = conta[j];

                System.out.println("Informe o QRCode: ");
                String QRCode = scanner.nextLine();

                /*System.out.println(contaPagador);
                System.out.println(contaRecebedor);*/

                //realiza o pagamento
                this.transacao.pagamento(contaPagador, contaRecebedor, QRCode);
                break;

            case 2:
                System.out.println("Informe o Id da Conta");
                String idConta = scanner.nextLine();

                System.out.println("Informe seu usuario:");
                String usuario = scanner.nextLine();

                System.out.println("Informe o valor:");
                double valor2 = scanner.nextInt();
                //gera o QRCode
                this.transacao.gerarChave(idConta, usuario, valor2);
                break;

            case 0:
                System.out.println("Agradecemos a preferência!");
                this.executarSistema = false;
                exibirFinal();
                break;
        }
    }

    //<editor-fold desc="exibidores">
    //exibir menu
    private void exibirMenu() {
        System.out.println("Qual operação deseja realizar?");
        System.out.println("1. Pagar");
        System.out.println("2. Receber");
        System.out.println("0. Encerrar");
    }


    //exibir o estado incial
    private void exibirInicial(){
        System.out.println("------------------------");
        System.out.println("Estado Inicial:");
        System.out.println("Usuário: " + conta[0].getUsuario().getNome() + " Saldo: " + conta[0].getSaldo());
        System.out.println("Usuário: " + conta[1].getUsuario().getNome() + " Saldo: " + conta[1].getSaldo());
        System.out.println("Usuário: " + conta[2].getUsuario().getNome() + " Saldo: " + conta[2].getSaldo());
        System.out.println("------------------------");
    }

    //exibir o estado final
    private void exibirFinal(){
        System.out.println("------------------------");
        System.out.println("Estado Final:");
        System.out.println("Usuário: " + conta[0].getUsuario().getNome() + " Saldo: " + conta[0].getSaldo());
        System.out.println("Usuário: " + conta[1].getUsuario().getNome() + " Saldo: " + conta[1].getSaldo());
        System.out.println("Usuário: " + conta[2].getUsuario().getNome() + " Saldo: " + conta[2].getSaldo());
        System.out.println("------------------------");
    }
    //</editor-fold>

    //construtor
    public Main(){

        this.scanner = new Scanner(System.in);
        this.executarSistema = true;
        this.transacao = new Transacao();
        //conta[0] = new Conta("0", 1000.00, "Lucas");
        /*conta[1] = new Conta("1", 250.00, "Marcio");
        conta[2] = new Conta("2", 3000.00, "Catarina");*/
    }

    @Override
    public String toString() {
        return "Main{" +
                "executarSistema=" + executarSistema +
                ", scanner=" + scanner +
                ", conta=" + conta +
                ", transacao=" + transacao +
                '}';
    }
}