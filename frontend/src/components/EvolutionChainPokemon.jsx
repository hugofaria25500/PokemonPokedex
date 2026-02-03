import NextEvolutionIcon from "../resources/img/icons/arrow_down_icon.png";
import "../css/EvolutionChainPokemon.css"

function EvolutionChainPokemon (props) {

    const mainType = props.evolutionPokemon.type[0].toLowerCase();
    const imageTypePath = "/img/types/"+mainType+"_type_logo.png";

    return (
        <div className="evolution-chain-pokemon-container">
            <img id="evolution-type-logo" src={imageTypePath} alt="" />
            <div className="frame-pokemon-image">
                <img className="pokemon-image" src={props.evolutionPokemon.imageUrl} alt={props.evolutionPokemon.name} />
            </div>
            <div className="pokemon-info">
                <p>{props.evolutionPokemon.name}</p>
                <span>#{props.evolutionPokemon.id}</span>
            </div>

            {!props.isLast && <div className="next-icon-container">
                    <img className="nextEvolution" src={NextEvolutionIcon} alt="" />
                </div>}
        </div>
    );    
} 

export default EvolutionChainPokemon;