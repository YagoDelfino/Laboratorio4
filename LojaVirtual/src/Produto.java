public class Produto {
    private final long id;
    private int pesoEmGramas;
    private int preçoEmReais;
    private String categoria;
    private int quantidadeEmEstoque;
    private static long secNum = 1;

    public Produto(int peso, int preço, String categoria, int quant){
        this.id = this.secNum++;
        this.pesoEmGramas = peso;
        this.preçoEmReais = preço;
        this.categoria = categoria;
        this.quantidadeEmEstoque = quant;
    }

    public int getPesoEmGramas() {
        return this.pesoEmGramas;
    }

    public int getPreçoEmReais() {
        return this.preçoEmReais;
    }

    public long getId() {
        return this.id;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public int getQuantidadeEmEstoque(){
        return this.quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quant){
        this.quantidadeEmEstoque += quant;
    }

}
