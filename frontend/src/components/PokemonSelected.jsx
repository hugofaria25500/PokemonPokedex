import StatBar from "./StatBar";
import AbilityBox from "./AbilityBox";
import { typeColors } from "../js/data";
import { usePokemon } from "../hooks/usePokemon.js";
import LoadingSpinner from "../components/LoadingSpinner.jsx";
import ErrorBox from "../components/ErrorBox.jsx";

import "../css/PokemonSelected.css";
import EvolutionChainBox from "./EvolutionChainBox";

function PokemonSelected({ selectedId }) {

    const { pokemon, loading, error } = usePokemon(selectedId);
   
    if (loading) {
        return <LoadingSpinner />;
    }

    if (error) {
        return <ErrorBox error={error} />;
    }

    if (!pokemon) {
        return <ErrorBox error={"ERROR: No pokemon found. Try searching for another pokemon."} />;
    }

     {/*COMPONENT TO ITERATE EACH POKEMON AND PREPARE IT TO BUILD*/}
    const mainType = pokemon?.types[0].toLowerCase();
    const barColor = typeColors[mainType] || typeColors["normal"];
    const imageTypePath = "/img/types/"+mainType+"_type_logo.png";

    {/*MAIN COMPONENT TO CONSTRUCT THE SELECTED POKEMON*/}
    return (
        <div className="pokemon-selected-card">
            {/*POKEMON VISUAL CARD*/}
            <img className="type-logo" src={pokemon?.typeUrl} />
            <div className="card-base">

                <div className="id-box">
                <p>#{pokemon?.id}</p>
                </div>

                <div className="frame-box">
                    <img id="frame-logo" src={imageTypePath}/>
                    <img src={pokemon?.imageUrl}/>
                </div>

                <div className="label-box"> 
                    <p id="pokemon-name-label">{pokemon?.name}</p>
                    <div className="type-badge-box">
                    {pokemon?.types.map((type, index) => (
                        <p key={index} className={`type-badge ${type.toLowerCase()}-type-badge`}>
                        {type}
                        </p>))}
                    </div>
                </div>
            </div>
                    
            {/*ABOUT SECTION*/}        
            <div className="about">

                <h3 className="label-text">About</h3>
                <p id="pokemon-description">{pokemon?.about?.description}</p>
                
                <div className="stats">

                    <div className="region-container">
                            <h3>{pokemon?.about?.region}</h3>
                            <p>Region</p>
                    </div>

                    <div className="body-stats-container">
                    
                    <div className="height-container">
                        <h3>{pokemon?.about?.height}</h3>
                        <p>Height</p>
                    </div>

                    <div className="weight-container">
                        <h3>{pokemon?.about?.weight}</h3>
                        <p>Weight</p>
                    </div>
                    
                    </div>
                </div>
            </div>

            {/*BASE STATS OF THE POKEMON*/}    
            <div className="base-stats">
            
                <h3>Base Stats</h3>

                <StatBar label="HP" value={pokemon?.stats?.hp} color={barColor} />
                <StatBar label="Attack" value={pokemon?.stats?.attack} color={barColor} />
                <StatBar label="Defense" value={pokemon?.stats?.defense} color={barColor} />
                <StatBar label="Sp. Atk" value={pokemon?.stats?.specialAttack} color={barColor} />
                <StatBar label="Sp. Def" value={pokemon?.stats?.specialDefense} color={barColor} />
                <StatBar label="Speed" value={pokemon?.stats?.speed} color={barColor} />

            </div>

            {/*LIST OF ABILITIES OF THE POKEMON*/}    
            <div className="abilities">
                <h3>Abilities</h3>

                {pokemon?.abilities?.map((ability, index) => (
                    <AbilityBox key={index} ability={ability} color={barColor} />
                ))}
            </div>

            {/*EVOLUTION CHAIN OF THE POKEMON - ITERATING THE EVOLUTION CHAIN ARRAY'S*/}    
            <div className="evolution-chain">
                <h3>Evolution Chain</h3>
                {pokemon?.evolutionChain?.map((evolution, index) => (
                    <EvolutionChainBox key={index} evolutionChain={evolution} />
                ))}
            </div>
        </div>
    );
}

export default PokemonSelected;