package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProviderImpl implements IPokemonMetadataProvider {
    public static List<PokemonMetadata> pokemonsMetadata = new ArrayList<>();

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        try {
            return pokemonsMetadata.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new PokedexException("Erreur : pas dans la liste");
        }
    }
}
