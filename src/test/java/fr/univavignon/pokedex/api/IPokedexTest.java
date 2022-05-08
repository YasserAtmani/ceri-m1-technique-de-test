package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IPokedexTest {

    IPokedex pokedex;
    PokemonMetadata aquali;
    PokemonMetadata bulbizarre;
    List<Pokemon> listPokemons;


    @Before
    /*public void init() {
        //La classe à mocker
        pokedex = Mockito.mock(IPokedex.class);

        //Création de la liste de pokemon référence
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100);
        bulbizarre =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

        listPokemons = new ArrayList(Arrays.asList(aquali, bulbizarre));
    }*/
    public void init() {
        //La classe à mocker
        pokedex = new PokedexImpl(new PokemonMetadataProviderImpl(), new PokemonFactoryImpl());

        //Création de la liste de pokemon référence
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100);
        bulbizarre =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

        listPokemons = pokedex.getPokemons();
    }

    @Test
    public void getSizeTest(){
        //Mockito.doReturn(listPokemons.size()).when(pokedex).size();
        Assert.assertEquals(2, pokedex.size());
    }

    @Test
    public void addPokemonTest(){
        //Mockito.doReturn(listPokemons.size() + 1).when(pokedex).addPokemon(Mockito.any(Pokemon.class));
        Assert.assertEquals(3, pokedex.addPokemon(new Pokemon(0, "poke1",0,0,0,0,0,0,0,0)));
    }

    @Test
    public void getPokemonTest () throws PokedexException {
        //Mockito.doReturn(bulbizarre).when(pokedex).getPokemon(0);
        //Mockito.doReturn(aquali).when(pokedex).getPokemon(1);
        //Mockito.doThrow(new PokedexException("Erreur : pas dans la liste")).when(pokedex).getPokemon(Mockito.intThat(i -> i < 0 || i > 1));

        Assert.assertEquals(aquali.getName(), pokedex.getPokemon(0).getName());
        Assert.assertEquals(bulbizarre.getName(), pokedex.getPokemon(1).getName());

        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(-99));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(-1));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(2));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(99));
    }

    @Test
    public void getPokemonsTest () {
        List<Pokemon> unmodifiablePokemonList = Collections.unmodifiableList(listPokemons);

        //Mockito.doReturn(unmodifiablePokemonList).when(pokedex).getPokemons();

        Assert.assertEquals(unmodifiablePokemonList.getClass(), pokedex.getPokemons().getClass());
        Assert.assertEquals(listPokemons.size(), pokedex.getPokemons().size());
        Assert.assertEquals(listPokemons.get(0), pokedex.getPokemons().get(0));
    }

    @Test
    public void getPokemonsSortedTest () {

        //Création des comparators
        PokemonComparators name = PokemonComparators.NAME;
        PokemonComparators index = PokemonComparators.INDEX;
        PokemonComparators cp = PokemonComparators.CP;

        //Création des lists en triant via les comparators
        List<Pokemon> pokemonsSortedByName = new ArrayList<>(listPokemons);
        pokemonsSortedByName.sort(name);

        List<Pokemon> pokemonsSortedByIndex = new ArrayList<>(listPokemons);
        pokemonsSortedByIndex.sort(index);

        List<Pokemon> pokemonsSortedByCP = new ArrayList<>(listPokemons);
        pokemonsSortedByCP.sort(cp);

        //Appel de la methode getPokemons prenant en argument le comparator
        //Mockito.doReturn(Collections.unmodifiableList(pokemonsSortedByName)).when(pokedex).getPokemons(name);
        //Mockito.doReturn(Collections.unmodifiableList(pokemonsSortedByIndex)).when(pokedex).getPokemons(index);
        //Mockito.doReturn(Collections.unmodifiableList(pokemonsSortedByIndex)).when(pokedex).getPokemons(cp);


        //Nom du premier pokemon attendu = Aquali
        Assert.assertEquals("Aquali", pokedex.getPokemons(name).get(0).getName());
        //Premier index attendu = 0
        Assert.assertEquals(0, pokedex.getPokemons(index).get(0).getIndex());
        //Premier CP attendu = 613
        Assert.assertEquals(613, pokedex.getPokemons(cp).get(0).getCp());
        // Liste de type unmodifiable attendue
        Assert.assertEquals(Collections.unmodifiableList(new ArrayList<>()).getClass(), pokedex.getPokemons(name).getClass());
        //Taille attendu = meme taille qu'initialement
        Assert.assertEquals(listPokemons.size(), pokedex.getPokemons(name).size());
    }

}
