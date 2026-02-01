import StatBar from "./StatBar";
import { typeColors } from "../js/data";

import "../css/PokemonSelected.css";
import GrassTypeImage from "../resources/img/types/grass_type_logo.png"

function PokemonSelected({ pokemon }) {

  const mainType = pokemon.types[0].toLowerCase();
  const barColor = typeColors[mainType] || typeColors["normal"];

  return (
    <div className="pokemon-selected-card">
        <img className="type-logo" src={pokemon.typeUrl} />
        <div className="card-base">

            <div className="id-box">
              <p>#{pokemon.id}</p>
            </div>

            <div className="frame-box">
                <img id="frame-logo" src={GrassTypeImage}/>
                <img src={pokemon.imageUrl}/>
            </div>

            <div className="label-box"> 
                <p id="pokemon-name-label">{pokemon.name}</p>
                <div className="type-badge-box">
                  {pokemon.types.map((type, index) => (
                    <p key={index} className={`type-badge ${type.toLowerCase()}-type-badge`}>
                      {type}
                    </p>))}
                </div>
            </div>
        </div>

        <div className="about">

            <h3 className="label-text">About</h3>
            <p id="pokemon-description">{pokemon?.about?.description}</p>
            
            <div className="stats">

                <div className="region-container">
                        <h3>{pokemon.about.region}</h3>
                        <p>Region</p>
                </div>

                <div className="body-stats-container">
                  
                  <div className="height-container">
                      <h3>{pokemon.about.height}</h3>
                      <p>Height</p>
                  </div>

                  <div className="weight-container">
                      <h3>{pokemon.about.weight}</h3>
                      <p>Weight</p>
                  </div>
                  
                </div>
            </div>
        </div>

        <div className="base-stats">
          
            <h3>Base Stats</h3>

            <StatBar label="HP" value={pokemon.stats.hp} color={barColor} />
            <StatBar label="Attack" value={pokemon.stats.attack} color={barColor} />
            <StatBar label="Defense" value={pokemon.stats.defense} color={barColor} />
            <StatBar label="Sp. Atk" value={pokemon.stats.specialAttack} color={barColor} />
            <StatBar label="Sp. Def" value={pokemon.stats.specialDefense} color={barColor} />
            <StatBar label="Speed" value={pokemon.stats.speed} color={barColor} />

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