package fr.univavignon.pokedex.api;

public class PokemonFactoryImpl implements IPokemonFactory {
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata metadata = new PokemonMetadataProviderImpl().getPokemonMetadata(index);
        return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(), cp,hp,dust,candy,0.0);
    }
}
