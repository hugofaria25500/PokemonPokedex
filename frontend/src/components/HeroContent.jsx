import "../css/HeroContent.css";

function HeroContent () {
    return (
        <>
            <h3 className="label">Pokédex</h3>
            <h1 className="main-title">Discovery Every Pokémon in <span>One</span> Place</h1>
            <h4 className="sub-title">Explore stats, types and regions in a modern Pokédex</h4>

            <div className="button-container">
                <a href="/pokedex">Explore Pokédex</a>
            </div>
        </>
    );
}

export default HeroContent;