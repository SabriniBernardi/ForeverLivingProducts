package model;

import java.util.UUID;

/**
 * Representa o histórico de compras ou informações relevantes do cliente.
 */
public class Record {
    private UUID recordId;
    private String description;

    // Construtor para novo Record (gera novo UUID)
    public Record(String description) {
        this.recordId = UUID.randomUUID();
        this.description = description;
    }

    // Construtor para uso quando já se tem o UUID (ex: vindo do banco)
    public Record(UUID recordId, String description) {
        this.recordId = recordId;
        this.description = description;
    }

    public UUID getRecordId() {
        return recordId;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Histórico: " + description;
    }
}