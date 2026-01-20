import { useEffect, useState } from "react";
import { getPokemonById } from "../services/pokemonService";

export function usePokemon(id) {
  const [pokemon, setPokemon] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    getPokemonById(id)
      .then(setPokemon)
      .catch((err) => setError(err.message))
      .finally(() => setLoading(false));
  }, [id]);

  return { pokemon, loading, error };
}
