-- Función para insertar en audit_log
CREATE OR REPLACE FUNCTION log_pokemon_changes() RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'DELETE') THEN
        INSERT INTO audit_log (table_name, record_id, action, changed_data)
        VALUES ('pokemon', OLD.idpokemon::TEXT, TG_OP, row_to_json(OLD)::TEXT);
        RETURN OLD;
    ELSIF (TG_OP = 'UPDATE') THEN
        INSERT INTO audit_log (table_name, record_id, action, changed_data)
        VALUES ('pokemon', NEW.idpokemon::TEXT, TG_OP, row_to_json(NEW)::TEXT);
        RETURN NEW;
    ELSIF (TG_OP = 'INSERT') THEN
        INSERT INTO audit_log (table_name, record_id, action, changed_data)
        VALUES ('pokemon', NEW.idpokemon::TEXT, TG_OP, row_to_json(NEW)::TEXT);
        RETURN NEW;
    END IF;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION log_type_changes() RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'DELETE') THEN
        INSERT INTO audit_log (table_name, record_id, action, changed_data)
        VALUES ('type', OLD.idtype::TEXT, TG_OP, row_to_json(OLD)::TEXT);
        RETURN OLD;
    ELSIF (TG_OP = 'UPDATE') THEN
        INSERT INTO audit_log (table_name, record_id, action, changed_data)
        VALUES ('type', NEW.idtype::TEXT, TG_OP, row_to_json(NEW)::TEXT);
        RETURN NEW;
    ELSIF (TG_OP = 'INSERT') THEN
        INSERT INTO audit_log (table_name, record_id, action, changed_data)
        VALUES ('type', NEW.idtype::TEXT, TG_OP, row_to_json(NEW)::TEXT);
        RETURN NEW;
    END IF;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION log_ability_changes() RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'DELETE') THEN
        INSERT INTO audit_log (table_name, record_id, action, changed_data)
        VALUES ('ability', OLD.idability::TEXT, TG_OP, row_to_json(OLD)::TEXT);
        RETURN OLD;
    ELSIF (TG_OP = 'UPDATE') THEN
        INSERT INTO audit_log (table_name, record_id, action, changed_data)
        VALUES ('ability', NEW.idability::TEXT, TG_OP, row_to_json(NEW)::TEXT);
        RETURN NEW;
    ELSIF (TG_OP = 'INSERT') THEN
        INSERT INTO audit_log (table_name, record_id, action, changed_data)
        VALUES ('ability', NEW.idability::TEXT, TG_OP, row_to_json(NEW)::TEXT);
        RETURN NEW;
    END IF;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

-- Eliminar triggers si ya existen y crearlos nuevamente

-- Trigger para la tabla pokemon
DO $$
BEGIN
    IF EXISTS (SELECT 1 FROM pg_trigger WHERE tgname = 'trg_audit_pokemon') THEN
        DROP TRIGGER trg_audit_pokemon ON pokemon;
    END IF;
END;
$$;

CREATE TRIGGER trg_audit_pokemon
AFTER INSERT OR UPDATE OR DELETE ON pokemon
FOR EACH ROW
EXECUTE FUNCTION log_pokemon_changes();

-- Trigger para la tabla type
DO $$
BEGIN
    IF EXISTS (SELECT 1 FROM pg_trigger WHERE tgname = 'trg_audit_type') THEN
        DROP TRIGGER trg_audit_type ON type;
    END IF;
END;
$$;

CREATE TRIGGER trg_audit_type
AFTER INSERT OR UPDATE OR DELETE ON type
FOR EACH ROW
EXECUTE FUNCTION log_type_changes();

-- Trigger para la tabla ability
DO $$
BEGIN
    IF EXISTS (SELECT 1 FROM pg_trigger WHERE tgname = 'trg_audit_ability') THEN
        DROP TRIGGER trg_audit_ability ON ability;
    END IF;
END;
$$;

CREATE TRIGGER trg_audit_ability
AFTER INSERT OR UPDATE OR DELETE ON ability
FOR EACH ROW
EXECUTE FUNCTION log_ability_changes();