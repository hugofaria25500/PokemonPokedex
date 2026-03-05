export async function getPokemons(offset, searchTerm, type, generation, sort) {
    const params = new URLSearchParams();

    params.append("offset", offset);

    if (searchTerm) params.append("search", searchTerm);
    if (type) params.append("type", type);
    if (generation) params.append("generation", generation);
    if (sort) params.append("sort", sort);

    console.log("Fetching Pokémons with params:", params.toString());

    const response = await fetch(`http://localhost:8080/api/pokemon/?${params.toString()}`);

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

