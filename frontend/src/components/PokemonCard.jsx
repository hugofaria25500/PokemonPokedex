import "../css/PokemonTypes.css"
import "../css/PokemonCard.css"

function PokemonCard({ pokemon }) {
  return (
    <div className="pokemon-card">
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
  );
}

export default PokemonCard;