import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from "./components/Layout";

import HomePage from "./pages/HomePage";
import PokedexPage from "./pages/PokedexPage";
import ProjectPage from "./pages/ProjectPage";

import "./css/App.css";

{/*POKEMON APP */}    
function App() {
    return ( 
        <div className="app">
            {/*MAPPING THE APP ROUTES - NAVIGATION*/}    
            <BrowserRouter>
                <Routes>

                    <Route path="/" element={
                        <Layout>
                            <HomePage />
                        </Layout>} />

                    <Route path="/pokedex" element={
                        <Layout>
                            <PokedexPage />
                        </Layout>} />

                    <Route path="/project" element={
                        <Layout>
                            <ProjectPage />
                        </Layout>} />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;