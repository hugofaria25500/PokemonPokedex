import { pokemonData } from "../js/data.js";
import Navbar from "../components/Navbar.jsx";
import PokemonSearchBar from "../components/PokemonSearchBar.jsx";
import PokemonGrid from "../components/PokemonGrid.jsx";

import "../css/PokemonPage.css";
import "../css/App.css";

function PokemonPage() {
  return (
      <div className="page">
        <Navbar />
        <PokemonSearchBar />
        <PokemonGrid pokemons={pokemonData} />
      </div>
  );
}

export default PokemonPage;