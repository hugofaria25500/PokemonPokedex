import "../css/SelectOption.css"

function SelectOption({ label, onClick, icon }) {
    {/*SELECT OPTION COMPONENT*/}    
    return (
        <div className="select-option" onClick={onClick}>
            {/*<img src={icon} alt={label} className="select-option-icon" /> */}
            <span>{label}</span>
        </div>
    );
}

export default SelectOption;