import { usePokemon } from "../hooks/usePokemon";

function PokemonPage() {
  const { pokemon, loading, error } = usePokemon(1);
  
  return (
    <div>
      <h1>{pokemon.name}</h1>

      <h2>{pokemon.id}</h1>

      <img
        src={pokemon.imageUrl}
        alt={pokemon.name}
        width={200}
      />
    </div>
  );
}

export default PokemonPage;