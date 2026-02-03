import EvolutionChainPokemon from "./EvolutionChainPokemon";

import "../css/EvolutionChainBox.css"

function EvolutionChainBox (props) {
    return (
        <div className="evolution-chain-box-container">
            {props.evolutionChain.map((pokemon, index) => {
                const isLast = index === props.evolutionChain.length - 1;
                return (
                    <EvolutionChainPokemon key={index} evolutionPokemon={pokemon} isLast={isLast} /> 
                );       
        })}
        </div>
    );    
} 

export default EvolutionChainBox;