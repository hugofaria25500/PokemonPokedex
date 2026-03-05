import { useEffect, useState } from "react";
import { getPokemons } from "../services/pokemonService";

export function usePokemons({filters = {}}) {
  const [pokemonList, setPokemonList] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [offset, setOffset] = useState(0);

  const {
    searchTerm = "",
    type = null,
    generation = null,
    sort = null
  } = filters;

  const fetchAll = async () => {
    if(loading) return;

    setLoading(true);
    try {
      const data = await getPokemons(offset, searchTerm, type, generation, sort);
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

  useEffect(() => {
    fetchAll();
  }, [offset, filters.searchTerm, filters.type, filters.generation, filters.sort]);

   useEffect(() => {
    setOffset(0);
    setPokemonList([]);
  }, [filters.searchTerm, filters.type, filters.generation, filters.sort]);

  return {
    pokemonList,
    loading,
    error,
    loadMore,
    offset
  };
}