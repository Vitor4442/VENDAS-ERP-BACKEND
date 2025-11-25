package io.github.dougllasfps.vendasapi.rest.produtos;

import io.github.dougllasfps.vendasapi.model.Produto;
import io.github.dougllasfps.vendasapi.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<ProdutoFormRequest> getList(){
        return repository.findAll().stream().map( p -> ProdutoFormRequest.fromModel(p)).collect(Collectors.toList());
    }

    @PostMapping
    public ProdutoFormRequest salvar(@RequestBody ProdutoFormRequest produto) {
        Produto instanciaProduto = produto.toModel();
        repository.save(instanciaProduto);
        return ProdutoFormRequest.fromModel(instanciaProduto);
    }

    @PutMapping("{id}")
    public ResponseEntity <Void> atualizar (@PathVariable Long id, @RequestBody ProdutoFormRequest produto){
        Optional<Produto> produtoExistente = repository.findById(id);
        if(produtoExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Produto entidade = produto.toModel();
        entidade.setId(id);
        repository.save(entidade);

        return ResponseEntity.ok().build();
    }
}
