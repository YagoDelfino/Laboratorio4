public class Livro extends Produto{

    private final String titulo;
    private final String autor;
    private final int anopublicado;
    private final int numerodepaginas;

    public Livro(int peso, int preço, String categoria, int quant,
                 String titulo, String autor, int ano, int paginas) {
        super(peso, preço, categoria = "Publicações", quant);
        this.titulo = titulo;
        this.autor = autor;
        this.anopublicado = ano;
        this.numerodepaginas = paginas;
    }

    @Override
    public String toString() {
        return String.format("%s do autor/autora %s, que contém %d páginas",
                this.titulo, this.autor, this.numerodepaginas);
    }
}
