-- Tabla principal de pokemones
CREATE TABLE IF NOT EXISTS pokemon (
    idpokemon INT PRIMARY KEY,
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
    idtype SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT 'system',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50) DEFAULT 'system'
);

-- Habilidades
CREATE TABLE IF NOT EXISTS ability (
    idability SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT 'system',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50) DEFAULT 'system'
);

-- Relación pokemon-tipo
CREATE TABLE IF NOT EXISTS pokemon_type (
    idpokemontype INT PRIMARY KEY,
    idpokemon INT,
    idtype INT,
    slot INT,
    CONSTRAINT unique_pokemon_type UNIQUE (idpokemon, idtype),
    CONSTRAINT fk_pokemon_pokemon_type
        FOREIGN KEY (idpokemon)
        REFERENCES pokemon (idpokemon)
        ON DELETE CASCADE,
    CONSTRAINT fk_type_pokemon_type
        FOREIGN KEY (idtype)
        REFERENCES type (idtype)
        ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT 'system',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50) DEFAULT 'system'
);

-- Relación pokemon-ability
CREATE TABLE IF NOT EXISTS pokemon_ability (
    idpokemonability INT PRIMARY KEY,
    idpokemon INT,
    idability INT,
    slot INT,
    is_hidden BOOLEAN,
    CONSTRAINT unique_pokemon_ability UNIQUE (idpokemon, idability),
    CONSTRAINT fk_pokemon_pokemon_ability
        FOREIGN KEY (idpokemon)
        REFERENCES pokemon (idpokemon)
        ON DELETE CASCADE,
    CONSTRAINT fk_ability_pokemon_ability
        FOREIGN KEY (idability)
        REFERENCES ability (idability)
        ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT 'system',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(50) DEFAULT 'system'
);