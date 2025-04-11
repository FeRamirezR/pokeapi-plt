--tabla de auditoria
-- Esta tabla se utiliza para registrar los cambios realizados en las tablas principales
-- de la base de datos. Cada vez que se realiza una operación de inserción, actualización o eliminación,
-- se registra un nuevo registro en esta tabla con la información relevante.
CREATE TABLE IF NOT EXISTS audit_log (
    id SERIAL PRIMARY KEY,
    table_name VARCHAR(100),
    record_id VARCHAR(50),
    action VARCHAR(10), -- INSERT, UPDATE, DELETE
    changed_data TEXT,
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    changed_by VARCHAR(50) DEFAULT 'system'
);
