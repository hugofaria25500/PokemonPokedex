import { usePokemon } from "../hooks/usePokemon";

function PokemonPage() {
  const { pokemon, loading, error } = usePokemon(1);

  if (loading) {
    return <p>Loading...</p>;
  }

  if (error) {
    return <p>Error: {error}</p>;
  }

  if (!pokemon) {
    return <p>No Pokémon data</p>;
  }
  
  return (
    <div>
      <h1>HEy</h1>

      <h1>{pokemon.name}</h1>

      <h2>{pokemon.id}</h2>

      <img
        src={pokemon.imageUrl}
        alt={pokemon.name}
        width={200}
      />
    </div>
  );
}

export default PokemonPage;