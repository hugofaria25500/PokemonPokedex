import { useState, useEffect } from "react";
import { usePokemons } from "../hooks/usePokemons.js";
import PokemonList from "./PokemonList";
import PokemonSelected from "./PokemonSelected";

import "../css/PokemonGrid.css"

function PokemonGrid({filters}) {
    const {pokemonList, loading, error, loadMore, offset} = usePokemons(filters);

    const [selectedId, setSelectedId] = useState(1);

    {/*SIMPLE COMPONENT TO THE POKEMON LIST COMPONENT*/}
    return (
        <div className="pokemon-grid-container">
            <div className="pokemon-grid">
                <PokemonList pokemons={pokemonList} loading={loading} error={error} onSelect={setSelectedId} loadMore={loadMore} offset={offset} />
                <div className="selected-pokemon-box">
                    <PokemonSelected selectedId={selectedId} />
                </div> 
            </div>
        </div>
    );
}

export default PokemonGrid;