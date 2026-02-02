import StatBar from "./StatBar";
import AbilityBox from "./AbilityBox";
import { typeColors } from "../js/data";

import "../css/PokemonSelected.css";

function PokemonSelected(props) {

    const mainType = props.pokemon.types[0].toLowerCase();
    const barColor = typeColors[mainType] || typeColors["normal"];
    const imageTypePath = "/img/types/"+mainType+"_type_logo.png";

    return (
        <div className="pokemon-selected-card">
            <img className="type-logo" src={props.pokemon.typeUrl} />
            <div className="card-base">

                <div className="id-box">
                <p>#{props.pokemon.id}</p>
                </div>

                <div className="frame-box">
                    <img id="frame-logo" src={imageTypePath}/>
                    <img src={props.pokemon.imageUrl}/>
                </div>

                <div className="label-box"> 
                    <p id="pokemon-name-label">{props.pokemon.name}</p>
                    <div className="type-badge-box">
                    {props.pokemon.types.map((type, index) => (
                        <p key={index} className={`type-badge ${type.toLowerCase()}-type-badge`}>
                        {type}
                        </p>))}
                    </div>
                </div>
            </div>

            <div className="about">

                <h3 className="label-text">About</h3>
                <p id="pokemon-description">{props.pokemon?.about?.description}</p>
                
                <div className="stats">

                    <div className="region-container">
                            <h3>{props.pokemon.about.region}</h3>
                            <p>Region</p>
                    </div>

                    <div className="body-stats-container">
                    
                    <div className="height-container">
                        <h3>{props.pokemon.about.height}</h3>
                        <p>Height</p>
                    </div>

                    <div className="weight-container">
                        <h3>{props.pokemon.about.weight}</h3>
                        <p>Weight</p>
                    </div>
                    
                    </div>
                </div>
            </div>

            <div className="base-stats">
            
                <h3>Base Stats</h3>

                <StatBar label="HP" value={props.pokemon.stats.hp} color={barColor} />
                <StatBar label="Attack" value={props.pokemon.stats.attack} color={barColor} />
                <StatBar label="Defense" value={props.pokemon.stats.defense} color={barColor} />
                <StatBar label="Sp. Atk" value={props.pokemon.stats.specialAttack} color={barColor} />
                <StatBar label="Sp. Def" value={props.pokemon.stats.specialDefense} color={barColor} />
                <StatBar label="Speed" value={props.pokemon.stats.speed} color={barColor} />

            </div>

            <div className="abilities">
                <h3>Abilities</h3>

                {props.pokemon.abilities.map((ability) => (
                <AbilityBox ability={ability} color={barColor} />
                ))}
            </div>

            <div className="evolution-chain">
                <h3>Evolution Chain</h3>
            </div>
        </div>
    );
}

export default PokemonSelected;