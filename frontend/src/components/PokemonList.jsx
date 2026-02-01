import PokemonCard from "./PokemonCard";
import PokemonSelected from "./PokemonSelected";

import {selectedPokemon}  from "../js/data.js";

function PokemonList({ pokemons }) {
    return (
        <div className="pokemon-grid">
            <div className="pokemon-list">
                {pokemons.map((pokemon) => (
                    <PokemonCard key={pokemon.id} pokemon={pokemon} />
                ))}
            </div>
            <div className="selected-pokemon-box">
                <PokemonSelected pokemon={selectedPokemon} />
            </div> 
        </div>
  );
}
export default PokemonList;
