
import SelectMenu from "./SelectMenu";
import DeleteIcon from "../resources/img/icons/delete_icon.png";
import SortByIcon from "../resources/img/icons/sort_by_icon.png";
import typeIcon from "../resources/img/icons/type_icon.png";
import regionIcon from "../resources/img/icons/region_icon.png";

import { sortOptions, typeOptions, regionOptions } from "../js/selectOptions";

import "../css/FilterBox.css";

function FilterBox({ filterOpen, filters, setFilters }) {

    {/*CREATING THE FILTER SECTION BY PASSING THE SELECT MENU DYNAMICALLY*/}
    return (
        <div className={`filter-box-container ${filterOpen ? "open" : ""}`}>
            <SelectMenu label="Sort By" icon={SortByIcon} options={sortOptions} value={filters.sort} onSelect={(value) => setFilters(prev => ({ ...prev, sort: value }))} />
            <SelectMenu label="Type" icon={typeIcon} options={typeOptions} value={filters.type} onSelect={(value) => setFilters(prev => ({ ...prev, type: value }))} />
            <SelectMenu label="Region" icon={regionIcon} options={regionOptions} value={filters.region} onSelect={(value) => setFilters(prev => ({ ...prev, region: value }))} />
            <div className="refresh-container">
                <img className="refresh-icon" src={DeleteIcon} alt="Refresh" onClick={() => setFilters(prev => ({ ...prev, searchTerm: "", type: null, region: null, sort: null }))} />
            </div>
        </div>
    );  
}

export default FilterBox;