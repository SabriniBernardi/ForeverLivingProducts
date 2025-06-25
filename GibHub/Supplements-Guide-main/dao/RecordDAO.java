package dao;

import model.Record;
import java.sql.*;
import java.util.UUID;

/**
 * DAO para a entidade Record.
 */
public class RecordDAO {

    private final Connection conn;

    public RecordDAO(Connection conn) {
        this.conn = conn;
    }

    // Insere um novo record
    public void insert(Record record) throws SQLException {
        String sql = "INSERT INTO record (record_id, description) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, record.getRecordId());
            stmt.setString(2, record.getDescription());
            stmt.executeUpdate();
        }
    }

    // Busca um record pelo ID
    public Record findById(UUID recordId) throws SQLException {
        String sql = "SELECT * FROM record WHERE record_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, recordId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Record(
                            (UUID) rs.getObject("record_id"),
                            rs.getString("description")
                    );
                }
            }
        }
        return null;
    }

    // Exemplo: Deleta um record pelo ID
    public void delete(UUID recordId) throws SQLException {
        String sql = "DELETE FROM record WHERE record_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, recordId);
            stmt.executeUpdate();
        }
    }
}