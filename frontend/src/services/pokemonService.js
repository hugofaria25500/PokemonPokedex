export async function getPokemonById(id) {
  const response = await fetch(`http://localhost:8080/api/pokemon/${id}`);

  if (!response.ok) {
    throw new Error("Error fetching Pokémon with ID: " + id);
  }

  return response.json();
}

export async function getAllPokemons() {
  const response = await fetch(`http://localhost:8080/api/pokemon/`);

  if (!response.ok) {
    throw new Error("Error fetching all Pokémons");
  }

  return response.json();
}

