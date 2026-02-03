import "../css/AbilityBox.css"

function AbilityBox(props) {
    {/*ADDING DINAMIC BACKGROUND COLOR BASED ON POKEMON TYPE*/}
    return (
       <div className="ability-container">
            <span
                style={{
                    background:`${props.color}40`
                }}>{props.ability.name}</span>
            <p>{props.ability.description}</p>
       </div> 
    ); 
}

export default AbilityBox;