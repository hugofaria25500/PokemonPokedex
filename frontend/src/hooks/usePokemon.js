import { useEffect, useState } from "react";
import { getPokemonById } from "../services/pokemonService";
import { getAllPokemons } from "../services/pokemonService";

export function usePokemon(id) {
  const [pokemon, setPokemon] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  console.log("usePokemon called with id:", id); // Debug log

  useEffect(() => {
  if (!id) return;

  const fetchData = async () => {

      setLoading(true);
      setError(null);

    try {
      const data = await getPokemonById(id);
      setPokemon(data);

    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  fetchData();
}, [id]);

  return { pokemon, loading, error };
}

export function useAllPokemons() {
  const [pokemonList, setPokemonList] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const fetchAll = async () => {
    setLoading(true);
    try {
      const data = await getAllPokemons();
      setPokemonList(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  /*
  const fetchFiltered = async (filters) => {
    setLoading(true);
    try {
      const data = await getFilteredPokemons(filters);
      setPokemonList(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };*/

  useEffect(() => {
    fetchAll();
  }, []);

  return {
    pokemonList,
    loading,
    error,
    fetchAll
    //fetchFiltered,
  };
}