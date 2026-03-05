import pokeballIcon from "../resources/img/icons/pokeball_icon.png";
import filterIcon from "../resources/img/icons/arrow_down_icon.png";
import refreshIcon from "../resources/img/icons/refresh_icon.png";

import "../css/SearchBar.css";

function SearchBar({ filterOpen, setFilterOpen, filters, setFilters, onSearch }) {

    {/*SEARCH BAR CONTAINER COMPONENT*/}    
    return (
        <div className="search-bar-container">
            <div className="search-bar">
                <input
                    type="text"
                    className="search-input"
                    placeholder="Search Pokémon..."
                    value={filters.searchTerm || ""}
                    onChange={(e) =>
                        setFilters(prev => ({
                            ...prev,
                            searchTerm: e.target.value
                        }))
                    }
                />
                <div className="search-button-container" onClick={onSearch}>
                    <img className="search-bar-icon" src={pokeballIcon} alt="Pokeball Icon" />
                </div>
            </div>

            {/*MANIPULATE THE ARROW ICON BASED ON IF SELECT OPTIONS ARE VISIBLE OR NOT - MOBILE*/}    
            <div className="filter-button-container" onClick={() => setFilterOpen(!filterOpen)}>
                <img id="icon" className={filterOpen ? "open" : ""} src={filterIcon} alt="Filter Icon" />
            </div>

            <div className="refresh-button-container">
                <img id="icon" src={refreshIcon} alt="Refresh Icon" />
            </div>
        </div>
        
    );
}

export default SearchBar;