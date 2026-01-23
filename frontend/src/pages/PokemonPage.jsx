import { pokemonData } from "../js/data.js";
import PokemonCard from "../components/PokemonCard";
import "../css/PokemonPage.css";

function PokemonPage() {
  return (
      <div>
        <nav className="navbar-container">
          <h1>Pokémon Gallery</h1>
        </nav>

        <div className="pokemon-grid">
          {pokemonData.map((pokemon) => (
            <PokemonCard
              key={pokemon.id}
              pokemon={pokemon}
            />
          ))}
        </div>

      </div>
  );
}

export default PokemonPage;