import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LojaVirtualTeste {

    private Produto produto,produto2,produto3,produto4,produtoInexistete;
    private LojaVirtual Nike;

    @Before
public void setUp() {Nike = new LojaVirtual();}

    @Test
    public void testarRecebimentoDeProduto(){
        char tamanho = 'P';
            produto = new Roupa(100,10,"",10,tamanho,"Vermelho");
            produtoInexistete = new Roupa(100,10,"",10,tamanho,"Vermelho");
            produto2 = new Roupa(10,11,"",1,tamanho,"Azul");
            produto3 = new Roupa(9,1,"",1,tamanho,"Verde");
            produto4 = new Livro(9,100,"",20,"Harry Potter","J.K Rowling",1998,200);
            Nike.incluirProdutoNoEstoque(produto, produto.getQuantidadeEmEstoque());
            Nike.incluirProdutoNoEstoque(produto2, produto2.getQuantidadeEmEstoque());
            Nike.incluirProdutoNoEstoque(produto3, produto3.getQuantidadeEmEstoque());
            Nike.incluirProdutoNoEstoque(produto4,produto4.getQuantidadeEmEstoque());
            System.out.println(Nike.getTamanhoEstoque());
            System.out.println(Nike.getTamanhoEstoque(produto));
            System.out.println(Nike.getTamanhoEstoque(produto2));
            System.out.println(Nike.getTamanhoEstoque(produto3));
            System.out.println(Nike.retornarIdDoProduto(produto));
            System.out.println(Nike.retornarIdDoProduto(produto2));
            System.out.println(Nike.retornarIdDoProduto(produto3));
    }

    @Test
    public void efetuarVenda() {
        char tamanho = 'M';
        produto = new Roupa(100,10,"",10,tamanho,"Vermelho");
        produtoInexistete = new Roupa(100,10,"",10,tamanho,"Vermelho");
        produto2 = new Roupa(10,11,"",1,tamanho,"Azul");
        produto3 = new Roupa(9,1,"",1,tamanho,"Verde");
        produto4 = new Livro(9,100,"",20,"Harry Potter","J.K Rowling",1998,200);
        Nike.incluirProdutoNoEstoque(produto, produto.getQuantidadeEmEstoque());
        Nike.incluirProdutoNoEstoque(produto2, produto2.getQuantidadeEmEstoque());
        Nike.incluirProdutoNoEstoque(produto3, produto3.getQuantidadeEmEstoque());
        Nike.incluirProdutoNoEstoque(produto4,produto4.getQuantidadeEmEstoque());
        System.out.println(Nike.efetuarVenda(produto4, 20));
        assertEquals("Quantidade de produtos no estoque após a venda",
                12,Nike.getTamanhoEstoque());
        assertEquals("Quantidade de produtos no estoque após a venda",
                0,Nike.getTamanhoEstoque(produto4));
        System.out.println(Nike.efetuarVenda(produto3, 20));
        assertEquals("Quantidade de produtos no estoque após outra que falhará venda",
                12,Nike.getTamanhoEstoque());
        assertEquals("Quantidade de produtos no estoque após a venda",
                1,Nike.getTamanhoEstoque(produto3));
        System.out.println(Nike.efetuarVenda(produto3, 0));
        assertEquals("Quantidade de produtos no estoque após outra que falhará venda",
                12,Nike.getTamanhoEstoque());
        assertEquals("Quantidade de produtos no estoque após a venda",
                1,Nike.getTamanhoEstoque(produto3));
        System.out.println(Nike.efetuarVenda(produto3, 1));
        assertEquals("Quantidade de produtos no estoque após outra que falhará venda",
                11,Nike.getTamanhoEstoque());
        assertEquals("Quantidade de produtos no estoque após a venda",
                0,Nike.getTamanhoEstoque(produto3));
        System.out.println(Nike.efetuarVenda(produtoInexistete, 1));
    }
}
