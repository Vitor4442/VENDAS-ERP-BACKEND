package io.github.dougllasfps.vendasapi.rest.produtos;

import io.github.dougllasfps.vendasapi.model.Produto;
import io.github.dougllasfps.vendasapi.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public ProdutoFormRequest salvar(@RequestBody ProdutoFormRequest produto){
        Produto instanciaProduto = produto.toModel();
        repository.save(instanciaProduto);
        return ProdutoFormRequest.fromModel(instanciaProduto);
    }
}
