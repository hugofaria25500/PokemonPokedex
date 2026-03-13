import { useEffect, useState } from "react";
import { getPokemons } from "../services/pokemonService";

export function usePokemons(filters = {}) {
  const [pokemonList, setPokemonList] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [offset, setOffset] = useState(0);
  const [resetTrigger, setResetTrigger] = useState(0);

  const {
    searchTerm = "",
    type = null,
    region = null,
    sort = null
  } = filters;

  const loadMore = () => {
    setOffset(prev => prev + 50);
  };

  const fetchAll = async () => {
    if(loading) return;

    setLoading(true);
    try {
      const data = await getPokemons(offset, searchTerm, type, region, sort);
      setPokemonList(prev => offset === 0 ? data : [...prev, ...data]);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    setOffset(0);
    setPokemonList([]);
    setResetTrigger(prev => prev + 1);
  }, [
    filters.searchTerm,
    filters.type,
    filters.region,
    filters.sort
  ]);

  useEffect(() => {
    fetchAll();
  }, [offset, resetTrigger]);

  return {
    pokemonList,
    loading,
    loadMore,
    offset
  };
}