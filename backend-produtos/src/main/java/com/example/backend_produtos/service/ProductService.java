
package com.example.backend_produtos.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.example.mercado.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@Service
public class ProductService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public void create(Product product) {
        String sql = "INSERT INTO produto (nome_do_produto, quantidade_estoque, preco_produto, valor_estoque) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getNomeProduto(), product.getQuantidadeEstoque(), product.getPrecoProduto(),
                product.getValorEstoque());
    }

    public List<Product> list() {
        String sql = "SELECT nome_do_produto, quantidade_estoque, preco_produto, valor_estoque FROM produto";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    public Product get(String nomeProduto) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("nome_do_produto", nomeProduto);
        return namedJdbcTemplate.queryForObject(
                "SELECT idproduto, nome_do_produto, quantidade_estoque, preco_produto, valor_estoque FROM produto WHERE nome_do_produto = :nome_do_produto",
                namedParameters, new ProductRowMapper());
    }

    public void remove(String nomeProduto) {
        String sql = "DELETE FROM produto WHERE nome_do_produto = ?";
        jdbcTemplate.update(sql, nomeProduto);
    }

    public void update(String nomeProduto, Product updatedProduct) {
        String sql = "UPDATE produto SET quantidade_estoque = ?, preco_produto = ?, valor_estoque = ? " +
                "WHERE nome_do_produto = ?";
        jdbcTemplate.update(sql,
                updatedProduct.getQuantidadeEstoque(),
                updatedProduct.getPrecoProduto(),
                updatedProduct.getValorEstoque(),
                nomeProduto);
    }

    private static class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setNomeProduto(rs.getString("nome_do_produto"));
            product.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
            product.setPrecoProduto(rs.getDouble("preco_produto"));
            product.setValorEstoque(rs.getDouble("valor_estoque"));
            return product;
        }
    }

}
