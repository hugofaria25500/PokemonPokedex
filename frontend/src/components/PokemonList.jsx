import { useEffect } from "react";

import PokemonCard from "./PokemonCard";
import LoadingSpinner from "../components/LoadingSpinner.jsx";
import ErrorBox from "../components/ErrorBox.jsx";

import LoadIcon from "../resources/img/icons/plus_icon.png";
import "../css/PokemonList.css"

function PokemonList({ pokemons, loading, error, loadMore, offset, onSelect, setSelectedPokemonOpen, selectedId }) {

    useEffect(() => {
        if (offset === 0) return;

        const pokemon = pokemons[offset];
        if (!pokemon) return;
        const element = document.getElementById(`pokemon-${pokemon.id}`);

        if (element) {
            element.scrollIntoView({ behavior: "auto" });
        }

    }, [pokemons]);

    const handleLoadMore = () => {
        if (loading) return;
        loadMore();
    }

    {/*COMPONENT TO ITERATE EACH POKEMON AND PREPARE IT TO BUILD*/}
    if (loading) {
        return <LoadingSpinner type={"pokemon-list"} />;
    }

    if (error) {
        return <ErrorBox type={"pokemon-list"} error={error} />;
    }

    if (pokemons.length === 0) {
        return <ErrorBox type={"pokemon-list"} error={"ERROR: No pokemons found. Try searching for another name."} />;
    }

    return (
        <div className="pokemon-list">
            {pokemons.map((pokemon) => (
                <PokemonCard key={pokemon.id} pokemon={pokemon} setSelectedPokemonOpen={setSelectedPokemonOpen} onSelect={onSelect} selectedId={selectedId} />
            ))}
            {!pokemons[pokemons.length-1].last ? (
                <div className="load-more-container" onClick={handleLoadMore}>
                    <img src={LoadIcon} alt="Load More" />
                </div>
            ) : null}
        </div>
    );

}
export default PokemonList;
