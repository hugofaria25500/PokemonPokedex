import React from "react";

function SelectOption({ label, onClick, icon }) {
    return (
        <div className="select-option" onClick={onClick}>
            <img src={icon} alt={label} className="select-option-icon" /> 
            <span>{label}</span>
        </div>
    );
}

export default SelectOption;