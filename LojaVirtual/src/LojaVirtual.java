import java.util.ArrayList;

public class LojaVirtual {
    private int tamanhoEstoque;
    private ArrayList<Produto> produtos;
    private boolean existe;
    private boolean QuantidadeCerta;
    private int ProdutoEscolhido;
    private int quantVendas;
    private float CaixaDaLoja;

    public LojaVirtual(){
        this.produtos = new ArrayList<Produto>();
    }

    public long retornarIdDoProduto(Produto produto){
        return produto.getId();
    }


    public void incluirProdutoNoEstoque(Produto produto, int quantidade){
        if(this.produtos.size() == 0){
            this.produtos.add(produto);
        }else {
            for (int i = 0; i < this.produtos.size(); i++) {
                if (this.produtos.get(i) == produto) {
                    this.produtos.get(i).setQuantidadeEmEstoque(quantidade);
                } else {
                    this.produtos.add(produto);
                    return;
                }
            }
        }
    }

    public String efetuarVenda(Produto produto, int quantidade){
        for(int i = 0; i < this.produtos.size(); i++){
            if(this.produtos.get(i) == produto){
                this.existe = true;
                this.QuantidadeCerta = this.produtos.get(i).getQuantidadeEmEstoque() == quantidade;
                this.ProdutoEscolhido = i;
                break;
            }else{
                this.existe = false;
            }
        }
        if(this.existe && this.QuantidadeCerta){
            if(this.receberPagamento(produto.getPreçoEmReais()*quantidade)){
                this.produtos.get(ProdutoEscolhido).setQuantidadeEmEstoque((-quantidade));
                this.quantVendas++;
                return String.format("Nota Fiscal" +
                        "\nVocê comprou\n" +
                        "-> ID%d -- %s" +
                        "\n pelo valor de R$%d reais\n", produto.getId(),produto.toString(), quantidade*produto.getPreçoEmReais());
            } else return "Houve um problema ao efetuar a compra";
        } else {
            return "Não temos esse produto, ou a quantidade que deseja em nossa loja";
        }

    }

    public int getTotalValorVendas(){
        return this.quantVendas;
    }

    private boolean receberPagamento(float valor){
        this.CaixaDaLoja += valor;
        return true;
    }

    public int getTamanhoEstoque() {
        this.tamanhoEstoque = 0;
        for (Produto produto : this.produtos) {
            this.tamanhoEstoque += produto.getQuantidadeEmEstoque();
        }
        return this.tamanhoEstoque;
    }
    public int getTamanhoEstoque(Produto produto){
        return produto.getQuantidadeEmEstoque();
    }
}
