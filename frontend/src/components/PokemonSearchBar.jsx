import SearchBar from "./SearchBar";
import FilterBox from "./FilterBox";

import "../css/PokemonPage.css";

function PokemonSearchBar() {
  return (
    <div className="pokemon-search-bar-container">
      <SearchBar />
      <FilterBox />
    </div>
  );
}

export default PokemonSearchBar;