import { useState, useEffect, useRef} from "react";
import SelectOption from "./SelectOption";
import ArrowDownIcon from "../resources/img/icons/arrow_down_icon.png";

import "../css/SelectMenu.css"

function SelectMenu({label, icon, options}) {
    {/*CREATING STATE TO MANIPULATE THE SELECT OPTIONS - OPEN/CLOSED */}    
    const [labelState, setLabelState] = useState(label);
    const [iconState, setIconState] = useState(icon);
    const [open, setOpen] = useState(false);
    const selectRef = useRef(null);

    useEffect(() => {
        const handleClickOutside = (event) => {
            if (selectRef.current && !selectRef.current.contains(event.target)) {
                setOpen(false);
            }
        };

        document.addEventListener("mousedown", handleClickOutside);

        return () => {
            document.removeEventListener("mousedown", handleClickOutside);
        };
    }, []);

    {/*SELECT MENU COMPONENT RESPONSIBLE TO LIST THE MENU OPTIONS*/}    
    return (
        <div className="select-menu" ref={selectRef}>
            {/*LOGIC TO OPEN/CLOSE THE SELECT OPTIONS*/}    
            <div className="select-trigger" onClick={() => setOpen(!open)}>
                <div className="label-box">
                    <div className="iconType" >
                        <img src={iconState} alt={label} />
                    </div>
                    <span>{labelState}</span>
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
                        label={option.label}
                        icon={option.icon}
                        onClick={() => {setLabelState(option.label); setIconState(option.icon); setOpen(false);}} />
                ))}
            </div>

        </div>
    );
}

export default SelectMenu;