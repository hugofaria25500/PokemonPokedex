
import SelectMenu from "./SelectMenu";
import RefreshIcon from "../resources/img/icons/refresh_icon.png";
import SortByIcon from "../resources/img/icons/sort_by_icon.png";
import typeIcon from "../resources/img/icons/type_icon.png";
import generationIcon from "../resources/img/icons/generation_icon.png";
import regionIcon from "../resources/img/icons/region_icon.png";

import { sortByFilterOptions, typeFilterOptions, generationFilterOptions, regionFilterOptions } from "../js/data";

import "../css/FilterBox.css";

function FilterBox({ filterOpen }) {

    {/*CREATING THE FILTER SECTION BY PASSING THE SELECT MENU DYNAMICALLY*/}
    return (
        <div className={`filter-box-container ${filterOpen ? "open" : ""}`}>
            <SelectMenu label="Sort By" icon={SortByIcon} options={sortByFilterOptions} />
            <SelectMenu label="Type" icon={typeIcon} options={typeFilterOptions} />
            <SelectMenu label="Generation" icon={generationIcon} options={generationFilterOptions} />
            <SelectMenu label="Region" icon={regionIcon} options={regionFilterOptions} />
            <div className="refresh-container">
                <img className="refresh-icon" src={RefreshIcon} alt="Refresh" />
            </div>
        </div>
    );  
}

export default FilterBox;