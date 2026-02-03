import "../css/StatBar.css";

function StatBar({ label, value, max = 150, color}) {
    const percentage = Math.min((value / max) * 100, 100);

    return (
        <div className="stat-bar">
            <div className="stat-header">
                <span className="stat-label">{label}</span>
                <span className="stat-value">{value}</span>
            </div>

            <div className="stat-track">
                <div className="stat-fill"
                    style={{width: `${percentage}%`, background: `linear-gradient(90deg,${color},${color}cc)`}}/>
            </div>
        </div>
    );
}

export default StatBar;
