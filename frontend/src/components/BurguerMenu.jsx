import { useState } from "react";
import pokeballIcon from  "../resources/img/icons/app_icon.png";
import homeIcon from "../resources/img/icons/home_icon.png";
import pokedexIcon from "../resources/img/icons/pokedex_icon.png";
import tradingCardIcon from "../resources/img/icons/trading_cards_icon.png";
import gamesIcon from "../resources/img/icons/games_icon.png";
import pokemonTvIcon from "../resources/img/icons/pokemon_tv_icon.png";
import eventsIcon from "../resources/img/icons/pokemon_events_icon.png";
import projectIcon from "../resources/img/icons/project_icon.png";
import NavbarOption from "./NavbarOption.jsx";

import "../css/BurguerMenu.css";

function BurguerMenu(props) {
    const [isOpen, setIsOpen] = useState(false);

    return (
        <>
            <div className="mobile-bar">
                <div className="navbar-option-conainter">
                    <img src={props.icon} alt={props.option} />
                    <a href="#">{props.option}</a>
                </div>
                <div className="burguer-menu-container">
                    <img src={pokeballIcon} alt="Pokeball" onClick={() => setIsOpen()}/>
                </div>
            </div>

            {/* MOBILE DROPDOWN MENU */}
            <nav className={`mobile-menu ${isOpen ? "active" : ""}`}>
                <NavbarOption icon={homeIcon} label="Home" />
                <NavbarOption icon={pokedexIcon} label="Pokédex" />
                <NavbarOption icon={tradingCardIcon} label="Trading Cards" disabled />
                <NavbarOption icon={gamesIcon} label="Video Games" disabled />
                <NavbarOption icon={pokemonTvIcon} label="Pokemon TV" disabled />
                <NavbarOption icon={eventsIcon} label="Events" disabled />
                <NavbarOption icon={projectIcon} label="Project" />
            </nav>

        </>
    );
}

export default BurguerMenu;