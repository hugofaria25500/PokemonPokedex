import PokemonCard from "./PokemonCard";

import "../css/PokemonList.css"

function PokemonList({ pokemons }) {
    {/*COMPONENT TO ITERATE EACH POKEMON AND PREPARE IT TO BUILD*/}
    return (
        <div className="pokemon-list">
            {pokemons.map((pokemon) => (
                <PokemonCard key={pokemon.id} pokemon={pokemon} />
            ))}
        </div>
  );
}
export default PokemonList;
