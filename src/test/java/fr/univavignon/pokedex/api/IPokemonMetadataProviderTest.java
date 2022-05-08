package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {
    //Classe testée
    IPokemonMetadataProvider provider;

    //Pokemons références
    PokemonMetadata aquali;
    PokemonMetadata bulbizarre;


    @Before
    public void init() {
        //La classe à mocker
        provider = Mockito.mock(IPokemonMetadataProvider.class);

        // On init les pokemons références
        aquali = new PokemonMetadata(133, "Aquali", 186, 186, 260);
        bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
    }

    @Test
    public void getPokemonMetadataTest() throws PokedexException {

        Mockito.doReturn(aquali).when(provider).getPokemonMetadata(133);
        Mockito.doReturn(bulbizarre).when(provider).getPokemonMetadata(0);

        Assert.assertEquals(bulbizarre.getAttack(), provider.getPokemonMetadata(0).getAttack());
        Assert.assertEquals(aquali.getAttack(), provider.getPokemonMetadata(133).getAttack());

        Assert.assertEquals(bulbizarre.getDefense(), provider.getPokemonMetadata(0).getDefense());
        Assert.assertEquals(aquali.getDefense(), provider.getPokemonMetadata(133).getDefense());

        Assert.assertEquals(bulbizarre.getStamina(), provider.getPokemonMetadata(0).getStamina());
        Assert.assertEquals(aquali.getStamina(), provider.getPokemonMetadata(133).getStamina());

        //Exception attendue si l'index est inférieur à 0 ou supérieur à 150
        Mockito.doThrow(new PokedexException("Erreur : l'index du Pokemon doit être entre 0 et 150")).when(provider).getPokemonMetadata(Mockito.intThat(i -> i < 0 || i > 150));
        //Test des exceptions
        Assert.assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(-6));
        Assert.assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(154));

    }

}
