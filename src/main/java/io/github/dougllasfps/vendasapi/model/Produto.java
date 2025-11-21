package io.github.dougllasfps.vendasapi.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name="produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao",  length = 100)
    private String descricao;

    @Column(name = "nome",  length = 100)
    private String nome;

    @Column(name = "preco",  precision = 16, scale = 2)
    private BigDecimal preco;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    private String sku;

    public Produto(Long id, String descricao, String nome, BigDecimal preco, String sku) {
        this.descricao = descricao;
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.sku = sku;
    }

    @PrePersist
    public void  prePersist(){
        setDataCadastro(LocalDate.now());
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
