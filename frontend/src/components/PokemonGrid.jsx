import PokemonList from "./PokemonList";
import PokemonSelected from "./PokemonSelected";

import "../css/PokemonGrid.css"

function PokemonGrid({ pokemons }) {
  return (
      <div className="pokemon-grid-container">
          <PokemonList pokemons={pokemons} />
      </div>
  );
}

export default PokemonGrid;