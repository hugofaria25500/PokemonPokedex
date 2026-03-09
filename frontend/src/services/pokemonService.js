export async function getPokemons(offset, searchTerm, type, region, sort) {
    const params = new URLSearchParams();

    params.append("offset", offset);
    if (searchTerm) params.append("searchTerm", searchTerm);
    if (region) params.append("region", region);
    if (sort) params.append("sort", sort);
    if (type) params.append("type", type);
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

