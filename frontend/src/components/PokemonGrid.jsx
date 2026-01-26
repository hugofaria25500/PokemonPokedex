import PokemonList from "./PokemonList";
import PokemonSelected from "./PokemonSelected";

function PokemonGrid({ pokemons }) {
  return (
    <div>
        <div className="pokemon-grid">
            <PokemonList pokemons={pokemons} />
        </div>
        {/* 
        <div>
            <PokemonSelected pokemon={pokemons[0]} />
        </div> */}
    </div>
  );
}

export default PokemonGrid;