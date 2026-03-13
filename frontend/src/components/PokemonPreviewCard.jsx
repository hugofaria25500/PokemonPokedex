import "../css/PokemonPreviewCard.css";

function PokemonPreviewCard ({imgSource, position}) {
    return (
        <div className={`pokemon-preview-card-container ${position}`}>
            <img src={imgSource} alt="Pokemon Card Preview Image" />
        </div>
    );
}

export default PokemonPreviewCard;