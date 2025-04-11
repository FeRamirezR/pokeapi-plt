-- Tabla principal de pokemones
CREATE TABLE IF NOT EXISTS pokemon (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    height INT,
    weight INT,
    base_experience INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT 'system',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50) DEFAULT 'system'
);

-- Tipos

CREATE TABLE IF NOT EXISTS type (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT 'system',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50) DEFAULT 'system'
);

-- Habilidades

CREATE TABLE IF NOT EXISTS ability (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT 'system',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50) DEFAULT 'system'
);

-- Relación pokemon-tipo
CREATE TABLE IF NOT EXISTS pokemon_type (
    pokemon_id INT REFERENCES pokemon(id) ON DELETE CASCADE,
    type_id INT REFERENCES type(id) ON DELETE CASCADE,
    slot INT,
    PRIMARY KEY (pokemon_id, type_id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT 'system',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50) DEFAULT 'system'
);

-- Relación pokemon-ability
CREATE TABLE IF NOT EXISTS pokemon_ability (
    pokemon_id INT REFERENCES pokemon(id) ON DELETE CASCADE,
    ability_id INT REFERENCES ability(id) ON DELETE CASCADE,
    slot INT,
    is_hidden BOOLEAN,
    PRIMARY KEY (pokemon_id, ability_id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT 'system',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50) DEFAULT 'system'
);
