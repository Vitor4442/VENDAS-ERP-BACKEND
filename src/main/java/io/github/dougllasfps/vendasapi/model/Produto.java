package io.github.dougllasfps.vendasapi.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@ToString

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

    private String sku;

    public Produto(String descricao, String nome, BigDecimal preco, String sku) {
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.sku = sku;
    }
}
