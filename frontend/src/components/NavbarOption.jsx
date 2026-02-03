import "../css/NavbarOption.css";

function NavbarOption({ icon, label, disabled = false }) {
    {/*NAVBAR OPTION BUILDING*/}
    return (
        <div className={`navbar-option-container ${disabled ? 'disabled' : ''}`}>
            <img className="navbar-icon" src={icon} alt={label} />
            <span>{label}</span>
        </div>
    );
}

export default NavbarOption;