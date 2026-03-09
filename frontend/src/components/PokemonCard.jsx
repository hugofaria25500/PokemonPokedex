import "../css/PokemonTypes.css"
import "../css/PokemonCard.css"
import { typeUrl } from "../js/typesImage.js";

function PokemonCard({ pokemon, onSelect, selectedId }) {

    {/*POKEMON CARD BUILDING*/}
    return (
        <div id={`pokemon-${pokemon.id}`} className={`pokemon-card ${selectedId == pokemon.id ? "selected" : ""}`} onClick={() => onSelect(pokemon.id)}>
            <img className="type-logo" src={typeUrl[pokemon.types[0].toLowerCase()]} />
            <div className="id-box">
                <p>#{pokemon.id}</p>
            </div>
            <div className="frame-box">
                <img src={pokemon.imageUrl} />
            </div>
            <div className="label-box">
                <p>{pokemon.name}</p>
                <div className="type-badge-box">
                    {pokemon.types.map((type, index) => (
                      <p key={index} className={`type-badge ${type.toLowerCase()}-type-badge`}> {type}</p>
                    ))}
                </div>
            </div>
        </div>
    );
}

export default PokemonCard;