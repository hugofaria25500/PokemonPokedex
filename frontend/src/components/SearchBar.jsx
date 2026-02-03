import pokeballIcon from "../resources/img/icons/pokeball_icon.png";

import "../css/SearchBar.css";

function SearchBar() {
    return (
        <div className="search-bar-container">
            <input
                type="text"
                className="search-input"
                placeholder="Search Pokémon..."
            />
            <div className="search-button-container">
                <img className="navbar-icon" src={pokeballIcon} alt="Pokeball Icon" />
            </div>
        </div>
    );
}

export default SearchBar;