package dao;

import model.Seller;
import java.sql.*;
import java.util.UUID;

/**
 * DAO para a entidade Seller.
 */
public class SellerDAO {

    private final Connection conn;

    public SellerDAO(Connection conn) {
        this.conn = conn;
    }

    // Insere um novo vendedor
    public void insert(Seller seller) throws SQLException {
        String sql = "INSERT INTO seller (seller_id, seller_name, seller_login, seller_password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, seller.getSellerId());
            stmt.setString(2, seller.getSellerName());
            stmt.setString(3, seller.getSellerLogin());
            stmt.setString(4, seller.getSellerPassword());
            stmt.executeUpdate();
        }
    }

    // Busca vendedor pelo ID
    public Seller findById(UUID sellerId) throws SQLException {
        String sql = "SELECT * FROM seller WHERE seller_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, sellerId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Seller(
                            (UUID) rs.getObject("seller_id"),
                            rs.getString("seller_name"),
                            rs.getString("seller_login"),
                            rs.getString("seller_password")
                    );
                }
            }
        }
        return null;
    }

    // Busca vendedor pelo login
    public Seller findByLogin(String login) throws SQLException {
        String sql = "SELECT * FROM seller WHERE seller_login = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Seller(
                            (UUID) rs.getObject("seller_id"),
                            rs.getString("seller_name"),
                            rs.getString("seller_login"),
                            rs.getString("seller_password")
                    );
                }
            }
        }
        return null;
    }
}