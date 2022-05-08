package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
    //Classe testée
    IPokemonFactory pokemonFactory;

    //Pokemons références
    Pokemon bulbizarre;
    Pokemon aquali ;


    @Before
    /*public void init() {
        //La classe à mocker
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        // On init les pokemons références
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100);
        bulbizarre =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    }*/

    public void init() {
        //La classe à mocker
        pokemonFactory = new PokemonFactoryImpl();
        // On init les pokemons références
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100);
        bulbizarre =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    }

    @Test
    public void createPokemonTest() throws PokedexException {
        //Création d'un Aquali si ces arguments sont rentrés
        //Mockito.when(pokemonFactory.createPokemon(133,2729, 202, 5000, 4)).thenReturn(aquali);
        //Création d'un Bulbizarre si ces arguments sont rentrés
        //Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);

        //Vérification de la correspondance entre les pokémons attendus et pokémons créés
        //Assert.assertEquals(aquali, pokemonFactory.createPokemon(133,2729, 202, 5000, 4));
        //Assert.assertEquals(bulbizarre, pokemonFactory.createPokemon(0, 613, 64, 4000, 4));

        Assert.assertEquals(aquali.getHp(), pokemonFactory.createPokemon(133,2729, 202, 5000, 4).getHp());
        Assert.assertEquals(bulbizarre.getHp(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getHp());

        Assert.assertEquals(aquali.getDust(), pokemonFactory.createPokemon(133,2729, 202, 5000, 4).getDust());
        Assert.assertEquals(bulbizarre.getDust(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getDust());

        Assert.assertEquals(aquali.getCandy(), pokemonFactory.createPokemon(133,2729, 202, 5000, 4).getCandy());
        Assert.assertEquals(bulbizarre.getCandy(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCandy());

        Assert.assertEquals(aquali.getIv(), pokemonFactory.createPokemon(133,2729, 202, 5000, 4).getIv(), 0.0);
        Assert.assertEquals(bulbizarre.getIv(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getIv(), 0.0);
    }
}
