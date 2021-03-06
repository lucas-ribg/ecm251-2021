package goncalves.ribeiro.lucas;

public class Conta {
    //Atributos da classe
    private Cliente cliente;
    private double saldo;
    private int numero;

    public Conta(String nome, double saldoInicial, int numero) {
        this.saldo = saldoInicial;
        this.numero = numero;
        this.cliente = new Cliente(nome);
    }

    //Métodos da classe
    public void depositar(double valor){
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saldo restante: R$" + this.saldo);
            return true;
        }
        System.out.println("Saldo Insuficiente!");
        return false;
    }

    public boolean transferirDinheiro(Conta destino, double valor){
        if(this.sacar(valor)){
            destino.depositar(valor);
            System.out.println("Operação realizada!");
            return true;
        }
        System.out.println("Falha na operação!");
        return false;
    }

    public double getSaldo(){
        return this.saldo;
    }

    @Override
    public String toString(){
        return "Conta{" +
                "cliente=" + cliente.toString() +
                ", saldo" + saldo +
                ", numero=" + numero +
                "}";

    }
}