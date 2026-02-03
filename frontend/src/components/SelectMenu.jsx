import { useState } from "react";
import SelectOption from "./SelectOption";
import ArrowDownIcon from "../resources/img/icons/arrow_down_icon.png";

import "../css/SelectMenu.css"

function SelectMenu({label, icon, options}) {
    {/*CREATING STATE TO MANIPULATE THE SELECT OPTIONS - OPEN/CLOSED */}    
    const [open, setOpen] = useState(false);

    {/*SELECT MENU COMPONENT RESPONSIBLE TO LIST THE MENU OPTIONS*/}    
    return (
        <div className="select-menu">
            {/*LOGIC TO OPEN/CLOSE THE SELECT OPTIONS*/}    
            <div className="select-trigger" onClick={() => setOpen(!open)}>
                <div className="label-box">
                    <div className="iconType">
                        <img src={icon} alt={label} />
                    </div>
                    <span>{label}</span>
                </div>

                {/*MANIPULATE THE ARROW ICON BASED ON IF SELECT OPTIONS ARE VISIBLE OR NOT*/}    
                <div className={`select-arrow ${open ? "open" : ""}`}>
                    <img src={ArrowDownIcon} alt="Arrow Down" />
                </div>
            </div>
            
            {/*LOGIC TO THE BEHAVIOR BEHIND A SELECTED OPTION */}    
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