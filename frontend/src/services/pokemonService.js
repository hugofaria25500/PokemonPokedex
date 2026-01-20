export async function getPokemonById(id) {
  const response = await fetch(`http://localhost:8080/api/pokemon/${id}`);

  if (!response.ok) {
    throw new Error("Erro ao buscar Pokémon");
  }

  return response.json();
}
