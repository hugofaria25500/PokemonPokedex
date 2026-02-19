import sortIcon from "../resources/img/icons/sort_icon.png";
import sortAZIcon from "../resources/img/icons/sort_az_icon.png";
import regionIcon from "../resources/img/icons/region_icon.png";
import generationIcon from "../resources/img/icons/generation_icon.png";

/*SORT OPTIONS*/
export const sortOptions = [
  { value: "id-asc", label: "Id (Ascending)", icon: sortIcon },
  { value: "id-desc", label: "Id (Descending)", icon: sortIcon },
  { value: "name-asc", label: "Name (Ascending)", icon: sortAZIcon },
  { value: "name-desc", label: "Name (Descending)", icon: sortAZIcon },
];

/* TYPE OPTIONS */
export const typeOptions = [
  { value: "normal", label: "Normal", icon: "/img/types/normal_type_logo.png" },
  { value: "fire", label: "Fire", icon: "/img/types/fire_type_logo.png" },
  { value: "water", label: "Water", icon: "/img/types/water_type_logo.png" },
  { value: "electric", label: "Electric", icon: "/img/types/eletric_type_logo.png" },
  { value: "grass", label: "Grass", icon: "/img/types/grass_type_logo.png" },
  { value: "ice", label: "Ice", icon: "/img/types/ice_type_logo.png" },
  { value: "fighting", label: "Fighting", icon: "/img/types/fighting_type_logo.png" },
  { value: "poison", label: "Poison", icon: "/img/types/poison_type_logo.png" },
  { value: "ground", label: "Ground", icon: "/img/types/ground_type_logo.png" },
  { value: "flying", label: "Flying", icon: "/img/types/flying_type_logo.png" },
  { value: "psychic", label: "Psychic", icon: "/img/types/psychic_type_logo.png" },
  { value: "bug", label: "Bug", icon: "/img/types/bug_type_logo.png" },
  { value: "rock", label: "Rock", icon: "/img/types/rock_type_logo.png" },
  { value: "ghost", label: "Ghost", icon: "/img/types/ghost_type_logo.png" },
  { value: "dragon", label: "Dragon", icon: "/img/types/dragon_type_logo.png" },
  { value: "dark", label: "Dark", icon: "/img/types/dark_type_logo.png" },
  { value: "steel", label: "Steel", icon: "/img/types/steel_type_logo.png" },
  { value: "fairy", label: "Fairy", icon: "/img/types/fairy_type_logo.png" },
];

/*GENERATION OPTIONS*/
export const generationOptions = [
  { value: 1, label: "Generation I", icon:generationIcon},
  { value: 2, label: "Generation II", icon:generationIcon},
  { value: 3, label: "Generation III", icon:generationIcon},
  { value: 4, label: "Generation IV", icon:generationIcon},
  { value: 5, label: "Generation V", icon:generationIcon},
  { value: 6, label: "Generation VI", icon:generationIcon},
  { value: 7, label: "Generation VII", icon:generationIcon},
  { value: 8, label: "Generation VIII", icon:generationIcon},
  { value: 9, label: "Generation IX", icon:generationIcon},
];

/*REGION OPTIONS*/
export const regionOptions = [
  { value: "kanto", label: "Kanto", icon: regionIcon},
  { value: "johto", label: "Johto", icon: regionIcon},
  { value: "hoenn", label: "Hoenn", icon: regionIcon},
  { value: "sinnoh", label: "Sinnoh", icon: regionIcon},
  { value: "unova", label: "Unova", icon: regionIcon},
  { value: "kalos", label: "Kalos", icon: regionIcon},
  { value: "alola", label: "Alola", icon: regionIcon},
  { value: "galar", label: "Galar", icon: regionIcon},
  { value: "paldea", label: "Paldea", icon: regionIcon},
];
