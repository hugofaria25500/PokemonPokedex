import { useEffect, useState } from "react";
import { getPokemonDetailsById } from "../services/pokemonService";

export function usePokemonDetails(id) {
  const [detailedPokemon, setDetailedPokemon] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
  if (!id) return;

  const fetchData = async () => {

      setLoading(true);
      setError(null);

    try {
      const data = await getPokemonDetailsById(id);
      setDetailedPokemon(data);

    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  fetchData();
}, [id]);

  return { detailedPokemon, loading, error };
}