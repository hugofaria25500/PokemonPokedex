import { BrowserRouter, Routes, Route } from "react-router-dom";
import PokemonPage from "./pages/PokedexPage";
import "./css/App.css";

function App() {
  return ( 
    <div className="app">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<PokemonPage />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

