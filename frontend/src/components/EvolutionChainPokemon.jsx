import "../css/EvolutionChainPokemon.css"

function EvolutionChainPokemon (props) {

    console.log(props);
    
    return (
        <div className="evolution-chain-pokemon-container">
            <h3>{props.evolutionPokemon.name}</h3>
            {!props.isLast && <span className="arrow">--</span>}
        </div>
    );    
} 

export default EvolutionChainPokemon;