import { useEffect, useState } from "react";
import { getPokemons } from "../services/pokemonService";

export function usePokemons() {
  const [pokemonList, setPokemonList] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [offset, setOffset] = useState(0);

  const fetchAll = async () => {
    if(loading) return;

    setLoading(true);
    try {
      const data = await getPokemons(offset);
      setPokemonList(prev => offset === 0 ? data : [...prev, ...data]);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  const loadMore = () => {
    setOffset(prev => prev + 50);
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
  }, [offset]);

  return {
    pokemonList,
    loading,
    error,
    loadMore,
    offset
    //fetchFiltered,
  };
}