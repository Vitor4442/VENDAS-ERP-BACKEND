package io.github.dougllasfps.vendasapi.rest.produtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.dougllasfps.vendasapi.model.Produto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class ProdutoFormRequest {
    private long id;
    private String descricao;
    private String nome;
    private BigDecimal preco;
    private String sku;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate cadastro;

    public ProdutoFormRequest(){
        super();
    }
    public ProdutoFormRequest(long id, String descricao, String nome, BigDecimal preco, String sku, LocalDate cadastro) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.sku = sku;
        this.cadastro = cadastro;
    }

    public static ProdutoFormRequest fromModel(Produto produto){
        return new ProdutoFormRequest(produto.getId(), produto.getDescricao(), produto.getNome(), produto.getPreco(), produto.getSku(), produto.getDataCadastro());
    }

    public Produto toModel(){
        return new Produto(id, nome, descricao, preco, sku,);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCadastro() {
        return cadastro;
    }

    public void setCadastro(LocalDate cadastro) {
        this.cadastro = cadastro;
    }
}
