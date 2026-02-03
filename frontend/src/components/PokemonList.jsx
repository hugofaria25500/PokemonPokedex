import PokemonCard from "./PokemonCard";
import PokemonSelected from "./PokemonSelected";

import {selectedPokemon2}  from "../js/data.js";

import "../css/PokemonList.css"

function PokemonList({ pokemons }) {
    {/*COMPONENT TO ITERATE EACH POKEMON AND PREPARE IT TO BUILD*/}
    return (
        <div className="pokemon-grid">
            <div className="pokemon-list">
                {pokemons.map((pokemon) => (
                    <PokemonCard key={pokemon.id} pokemon={pokemon} />
                ))}
            </div>
            <div className="selected-pokemon-box">
                <PokemonSelected pokemon={selectedPokemon2} />
            </div> 
        </div>
  );
}
export default PokemonList;
