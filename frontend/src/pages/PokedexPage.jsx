import { pokemonDataMock } from "../js/data.js";
import Navbar from "../components/Navbar.jsx";
import PokemonSearchBar from "../components/PokemonSearchBar.jsx";
import PokemonGrid from "../components/PokemonGrid.jsx";

import "../css/App.css";

function PokedexPage() {
    {/*POKEMON PAGE - INSTANTIATING COMPONETNS*/}    
    return (
        <>
            <PokemonSearchBar />
            <PokemonGrid pokemons={pokemonDataMock} />
        </>
    );
}

export default PokedexPage;