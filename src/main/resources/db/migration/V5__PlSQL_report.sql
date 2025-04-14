-- Reporte de Pokemones con Filtros

-- Función para filtrar por tipo de habilidad (nombre de la habilidad)
CREATE OR REPLACE FUNCTION get_pokemons_by_ability_name(p_ability_name VARCHAR)
RETURNS TABLE (
    pokemon_name VARCHAR,
    ability_name VARCHAR,
    type_name VARCHAR[]
) AS $$
BEGIN
    RETURN QUERY
    SELECT
        p.name AS pokemon_name,
        a.name AS ability_name,
        ARRAY_AGG(DISTINCT t.name) AS type_name
    FROM
        pokemon p
    JOIN
        pokemon_ability pa ON p.idpokemon = pa.idpokemon
    JOIN
        ability a ON pa.idability = a.idability
    LEFT JOIN
        pokemon_type pt ON p.idpokemon = pt.idpokemon
    LEFT JOIN
        type t ON pt.idtype = t.idtype
    WHERE
        LOWER(a.name) LIKE LOWER('%' || p_ability_name || '%')
    GROUP BY
        p.name, a.name
    ORDER BY
        p.name, a.name;
END;
$$ LANGUAGE plpgsql;

-- Función para filtrar por nombre de Pokémon
CREATE OR REPLACE FUNCTION get_pokemons_by_pokemon_name(p_pokemon_name VARCHAR)
RETURNS TABLE (
    pokemon_name VARCHAR,
    ability_name VARCHAR[],
    type_name VARCHAR[]
) AS $$
BEGIN
    RETURN QUERY
    SELECT
        p.name AS pokemon_name,
        ARRAY_AGG(DISTINCT a.name) AS ability_name,
        ARRAY_AGG(DISTINCT t.name) AS type_name
    FROM
        pokemon p
    LEFT JOIN
        pokemon_ability pa ON p.idpokemon = pa.idpokemon
    LEFT JOIN
        ability a ON pa.idability = a.idability
    LEFT JOIN
        pokemon_type pt ON p.idpokemon = pt.idpokemon
    LEFT JOIN
        type t ON pt.idtype = t.idtype
    WHERE
        LOWER(p.name) LIKE LOWER('%' || p_pokemon_name || '%')
    GROUP BY
        p.name
    ORDER BY
        p.name;
END;
$$ LANGUAGE plpgsql;

-- Función para filtrar por tipo de Pokémon (nombre del tipo)
CREATE OR REPLACE FUNCTION get_pokemons_by_type_name(p_type_name VARCHAR)
RETURNS TABLE (
    pokemon_name VARCHAR,
    type_name VARCHAR,
    ability_name VARCHAR[]
) AS $$
BEGIN
    RETURN QUERY
    SELECT
        p.name AS pokemon_name,
        t.name AS type_name,
        ARRAY_AGG(DISTINCT a.name) AS ability_name
    FROM
        pokemon p
    JOIN
        pokemon_type pt ON p.idpokemon = pt.idpokemon
    JOIN
        type t ON pt.idtype = t.idtype
    LEFT JOIN
        pokemon_ability pa ON p.idpokemon = pa.idpokemon
    LEFT JOIN
        ability a ON pa.idability = a.idability
    WHERE
        LOWER(t.name) LIKE LOWER('%' || p_type_name || '%')
    GROUP BY
        p.name, t.name
    ORDER BY
        p.name, t.name;
END;
$$ LANGUAGE plpgsql;

-- Función para obtener la información de todos los pokemones
CREATE OR REPLACE FUNCTION get_all_pokemons_report()
RETURNS TABLE (
    pokemon_name VARCHAR,
    height INT,
    weight INT,
    base_experience INT,
    abilities VARCHAR[],
    types VARCHAR[]
) AS $$
BEGIN
    RETURN QUERY
    SELECT
        p.name AS pokemon_name,
        p.height,
        p.weight,
        p.base_experience,
        ARRAY_AGG(DISTINCT ab.name) AS abilities,
        ARRAY_AGG(DISTINCT ty.name) AS types
    FROM
        pokemon p
    LEFT JOIN
        pokemon_ability pa ON p.idpokemon = pa.idpokemon
    LEFT JOIN
        ability ab ON pa.idability = ab.idability
    LEFT JOIN
        pokemon_type pt ON p.idpokemon = pt.idpokemon
    LEFT JOIN
        type ty ON pt.idtype = ty.idtype
    GROUP BY
        p.idpokemon, p.name, p.height, p.weight, p.base_experience
    ORDER BY
        p.name;
END;
$$ LANGUAGE plpgsql;

-- Ejemplos de uso de los reportes:

-- Obtener todos los pokemones con sus habilidades y tipos
-- SELECT * FROM get_all_pokemons_report();

-- Filtrar pokemones por nombre (ejemplo: que contenga "char")
-- SELECT * FROM get_pokemons_by_pokemon_name('char');

-- Filtrar pokemones por tipo de habilidad (ejemplo: que contenga "over")
-- SELECT * FROM get_pokemons_by_ability_name('over');

-- Filtrar pokemones por tipo de Pokémon (ejemplo: tipo "fire")
-- SELECT * FROM get_pokemons_by_type_name('fire');