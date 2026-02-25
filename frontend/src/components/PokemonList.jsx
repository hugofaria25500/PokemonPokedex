import PokemonCard from "./PokemonCard";
import LoadingSpinner from "../components/LoadingSpinner.jsx";
import ErrorBox from "../components/ErrorBox.jsx";

import "../css/PokemonList.css"

function PokemonList({ pokemons, loading, error }) {
    {/*COMPONENT TO ITERATE EACH POKEMON AND PREPARE IT TO BUILD*/}
    if (loading) {
        return <LoadingSpinner />;
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
            <PokemonCard key={pokemon.id} pokemon={pokemon} />
        ))}
        </div>
    );

}
export default PokemonList;
