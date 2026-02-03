import "../css/StatBar.css";

function StatBar({ label, value, max = 150, color}) {
    {/*CALCULATING THE PERCENTAGE AMOUNT OF THE BAR*/}    
    const percentage = Math.min((value / max) * 100, 100);

    return (
        <div className="stat-bar">
            {/*STAT BAR INFO*/}    
            <div className="stat-header">
                <span className="stat-label">{label}</span>
                <span className="stat-value">{value}</span>
            </div>

            {/*CLASS WHERE THE MAGIC HAPPEN - ANIMATION EFFECT TO FILL THE POKEMON STATS*/}    
            <div className="stat-track">
                <div className="stat-fill"
                    style={{width: `${percentage}%`, background: `linear-gradient(90deg,${color},${color}cc)`}}/>
            </div>
        </div>
    );
}

export default StatBar;
