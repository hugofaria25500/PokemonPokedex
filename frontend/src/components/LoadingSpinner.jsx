import "../css/LoadingSpinner.css";
import LoadingIcon from "../resources/img/icons/app_icon.png";

function LoadingSpinner({ type }) {
    {/*LOADING COMPONENT*/}
    return (
        <div className={`loading-spinner-container ${type}`}>
            <img src={LoadingIcon} alt="Loading" />       
        </div>
    );
}

export default LoadingSpinner;