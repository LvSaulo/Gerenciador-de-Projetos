public class Fellows extends Users{

    Double valor_bolsa;
    Double tempo_bolsa;

    public Fellows(int id, String name, String password, Double valor_bolsa, Double tempo_bolsa) {
        super(id, name, password);

        this.valor_bolsa = valor_bolsa;
        this.tempo_bolsa = tempo_bolsa;

        Users user = new Users();
    }

    public void setValorBolsa() {
        System.out.println("Digite o valor da bolsa: ");
        this.valor_bolsa = input.nextDouble();
    }

    public void setTempoBolsa() {
        System.out.println("Digite o tempo da bolsa: ");
        this.tempo_bolsa = input.nextDouble();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + "\nValor da bolsa: " + this.valor_bolsa + "\nTempo da bolsa: " + this.tempo_bolsa;
    }
}
