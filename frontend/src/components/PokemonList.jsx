import PokemonCard from "./PokemonCard";

function PokemonList({ pokemons }) {
    return (
        <div className="pokemon-grid">
            <div className="pokemon-list">
                {/* 
                {pokemons.map((pokemon) => (
                    <PokemonCard key={pokemon.id} pokemon={pokemon} />
                ))}*/}
            </div>
            <div className="selected-pokemon-box">
                {/* <PokemonSelected pokemon={pokemons[0]} />*/}
            </div> 
        </div>
  );
}
export default PokemonList;
