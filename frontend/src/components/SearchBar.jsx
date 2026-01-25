import pokeballIcon from "../resources/img/icons/pokeball_icon.png";
import "../css/PokemonPage.css";

function SearchBar() {
    return (
        <div className="search-bar-container">
            <input
                type="text"
                className="search-input"
                placeholder="Search Pokémon..."
            />
            <img className="navbar-icon" src={pokeballIcon} alt="Pokeball Icon" />
        </div>
    );
}

export default SearchBar;