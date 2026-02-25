import { useAllPokemons } from "../hooks/usePokemon.js";
import PokemonSearchBar from "../components/PokemonSearchBar.jsx";
import PokemonGrid from "../components/PokemonGrid.jsx";

function PokedexPage() {
    {/*POKEMON PAGE - INSTANTIATING COMPONETNS*/}    
    return (
        <>
            <PokemonSearchBar />
            <PokemonGrid pokemons={useAllPokemons().pokemonList} />
        </>
    );
}

export default PokedexPage;