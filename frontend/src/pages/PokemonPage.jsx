import { pokemonData } from "../js/data.js";
import React from "react";
import Navbar from "../components/Navbar.jsx";
import PokemonSearchBar from "../components/PokemonSearchBar.jsx";

import "../css/PokemonPage.css";

function PokemonPage() {
  return (
      <div>
         <Navbar />
         <PokemonSearchBar />
      </div>
  );
}

export default PokemonPage;