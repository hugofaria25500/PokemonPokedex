import PokemonList from "./PokemonList";
import PokemonSelected from "./PokemonSelected";

import "../css/PokemonGrid.css"

function PokemonGrid({ pokemons }) {
    {/*SIMPLE COMPONENT TO THE POKEMON LIST COMPONENT*/}
    return (
        <div className="pokemon-grid-container">
            <PokemonList pokemons={pokemons} />
        </div>
    );
}

export default PokemonGrid;