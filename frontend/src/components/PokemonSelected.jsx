function PokemonSelected({ pokemon }) {
  return (
    <div className="pokemon-selected-card">
      <div className="card-frame">
        <img src={pokemon.imageUrl} alt={pokemon.name} />
      </div>
      <div className="minimal-stats">
        <h2>#{pokemon.id}</h2>
        <h2>{pokemon.name}</h2>
        <h2>{pokemon.type}</h2>
      </div>
      <div className="about">
        <h3>About</h3>
      </div>
      <div className="base-stats">
        <h3>Base Stats</h3>
      </div>
      <div className="abilities">
        <h3>Abilities</h3>
      </div>
      <div className="evolution-chain">
        <h3>Evolution Chain</h3>
      </div>
    </div>
  );
}

export default PokemonSelected;