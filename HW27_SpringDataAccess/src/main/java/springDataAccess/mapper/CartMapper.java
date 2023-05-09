package springDataAccess.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import springDataAccess.dao.ProductDAO;
import springDataAccess.model.Cart;
import springDataAccess.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CartMapper implements RowMapper<Cart> {
    private  final ProductDAO productDAO;


    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cart cart = new Cart();
        cart.setId(rs.getLong("id"));

        long cartId = cart.getId();
        List<Product> products = productDAO.getAllByCartId(cartId);
        cart.setProducts(products);

        return cart;
    }
}
