package entidade;

public class Produto {

    private Integer codigo;
    private String nome;
    private Double preco;

    public Produto(){
    }

    public Produto(Integer codigo, String nome, Double preco){
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getCodigo(){
        return codigo;
    }

    public void setCodigo(Integer codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Double getPreco(){
        return preco;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }

    public void aumentarPreco(double porcentagem){
        preco += preco * porcentagem / 100;
    }

    @Override
    public String toString(){
        return String.format("%-6s | %-20s | R$%7.2f", codigo, nome, preco);
    }
}