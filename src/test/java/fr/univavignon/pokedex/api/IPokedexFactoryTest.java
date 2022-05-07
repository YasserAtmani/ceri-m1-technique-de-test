package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory;
    PokemonMetadata aquali;
    PokemonMetadata bulbizarre;

    @Before
    public void init() {
        //La classe à mocker
        pokedexFactory = Mockito.mock(IPokedexFactory.class);

        //Pokemons de reference
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100);
        bulbizarre =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

    }

    @Test
    public void createPokedexTest() {
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        //Accepte n'importe quelle instance de PokemonMetadataProvider ou PokemonFactory
        Mockito.doReturn(Mockito.mock(IPokedex.class)).when(pokedexFactory).createPokedex(Mockito.any(pokemonMetadataProvider.getClass()), Mockito.any(pokemonFactory.getClass()));
        //Vérificaton sur un retour non null
        Assert.assertNotNull(pokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class)));
        //Instance de IPokedex attendue
        Assert.assertEquals(Mockito.mock(IPokedex.class).getClass(), pokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class)).getClass());
    }
}