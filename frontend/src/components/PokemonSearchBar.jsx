import SearchBar from "./SearchBar";
import FilterBox from "./FilterBox";

import "../css/PokemonSearchBar.css";

function PokemonSearchBar() {
    {/*SEARCH BAR COMPONENT - HIGH LEVEL*/}
    return (
        <div className="pokemon-search-bar-container">
            <SearchBar />
            <FilterBox />
        </div>
    );
}

export default PokemonSearchBar;