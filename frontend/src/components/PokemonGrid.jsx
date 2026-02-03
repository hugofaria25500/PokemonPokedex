import PokemonList from "./PokemonList";
import PokemonSelected from "./PokemonSelected";
import {selectedPokemon2}  from "../js/data.js";

import "../css/PokemonGrid.css"

function PokemonGrid({ pokemons }) {
    {/*SIMPLE COMPONENT TO THE POKEMON LIST COMPONENT*/}
    return (
        <div className="pokemon-grid-container">
            <div className="pokemon-grid">
                <PokemonList pokemons={pokemons} />
                <div className="selected-pokemon-box">
                    <PokemonSelected pokemon={selectedPokemon2} />
                </div> 
            </div>
        </div>
    );
}

export default PokemonGrid;