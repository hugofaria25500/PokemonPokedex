function FeatureCard ({title, description}) {
    return (
        <div className="feature-card-container">
            <h4 className="card-title">{title}</h4>
            <span className="card-description">{description}</span>
        </div>
    );
}

export default FeatureCard;