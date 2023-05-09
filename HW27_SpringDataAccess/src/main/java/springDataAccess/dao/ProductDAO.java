package springDataAccess.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import springDataAccess.mapper.ProductMapper;
import springDataAccess.model.Product;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ProductDAO {
    private final JdbcTemplate jdbcTemplate;
    private final ProductMapper productMapper;


    public Long add(Product product) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO product (product_name, price, cart_id) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, product.getName());
            ps.setBigDecimal(2, product.getPrice());
            ps.setLong(3, product.getCartId());

            return ps;
        }, keyHolder);

        return Objects.requireNonNull(keyHolder.getKey()).longValue();

    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM product WHERE id = ?", id);
    }


    public Product getById(Long id) {
        String SQLQuery = String.format("SELECT * FROM product WHERE id = %o", id);
        return jdbcTemplate.query(SQLQuery, productMapper).stream().findFirst().orElse(null);
    }

    public List<Product> getALL() {
        return jdbcTemplate.query("SELECT * FROM product", productMapper);
    }

    public List<Product> getAllByCartId(Long id) {
        String SQLQuery = String.format("SELECT * FROM product WHERE cart_id = %o", id);
        return jdbcTemplate.query(SQLQuery, productMapper);
    }
}
