import { BrowserRouter, Routes, Route } from "react-router-dom";
import PokemonPage from "./pages/PokemonPage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<PokemonPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;

