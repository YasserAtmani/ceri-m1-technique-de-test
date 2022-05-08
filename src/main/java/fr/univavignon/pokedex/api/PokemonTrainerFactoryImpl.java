package fr.univavignon.pokedex.api;

public class PokemonTrainerFactoryImpl implements IPokemonTrainerFactory {
    public PokemonTrainerFactoryImpl() {
    }
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokemonFactory factory = new PokemonFactoryImpl();
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProviderImpl();
        return new PokemonTrainer(name, team, pokedexFactory.createPokedex(metadataProvider, factory));
    }
}
