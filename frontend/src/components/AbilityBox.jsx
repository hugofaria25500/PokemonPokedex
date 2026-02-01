import "../css/AbilityBox.css"

function AbilityBox({ability}) {
    return (
       <div className="ability-container">
            <span>{ability.name}</span>
            <p>{ability.description}</p>
       </div> 
    ); 
}

export default AbilityBox;