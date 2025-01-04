package com.example.backend_produtos.controller;

import com.example.mercado.model.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend_produtos.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProductService productService;

    @PostMapping("/dashboard")
    public String postMethodName(@RequestBody Product product) {
        // TODO: process POST request
        productService.create(product);
        return "Produto Criado";
    }

    @PostMapping("/list")
    public List<Product> list() {
        return productService.list(); // Retorna a lista de produtos
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> remove(@RequestBody Product product) {
        productService.remove(product.getNomeProduto());
        return ResponseEntity.noContent().build(); // Retorna 204 se a remoção for bem-sucedida
    }

    @PostMapping("/get")
    public ResponseEntity<Product> get(@RequestBody Product product) {
        Product foundProduct = productService.get(product.getNomeProduto());
        if (foundProduct == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
        }
        return ResponseEntity.ok(foundProduct); // Retorna o produto com o status 200
    }

    // Endpoint para atualizar um produto (POST)
    @PostMapping("/update")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        productService.update(product.getNomeProduto(), product);
        return ResponseEntity.ok(product); // Retorna o produto atualizado com status 200
    }

}