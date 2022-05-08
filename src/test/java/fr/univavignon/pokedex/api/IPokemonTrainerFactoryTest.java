package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

    IPokedex pokedex;
    IPokemonTrainerFactory trainerFactory; ;
    IPokedexFactory factory;

    PokemonTrainer trainer;

    @Before
    public void init() {
        //La classe à mocker
        pokedex = Mockito.mock(IPokedex.class);
        trainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        factory = Mockito.mock(IPokedexFactory.class);

        // On init le trainer références
        trainer = new PokemonTrainer("Sacha", Team.MYSTIC, pokedex);
    }

    @Test
    public void createTrainerTest() {
        Mockito.doReturn(trainer).when(trainerFactory).createTrainer("Sacha", Team.MYSTIC, factory);

        //Instance de PokemonTrainer attendu
        Assert.assertEquals(trainer.getClass(), trainerFactory.createTrainer("Sacha", Team.MYSTIC, factory).getClass());

        //pTrainer attendu
        Assert.assertEquals(trainer, trainerFactory.createTrainer("Sacha", Team.MYSTIC, factory));

        //Sacha attendu
        Assert.assertEquals("Sacha",trainerFactory.createTrainer("Sacha", Team.MYSTIC, factory).getName());

        //Team MYSTIC attendue
        Assert.assertEquals(Team.MYSTIC, trainerFactory.createTrainer("Sacha", Team.MYSTIC, factory).getTeam());

        //Test du pokedex
        Assert.assertEquals(pokedex, trainerFactory.createTrainer("Sacha", Team.MYSTIC, factory).getPokedex());

        //Test de la taille du pokedex
        Assert.assertEquals(pokedex.size(), trainerFactory.createTrainer("Sacha", Team.MYSTIC, factory).getPokedex().size());
    }
}
