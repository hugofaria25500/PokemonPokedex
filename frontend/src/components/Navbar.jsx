import homeIcon from "../resources/img/icons/home_icon.png";
import pokedexIcon from "../resources/img/icons/pokedex_icon.png";
import tradingCardIcon from "../resources/img/icons/trading_cards_icon.png";
import gamesIcon from "../resources/img/icons/games_icon.png";
import pokemonTvIcon from "../resources/img/icons/pokemon_tv_icon.png";
import eventsIcon from "../resources/img/icons/pokemon_events_icon.png";
import projectIcon from "../resources/img/icons/project_icon.png";
import NavbarOption from "./NavbarOption.jsx";
import BurguerMenu from "./BurguerMenu.jsx";

import "../css/Navbar.css"

function Navbar({selectedNavBarOption}) {

    {/*CREATING THE NAVBAR SECTION BY PASSING THE NAVBAR OPTION DYNAMICALLY*/}
    return (    
        <div className="navbar-wrapper">

            {/* NAVBAR DESKTOP */}
            <nav className="navbar-container">
                <NavbarOption icon={homeIcon} label="Home" />
                <NavbarOption icon={pokedexIcon} label="Pokédex"/>
                <NavbarOption icon={tradingCardIcon} label="Trading Cards" disabled={true}/>
                <NavbarOption icon={gamesIcon} label="Video Games" disabled={true}/>
                <NavbarOption icon={pokemonTvIcon} label="Pokemon TV" disabled={true}/>
                <NavbarOption icon={eventsIcon} label="Events" disabled={true}/>
                <NavbarOption icon={projectIcon} label="Project" />  
            </nav>

            {/* MOBILE MENU */}
            <div className="mobile-menu-container">
                <BurguerMenu selectedOption={selectedNavBarOption}/>
            </div>

        </div>
    );
}

export default Navbar;