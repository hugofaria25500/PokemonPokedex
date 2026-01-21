import { pokemonData } from "../js/data.js";
import PokemonCard from "../components/PokemonCard";

function PokemonPage() {

  return (
    <div className="pokemon-grid">
      {pokemonData.map((pokemon) => (
        <PokemonCard
          key={pokemon.id}
          pokemon={pokemon}
        />
      ))}
    </div>
  );
}

export default PokemonPage;