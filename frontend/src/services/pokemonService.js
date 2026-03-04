export async function getPokemonById(id) {
  const response = await fetch(`http://localhost:8080/api/pokemon/${id}`);

  if (!response.ok) {
    throw new Error("Error fetching Pokémon with ID: " + id);
  }

  const data = await response.json();
  return data;
}

export async function getAllPokemons() {
  const response = await fetch(`http://localhost:8080/api/pokemon/`);

  if (!response.ok) {
    throw new Error("Error fetching all Pokémons");
  }

  const data = await response.json();
  return data;
}

export async function getPokemonDetailsById(id) {
  const response = await fetch(`http://localhost:8080/api/pokemon/details/${id}`);

  if (!response.ok) {
    throw new Error("Error fetching Pokémon with ID: " + id);
  }

  const data = await response.json();
  return data;
}

