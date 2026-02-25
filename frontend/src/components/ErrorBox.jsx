import "../css/ErrorBox.css";
import pokemonIcon from "../resources/img/icons/app_icon.png";

function ErrorBox({ error }) {
    return (
        <div className="error-box">
            <p>{error}</p>
            <div className="pokemmon-image-container"> 
                <img src={pokemonIcon} alt="Pokemon Icon" className="pokemon-icon" />
            </div>
        </div>
    );
}

export default ErrorBox;