import LogoImage from "../resources/img/icons/pokemon_logo.png";

import "../css/Logo.css"

function Logo () {
    return (
        <div className="logo-container">
            <img src={LogoImage} alt="Logo Image" />
        </div>
    );
}

export default Logo;