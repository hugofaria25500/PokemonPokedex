import React from "react";
import SelectOption from "./SelectOption";
import ArrowUpIcon from "../resources/img/icons/arrow_up_icon.png";
import ArrowDownIcon from "../resources/img/icons/arrow_down_icon.png";

function SelectMenu({ label }) {
    return (
        <div className="select-menu">
            <span>{label}</span>
            <div className="arrow-container">
                <img src={ArrowDownIcon} alt="Arrow Down" />
            </div>

            <div className="select-options">
                <SelectOption label="Option 1" icon="" onClick={() => {}} />;
            </div>

        </div>
    );
}

export default SelectMenu;