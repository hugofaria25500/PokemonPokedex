import "../css/PokemonPage.css";
import SelectMenu from "./SelectMenu";
import RefreshIcon from "../resources/img/icons/refresh_icon.png";


function FilterBox() {
    return (
        <div className="filter-box-container">
            <SelectMenu label="Sort By" />
            {/*
            <SelectMenu label="Generation" />
            <SelectMenu label="Region" />
            <SelectMenu label="Type" />
            */}
            <div className="refresh-container">
                <img className="refresh-icon" src={RefreshIcon} alt="Refresh" />
            </div>
        </div>
    );  
}

export default FilterBox;