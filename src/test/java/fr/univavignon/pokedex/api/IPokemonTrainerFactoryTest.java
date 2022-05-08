package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

    PokedexImpl pokedex;
    IPokemonTrainerFactory trainerFactory; ;
    PokedexFactoryImpl factory;
    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;
    PokemonTrainer trainer;

    @Before
    public void init() {
        //La classe à mocker
        pokedex = new PokedexImpl(pokemonMetadataProvider, pokemonFactory);
        trainerFactory = new PokemonTrainerFactoryImpl();
        factory = new PokedexFactoryImpl();

        // On init le trainer références
        trainer = new PokemonTrainer("Sacha", Team.MYSTIC, pokedex);
    }

    /*public void init() {
        //La classe à mocker
        pokedex = Mockito.mock(IPokedex.class);
        trainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        factory = Mockito.mock(IPokedexFactory.class);

        // On init le trainer références
        trainer = new PokemonTrainer("Sacha", Team.MYSTIC, pokedex);


    }*/

    @Test
    public void createTrainerTest() {
        //Mockito.doReturn(trainer).when(trainerFactory).createTrainer("Sacha", Team.MYSTIC, factory);

        //Instance de PokemonTrainer attendu
        Assert.assertEquals(trainer.getClass(), trainerFactory.createTrainer("Sacha", Team.MYSTIC, factory).getClass());

        //Sacha attendu
        Assert.assertEquals("Sacha",trainerFactory.createTrainer("Sacha", Team.MYSTIC, factory).getName());

        //Team MYSTIC attendue
        Assert.assertEquals(Team.MYSTIC, trainerFactory.createTrainer("Sacha", Team.MYSTIC, factory).getTeam());

        //Test de la taille du pokedex
        Assert.assertEquals(pokedex.size(), trainerFactory.createTrainer("Sacha", Team.MYSTIC, factory).getPokedex().size());
    }
}
