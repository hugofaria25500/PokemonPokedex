function PokemonCard({ pokemon }) {
  return (
    <>
      <img src={pokemon.imageUrl} />
      <h3>{pokemon.name}</h3>
      <p>{pokemon.type}</p>
    </>
  );
}

export default PokemonCard;