public class Roupa extends Produto{

    private final char tamanho;
    private final String cor;

    public Roupa(int peso, int preço, String categoria, int quant, char tamanho, String cor) {
        super(peso, preço, categoria = "Vestuário", quant);
        this.cor = cor;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return String.format("Roupa da cor %s, de tamanho %c",
                this.cor, this.tamanho);
    }
}
