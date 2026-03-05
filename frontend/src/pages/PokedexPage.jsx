import { useState } from "react";

import PokemonSearchBar from "../components/PokemonSearchBar.jsx";
import PokemonGrid from "../components/PokemonGrid.jsx";

function PokedexPage() {

    const [draftFilters, setDraftFilters] = useState({
        searchTerm: "",
        type: null,
        generation: null,
        sort: null
    });

    const [filters, setFilters] = useState({
        searchTerm: "",
        type: null,
        generation: null,
        sort: null
    });

    const handleSearch = () => {
        setFilters(draftFilters);
        console.log("Search initiated with filters:", draftFilters);
    };
    {/*POKEMON PAGE - INSTANTIATING COMPONETNS*/}    
    return (
        <>
            <PokemonSearchBar filters={draftFilters} setFilters={setDraftFilters} onSearch={handleSearch} />
            <PokemonGrid filters={filters} />
        </>
    );
}

export default PokedexPage;