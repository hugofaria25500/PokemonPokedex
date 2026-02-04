import { NavLink } from "react-router-dom";

import "../css/NavbarOption.css";

function NavbarOption({ icon, label, path, disabled = false }) {
    console.log(path);

    if (disabled) {
        return (
            <div className="navbar-option-container disabled">
                <img className="navbar-icon" src={icon} alt={label} />
                <span>{label}</span>
            </div>
        );
    }

    return (
        <NavLink to={path}
            className={({ isActive }) =>
                `navbar-option-container ${isActive ? "active" : ""}`
            }>
                
            <img className="navbar-icon" src={icon} alt={label} />
            <span>{label}</span>
        </NavLink>
    );
}

export default NavbarOption;