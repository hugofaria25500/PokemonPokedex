import "../css/FeatureCard.css"

function FeatureCard ({title, description}) {
    {/*COMPONET FOR HOMEPAGE TO DISPLAY FEATURES - TEXT*/}
    return (
        <div className="feature-card-container">
            <h4 className="card-title">{title}</h4>
            <span className="card-description">{description}</span>
        </div>
    );
}

export default FeatureCard;