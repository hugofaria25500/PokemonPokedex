import "../css/LoadingSpinner.css";
import LoadingIcon from "../resources/img/icons/app_icon.png";

function LoadingSpinner() {
    return (
        <div className="loading-spinner-container">
            <img src={LoadingIcon} alt="Loading" />       
        </div>
    );
}

export default LoadingSpinner;