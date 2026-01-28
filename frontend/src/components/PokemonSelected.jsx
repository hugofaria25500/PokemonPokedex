import "../css/PokemonSelected.css"

function PokemonSelected({ pokemon }) {
  return (
    <div className="pokemon-selected-card">
      <div className="card-base">
        <img className="type-logo" src={pokemon.typeUrl} />
        <div className="id-box">
          <p>#{pokemon.id}</p>
        </div>
        <div className="frame-box">
          <img src={pokemon.imageUrl} />
        </div>
        <div className="label-box">
          <p>{pokemon.name}</p>
          <div className="type-badge-box">
            {pokemon.type.map((type, index) => (
              <p key={index} className={`type-badge ${type.toLowerCase()}-type-badge`}> {type}</p>
            ))}
          </div>
        </div>
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