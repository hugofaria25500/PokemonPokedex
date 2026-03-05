import { useState } from "react";

import PokemonSearchBar from "../components/PokemonSearchBar.jsx";
import PokemonGrid from "../components/PokemonGrid.jsx";

function PokedexPage() {

    const [filterOptions, setFilterOptions] = useState({
        searchTerm: "",
        type: null,
        generation: null,
        sort: null
    });

    {/*POKEMON PAGE - INSTANTIATING COMPONETNS*/}    
    return (
        <>
        <pre>{JSON.stringify(filterOptions, null, 2)}</pre>
            <PokemonSearchBar filterOptions={filterOptions} setFilterOptions={setFilterOptions} />
            <PokemonGrid filterOptions={filterOptions} />
        </>
    );
}

export default PokedexPage;