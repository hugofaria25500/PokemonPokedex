import { pokemonDataMock } from "../js/data.js";
import Navbar from "../components/Navbar.jsx";
import PokemonSearchBar from "../components/PokemonSearchBar.jsx";
import PokemonGrid from "../components/PokemonGrid.jsx";

import "../css/App.css";

function PokemonPage() {
    {/*POKEMON PAGE - INSTANTIATING COMPONETNS*/}    
    return (
        <div className="page-container">
            <Navbar />
            <PokemonSearchBar />
            <PokemonGrid pokemons={pokemonDataMock} />
        </div>
    );
}

export default PokemonPage;