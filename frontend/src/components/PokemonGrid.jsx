import { useState } from "react";
import { useAllPokemons } from "../hooks/usePokemon.js";
import PokemonList from "./PokemonList";
import PokemonSelected from "./PokemonSelected";

import "../css/PokemonGrid.css"

function PokemonGrid() {
    const {pokemonList,loading,error} = useAllPokemons();

    const [selectedId, setSelectedId] = useState(1);

    {/*SIMPLE COMPONENT TO THE POKEMON LIST COMPONENT*/}
    return (
        <div className="pokemon-grid-container">
            <div className="pokemon-grid">
                <PokemonList pokemons={pokemonList} loading={loading} error={error} onSelect={setSelectedId} />
                <div className="selected-pokemon-box">
                    <PokemonSelected selectedId={selectedId} />
                </div> 
            </div>
        </div>
    );
}

export default PokemonGrid;