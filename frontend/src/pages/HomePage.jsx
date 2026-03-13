import HeroSection from "../components/HeroSection";
import FeatureSection from "../components/FeatureSection";
import Logo from "../components/Logo";

function HomePage() {
    return (
        <div className="homepage-container">
            <HeroSection />
            <FeatureSection />
            <Logo />
        </div>
    );
}

export default HomePage;