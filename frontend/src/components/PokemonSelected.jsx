function PokemonSelected({ pokemon }) {
  return (
    <div className="pokemon-selected">
      <img src={pokemon.imageUrl} />
      <h2>{pokemon.name}</h2>
      <p>Type: {pokemon.type}</p>
      <p>Abilities: {pokemon.abilities.join(", ")}</p>
      <p>Height: {pokemon.height}</p>
      <p>Weight: {pokemon.weight}</p>
    </div>
  );
}

export default PokemonSelected;