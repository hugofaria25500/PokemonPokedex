import StatBar from "./StatBar";
import AbilityBox from "./AbilityBox";
import { typeColors } from "../js/data";
import { usePokemonDetails } from "../hooks/usePokemonDetails.js";
import LoadingSpinner from "../components/LoadingSpinner.jsx";
import ErrorBox from "../components/ErrorBox.jsx";

import "../css/PokemonSelected.css";
import EvolutionChainBox from "./EvolutionChainBox";

function PokemonSelected({ selectedId }) {

    const { detailedPokemon, loading, error } = usePokemonDetails(selectedId);

    if (loading) {
        return <LoadingSpinner />;
    }

    if (error) {
        return <ErrorBox error={error} />;
    }

    if (!detailedPokemon) {
        return <ErrorBox error={"ERROR: No pokemon found. Try searching for another pokemon."} />;
    }

    {/*COMPONENT TO ITERATE EACH POKEMON AND PREPARE IT TO BUILD*/}
    const mainType = detailedPokemon?.types[0].toLowerCase();
    const barColor = typeColors[mainType] || typeColors["normal"];
    const imageTypePath = "/img/types/"+mainType+"_type_logo.png";

    {/*MAIN COMPONENT TO CONSTRUCT THE SELECTED POKEMON*/}
    return (
        <div className="pokemon-selected-card">
            {/*POKEMON VISUAL CARD*/}
            <img className="type-logo" src={imageTypePath} />
            <div className="card-base">

                <div className="id-box">
                <p>#{detailedPokemon?.id}</p>
                </div>

                <div className="frame-box">
                    <img id="frame-logo" src={imageTypePath}/>
                    <img src={detailedPokemon?.imageUrl}/>
                </div>

                <div className="label-box"> 
                    <p id="pokemon-name-label">{detailedPokemon?.name}</p>
                    <div className="type-badge-box">
                    {detailedPokemon?.types.map((type, index) => (
                        <p key={index} className={`type-badge ${type.toLowerCase()}-type-badge`}>
                        {type}
                        </p>))}
                    </div>
                </div>
            </div>
                    
            {/*ABOUT SECTION*/}        
            <div className="about">

                <h3 className="label-text">About</h3>
                <p id="pokemon-description">{detailedPokemon?.about?.description}</p>
                
                <div className="stats">

                    <div className="region-container">
                            <h3>{detailedPokemon?.about?.region}</h3>
                            <p>Region</p>
                    </div>

                    <div className="body-stats-container">
                    
                    <div className="height-container">
                        <h3>{detailedPokemon?.about?.height}m</h3>
                        <p>Height</p>
                    </div>

                    <div className="weight-container">
                        <h3>{detailedPokemon?.about?.weight}kg</h3>
                        <p>Weight</p>
                    </div>
                    
                    </div>
                </div>
            </div>

            {/*BASE STATS OF THE POKEMON*/}    
            <div className="base-stats">
            
                <h3>Base Stats</h3>

                {detailedPokemon?.statList?.map((stat, index) => (
                    <StatBar key={index} label={stat?.name} value={stat?.value} color={barColor} />
                ))}
            </div>

            {/*LIST OF ABILITIES OF THE POKEMON*/}    
            <div className="abilities">
                <h3>Abilities</h3>

                {detailedPokemon?.abilityList?.map((ability, index) => (
                    <AbilityBox key={index} ability={ability} color={barColor} />
                ))}
            </div>

            {/*EVOLUTION CHAIN OF THE POKEMON - ITERATING THE EVOLUTION CHAIN ARRAY'S*/}    
            <div className="evolution-chain">
                <h3>Evolution Chain</h3>
                {detailedPokemon?.evolutionChainList?.map((evolution, index) => (
                    <EvolutionChainBox key={index} evolutionChain={evolution} />
                ))}
            </div>
        </div>
    );
}

export default PokemonSelected;