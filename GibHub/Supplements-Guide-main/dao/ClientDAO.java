package dao;

import model.Client;
import model.Disease;
import model.Record;
import java.sql.*;
import java.util.UUID;

// DAO para a entidade Client.
public class ClientDAO {

    private final Connection conn;
    private final DiseaseDAO diseaseDAO;
    private final RecordDAO recordDAO;

    public ClientDAO(Connection conn, DiseaseDAO diseaseDAO, RecordDAO recordDAO) {
        this.conn = conn;
        this.diseaseDAO = diseaseDAO;
        this.recordDAO = recordDAO;
    }

    // Insere um novo cliente no banco de dados
    public void insert(Client client) throws SQLException {
        String sql = "INSERT INTO client (" +
                "client_id, client_name, client_date_of_birth, client_gender, client_cpf, client_rg, " +
                "client_phone, client_email, client_cep, client_street, client_house_number, client_complement, " +
                "client_neighborhood, client_city, client_state, disease_id, record_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, client.getClientId());
            stmt.setString(2, client.getClientName());
            stmt.setString(3, client.getClientDateOfBirth());
            stmt.setString(4, client.getClientGender());
            stmt.setString(5, client.getClientCPF());
            stmt.setString(6, client.getClientRG());
            stmt.setString(7, client.getClientPhone());
            stmt.setString(8, client.getClientEmail());
            stmt.setString(9, client.getClientCEP());
            stmt.setString(10, client.getClientStreet());
            stmt.setString(11, client.getClientHouseNumber());
            stmt.setString(12, client.getClientComplement());
            stmt.setString(13, client.getClientNeighborhood());
            stmt.setString(14, client.getClientCity());
            stmt.setString(15, client.getClientState());
            stmt.setObject(16, client.getClientDisease() != null ? client.getClientDisease().getDiseaseId() : null);
            stmt.setObject(17, client.getClientRecord() != null ? client.getClientRecord().getRecordId() : null);
            stmt.executeUpdate();
        }
    }

    // Busca um cliente pelo ID
    public Client findById(UUID clientId) throws SQLException {
        String sql = "SELECT * FROM client WHERE client_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, clientId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Disease disease = null;
                    Record record = null;
                    UUID diseaseId = (UUID) rs.getObject("disease_id");
                    UUID recordId = (UUID) rs.getObject("record_id");
                    if (diseaseId != null) disease = diseaseDAO.findById(diseaseId);
                    if (recordId != null) record = recordDAO.findById(recordId);
                    return new Client(
                            (UUID) rs.getObject("client_id"),
                            rs.getString("client_name"),
                            rs.getString("client_date_of_birth"),
                            rs.getString("client_gender"),
                            rs.getString("client_cpf"),
                            rs.getString("client_rg"),
                            rs.getString("client_phone"),
                            rs.getString("client_email"),
                            rs.getString("client_cep"),
                            rs.getString("client_street"),
                            rs.getString("client_house_number"),
                            rs.getString("client_complement"),
                            rs.getString("client_neighborhood"),
                            rs.getString("client_city"),
                            rs.getString("client_state"),
                            disease,
                            record
                    );
                }
            }
        }
        return null;
    }

    // Metodo para deletar pelo ID
    public void delete(UUID clientId) throws SQLException {
        String sql = "DELETE FROM client WHERE client_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, clientId);
            stmt.executeUpdate();
        }
    }
}