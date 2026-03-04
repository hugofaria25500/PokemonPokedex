import EvolutionChainPokemon from "./EvolutionChainPokemon";

import "../css/EvolutionChainBox.css"

function EvolutionChainBox (props) {
    {/*ITERATING EACH POKEMON EVOLUTION AND BUILDING IT*/}
    return (
        <div className="evolution-chain-box-container">
            {props.evolutionChain.evolutionList.map((pokemon, index) => {
                const isLast = index === props.evolutionChain.evolutionList.length - 1;
                return (
                    <EvolutionChainPokemon key={index} evolutionPokemon={pokemon} isLast={isLast} /> 
                );       
        })}
        </div>
    );    
} 

export default EvolutionChainBox;