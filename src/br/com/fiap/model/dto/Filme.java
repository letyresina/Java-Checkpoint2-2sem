// João Pedro Oliveira Chambrone - RM 97857
// Vitor Hugo Gonçalves Rodrigues - RM 97758
// Gabriel Machado - RM 99880
// Leticia Resina - RM 98069

package br.com.fiap.model.dto;

public class Filme {

    private int codigo;
    private String titulo, genero, produtora;

    public Filme(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }
}
