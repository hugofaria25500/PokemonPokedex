function PokemonCard({ pokemon }) {
  return (
    <div className="pokemon-card">
      <img src={pokemon.imageUrl} />
      <h3>{pokemon.name}</h3>
      <p>{pokemon.type}</p>
    </div>
  );
}

export default PokemonCard;