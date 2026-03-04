import { useEffect } from "react";

import PokemonCard from "./PokemonCard";
import LoadingSpinner from "../components/LoadingSpinner.jsx";
import ErrorBox from "../components/ErrorBox.jsx";

import LoadIcon from "../resources/img/icons/plus_icon.png";
import "../css/PokemonList.css"

function PokemonList({ pokemons, loading, error, loadMore, offset, onSelect }) {

    useEffect(() => {
        if (offset === 0) return;

        const element = document.getElementById(`pokemon-${offset}`);
        if (element) {
            element.scrollIntoView({ behavior: "auto" });
        }
    }, [pokemons, offset]);

    const handleLoadMore = () => {
        if (loading) return;
        loadMore();
    }

    {/*COMPONENT TO ITERATE EACH POKEMON AND PREPARE IT TO BUILD*/}
    if (loading) {
        return <LoadingSpinner type={"pokemon-list"} />;
    }

    if (error) {
        return <ErrorBox error={error} />;
    }

    if (pokemons.length === 0) {
        return <ErrorBox error={"ERROR: No pokemons found. Try searching for another name."} />;
    }

    return (
        <div className="pokemon-list">
            {pokemons.map((pokemon) => (
                <PokemonCard key={pokemon.id} pokemon={pokemon} onSelect={onSelect} />
            ))}
            <div className="load-more-container" onClick={handleLoadMore}>
                <img src={LoadIcon} alt="Load More" />
            </div>
        </div>
    );

}
export default PokemonList;
