-- Índices para optimizar búsqueda por nombre
CREATE INDEX IF NOT EXISTS idx_pokemon_name ON pokemon(name);
CREATE INDEX IF NOT EXISTS idx_type_name ON type(name);
CREATE INDEX IF NOT EXISTS idx_ability_name ON ability(name);
-- Índices para optimizar búsqueda por id
CREATE INDEX IF NOT EXISTS idx_pokemon_id ON pokemon(id);
CREATE INDEX IF NOT EXISTS idx_type_id ON type(id);
CREATE INDEX IF NOT EXISTS idx_ability_id ON ability(id);