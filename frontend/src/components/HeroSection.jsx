import HeroContent from "../components/HeroContent";
import PokemonPreviewCard from "../components/PokemonPreviewCard";
import PokemonCardPreviewBulbasaur from "../resources/img/icons/pokemon_preview_1.png";
import PokemonCardPreviewCharmander from "../resources/img/icons/pokemon_preview_2.png";
import PokemonCardPreviewSquirtle from "../resources/img/icons/pokemon_preview_3.png";

import "../css/HeroSection.css";

function HeroSection () {
    return (
        <div className="hero-container">
            <div className="hero-content">
                <HeroContent />
            </div>

            <div className="pokemon-preview-container">
                <PokemonPreviewCard imgSource={PokemonCardPreviewBulbasaur} position={"left"} /> 
                <PokemonPreviewCard imgSource={PokemonCardPreviewCharmander} position={"center"} /> 
                <PokemonPreviewCard imgSource={PokemonCardPreviewSquirtle} position={"right"} /> 
            </div>
        </div>
    );
} 

export default HeroSection;