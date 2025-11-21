package io.github.dougllasfps.vendasapi.rest.produtos;

import io.github.dougllasfps.vendasapi.model.Produto;
import io.github.dougllasfps.vendasapi.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public ProdutoFormRequest salvar(@RequestBody ProdutoFormRequest produto){

        Produto instanciaProduto = new Produto(produto.getDescricao(), produto.getNome(), produto.getPreco(), produto.getSku());
        repository.save(instanciaProduto);

        System.out.println(instanciaProduto);
        return produto;
    }
}
