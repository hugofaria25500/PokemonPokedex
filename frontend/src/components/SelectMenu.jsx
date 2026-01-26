import { useState } from "react";
import SelectOption from "./SelectOption";
import ArrowDownIcon from "../resources/img/icons/arrow_down_icon.png";

function SelectMenu({label, icon, options}) {
    const [open, setOpen] = useState(false);

    return (
        <div className="select-menu">
            <div className="select-trigger" onClick={() => setOpen(!open)}>
                <div className="label-box">
                    <div className="iconType">
                        <img src={icon} alt={label} />
                    </div>
                    <span>{label}</span>
                </div>

                <div className={`select-arrow ${open ? "open" : ""}`}>
                    <img src={ArrowDownIcon} alt="Arrow Down" />
                </div>
            </div>

            <div className={`select-options ${open ? "active" : ""}`}>
                {options.map((option, index) => (
                    <SelectOption 
                        key={index}             
                        label={option}
                        icon=""
                        onClick={() => {}} />
                ))}
            </div>

        </div>
    );
}

export default SelectMenu;