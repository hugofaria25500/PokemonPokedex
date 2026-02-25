import PokemonCard from "./PokemonCard";
import LoadingSpinner from "../components/LoadingSpinner.jsx";
import ErrorBox from "../components/ErrorBox.jsx";

import "../css/PokemonList.css"

function PokemonList({ pokemons, loading, error }) {
    {/*COMPONENT TO ITERATE EACH POKEMON AND PREPARE IT TO BUILD*/}
    return (
        <div className="pokemon-list">
            {loading && <LoadingSpinner />}
            {error && <ErrorBox error={error} />}

            {pokemons.map((pokemon) => (
                <PokemonCard key={pokemon.id} pokemon={pokemon} />
            ))}
        </div>
  );
}
export default PokemonList;
