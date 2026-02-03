import { BrowserRouter, Routes, Route } from "react-router-dom";
import PokemonPage from "./pages/PokedexPage";

import "./css/App.css";

{/*POKEMON PAGE */}    
function App() {
    return ( 
        <div className="app">
            {/*MAPPING THE APP ROUTES - NAVIGATION*/}    
            <BrowserRouter>
                <Routes>
                  <Route path="/" element={<PokemonPage />} />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;

