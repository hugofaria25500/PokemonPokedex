import FeatureCard from "../components/FeatureCard";

import "../css/FeatureSection.css"

function FeatureSection () {
    return (
        <div className="feature-container">
            <FeatureCard title={"Fast Search"} description={"Find any Pokémon instantly"}/>
            <FeatureCard title={"Detailed Stats"} description={"View stats, types, and abilities"}/>
            <FeatureCard title={"Filters"} description={"Browse Pokémon by region"}/>
            <FeatureCard title={"Modern UI"} description={"Clean interface inspired by Pokédex devices"}/>
        </div>
    );
} 

export default FeatureSection;