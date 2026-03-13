import "../css/ErrorBox.css";
import pokemonIcon from "../resources/img/icons/app_icon.png";

function ErrorBox({type, error }) {
    {/*DYNAMIC ERROR BOX TO HANDLE ERROS*/}
    return (
        <div className={`error-box ${type === "pokemon-list" ? "pokemon-list" : "selected-pokemon"}`}>
            <p>{error}</p>
            <div className="pokemmon-image-container"> 
                <img src={pokemonIcon} alt="Pokemon Icon" className="pokemon-icon" />
            </div>
        </div>
    );
}

export default ErrorBox;