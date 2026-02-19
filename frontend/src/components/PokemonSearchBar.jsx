import { useState } from "react";

import SearchBar from "./SearchBar";
import FilterBox from "./FilterBox";

import "../css/PokemonSearchBar.css";

function PokemonSearchBar() {

    {/*CREATING STATE TO MANIPULATE THE FILTER OPTIONS - OPEN/CLOSED */}    
    const [filterOpen, setFilterOpen] = useState(false);

    {/*SEARCH BAR COMPONENT - HIGH LEVEL*/}
    return (
        <div className="pokemon-search-bar-container">
            <SearchBar filterOpen={filterOpen} setFilterOpen={setFilterOpen} />
            <FilterBox filterOpen={filterOpen} />
        </div>
    );
}

export default PokemonSearchBar;