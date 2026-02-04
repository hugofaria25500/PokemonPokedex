import { useState } from "react";
import { useLocation } from "react-router";

import pokeballIcon from  "../resources/img/icons/app_icon.png";
import homeIcon from "../resources/img/icons/home_icon.png";
import pokedexIcon from "../resources/img/icons/pokedex_icon.png";
import tradingCardIcon from "../resources/img/icons/trading_cards_icon.png";
import gamesIcon from "../resources/img/icons/games_icon.png";
import pokemonTvIcon from "../resources/img/icons/pokemon_tv_icon.png";
import eventsIcon from "../resources/img/icons/pokemon_events_icon.png";
import projectIcon from "../resources/img/icons/project_icon.png";
import NavbarOption from "./NavbarOption.jsx";

import { PAGE_CONFIG } from "../js/location.js";

import "../css/BurguerMenu.css";

function BurguerMenu() {
    const [isOpen, setIsOpen] = useState(false);
    const location = useLocation();

    const currentPage = PAGE_CONFIG[location.pathname];

    return (
        <>
            {/* MOBILE TOP BAR */}
            <div className="mobile-bar-container">
                <div className="mobile-title-container">
                    {currentPage && (
                        <>
                            <img src={currentPage.icon} alt={currentPage.label}
                                className="mobile-title-icon"
                            />
                            <span>{currentPage.label}</span>
                        </>
                    )}
                </div>

                <div className="burguer-menu-container">
                    <img src={pokeballIcon} alt="Pokeball"
                        onClick={() => setIsOpen(prev => !prev)}
                    />
                </div>
            </div>

            {/* MOBILE DROPDOWN MENU */}
            <nav className={`mobile-menu ${isOpen ? "active" : ""}`}>
                <NavbarOption icon={homeIcon} label="Home" path="/" onClick={() => setIsOpen(false)} />
                <NavbarOption icon={pokedexIcon} label="Pokédex" path="/pokedex" onClick={() => setIsOpen(false)} />
                <NavbarOption icon={tradingCardIcon} label="Trading Cards" disabled />
                <NavbarOption icon={gamesIcon} label="Video Games" disabled />
                <NavbarOption icon={pokemonTvIcon} label="Pokemon TV" disabled />
                <NavbarOption icon={eventsIcon} label="Events" disabled />
                <NavbarOption icon={projectIcon} label="Project" path="/project" onClick={() => setIsOpen(false)} />
            </nav>
        </>
    );
}

export default BurguerMenu;