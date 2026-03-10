import { useState } from "react";
import { usePokemons } from "../hooks/usePokemons.js";
import PokemonList from "./PokemonList";
import PokemonSelected from "./PokemonSelected";
import DeleteIcon from "../resources/img/icons/delete_icon.png";


import "../css/PokemonGrid.css"

function PokemonGrid({filters}) {
    const {pokemonList, loading, error, loadMore, offset} = usePokemons(filters);

    const [selectedId, setSelectedId] = useState(1);
    const [selectedPokemonOpen, setSelectedPokemonOpen] = useState(false);


    {/*SIMPLE COMPONENT TO THE POKEMON LIST COMPONENT*/}
    return (
        <div className="pokemon-grid-container">
            <div className="pokemon-grid">
                <PokemonList pokemons={pokemonList} loading={loading} error={error} onSelect={setSelectedId} selectedId={selectedId} loadMore={loadMore} setSelectedPokemonOpen={setSelectedPokemonOpen} offset={offset} />

                {/*DESKTOP VERSION*/}
                <div className="selected-pokemon-box">
                    <PokemonSelected type={"desktop"} selectedId={selectedId} />
                </div> 

                {/*MOBILE VERSION*/}
                {selectedPokemonOpen && (
                <div className="selected-pokemon-box-overlay">
                    <PokemonSelected type={"mobile"} selectedId={selectedId} />
                    <div className="close-container">
                        <img src={DeleteIcon} alt="Leave" onClick={() => setSelectedPokemonOpen(false)}/>
                    </div>
                </div> )}
            </div>
        </div>
    );
}

export default PokemonGrid;