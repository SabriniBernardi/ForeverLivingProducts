package dao;

import model.Disease;
import model.Supplement;
import java.sql.*;
import java.util.*;

/**
 * DAO para a entidade Disease.
 */
public class DiseaseDAO {

    private final Connection conn;
    private final SupplementDAO supplementDAO;

    public DiseaseDAO(Connection conn, SupplementDAO supplementDAO) {
        this.conn = conn;
        this.supplementDAO = supplementDAO;
    }

    // Insere uma doença e suas relações com suplementos
    public void insert(Disease disease) throws SQLException {
        String sql = "INSERT INTO disease (disease_id, disease_name) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, disease.getDiseaseId());
            stmt.setString(2, disease.getDiseaseName());
            stmt.executeUpdate();
        }
        // Supondo tabela de relação disease_supplement
        if (disease.getDiseaseSupplements() != null) {
            for (Supplement supp : disease.getDiseaseSupplements()) {
                String relSql = "INSERT INTO disease_supplement (disease_id, supplement_id) VALUES (?, ?)";
                try (PreparedStatement relStmt = conn.prepareStatement(relSql)) {
                    relStmt.setObject(1, disease.getDiseaseId());
                    relStmt.setObject(2, supp.getSupplementId());
                    relStmt.executeUpdate();
                }
            }
        }
    }

    // Busca uma doença pelo ID
    public Disease findById(UUID diseaseId) throws SQLException {
        String sql = "SELECT * FROM disease WHERE disease_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, diseaseId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    List<Supplement> supplements = getSupplementsForDisease(diseaseId);
                    return new Disease(
                            (UUID) rs.getObject("disease_id"),
                            rs.getString("disease_name"),
                            supplements
                    );
                }
            }
        }
        return null;
    }

    // Recupera os suplementos associados a uma doença
    private List<Supplement> getSupplementsForDisease(UUID diseaseId) throws SQLException {
        String sql = "SELECT supplement_id FROM disease_supplement WHERE disease_id = ?";
        List<Supplement> supplements = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, diseaseId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    UUID suppId = (UUID) rs.getObject("supplement_id");
                    Supplement supp = supplementDAO.findById(suppId);
                    if (supp != null) supplements.add(supp);
                }
            }
        }
        return supplements;
    }
}