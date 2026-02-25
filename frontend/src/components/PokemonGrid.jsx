import { useAllPokemons } from "../hooks/usePokemon.js";
import PokemonList from "./PokemonList";
import PokemonSelected from "./PokemonSelected";
import {selectedPokemon}  from "../js/data.js";

import "../css/PokemonGrid.css"

function PokemonGrid() {
    const {pokemonList,loading,error} = useAllPokemons();

    {/*SIMPLE COMPONENT TO THE POKEMON LIST COMPONENT*/}
    return (
        <div className="pokemon-grid-container">
            <div className="pokemon-grid">
                <PokemonList pokemons={pokemonList} loading={loading} error={error} />
                <div className="selected-pokemon-box">
                    <PokemonSelected pokemon={selectedPokemon} />
                </div> 
            </div>
        </div>
    );
}

export default PokemonGrid;