package dao;

import model.Supplement;
import java.sql.*;
import java.util.UUID;

public class SupplementDAO {

    private final Connection conn;

    public SupplementDAO(Connection conn) {
        this.conn = conn;
    }

    // Insere um novo suplemento
    public void insert(Supplement supplement) throws SQLException {
        String sql = "INSERT INTO supplement (supplement_id, supplement_name) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, supplement.getSupplementId());
            stmt.setString(2, supplement.getSupplementName());
            stmt.executeUpdate();
        }
    }

    // Busca um suplemento pelo ID
    public Supplement findById(UUID supplementId) throws SQLException {
        String sql = "SELECT * FROM supplement WHERE supplement_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, supplementId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Supplement(
                            (UUID) rs.getObject("supplement_id"),
                            rs.getString("supplement_name")
                    );
                }
            }
        }
        return null;
    }

    // Deleta um suplemento pelo ID
    public void delete(UUID supplementId) throws SQLException {
        String sql = "DELETE FROM supplement WHERE supplement_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, supplementId);
            stmt.executeUpdate();
        }
    }
}