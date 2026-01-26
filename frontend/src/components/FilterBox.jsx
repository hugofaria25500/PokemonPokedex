import "../css/PokemonPage.css";
import SelectMenu from "./SelectMenu";
import RefreshIcon from "../resources/img/icons/refresh_icon.png";
import SortByIcon from "../resources/img/icons/sort_by_icon.png";
import typeIcon from "../resources/img/icons/type_icon.png";
import generationIcon from "../resources/img/icons/generation_icon.png";
import regionIcon from "../resources/img/icons/region_icon.png";


function FilterBox() {
    return (
        <div className="filter-box-container">
            <SelectMenu label="Sort By" icon={SortByIcon}/>
            <SelectMenu label="Type" icon={typeIcon}/>
            <SelectMenu label="Generation" icon={generationIcon}/>
            <SelectMenu label="Region" icon={regionIcon}/>
            <div className="refresh-container">
                <img className="refresh-icon" src={RefreshIcon} alt="Refresh" />
            </div>
        </div>
    );  
}

export default FilterBox;