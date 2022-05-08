package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokedexImpl implements IPokedex {

    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;

    /**
     * Liste des Pokemons enregistres dans le Pokedex
     */
    private List<Pokemon> pokemonsRegistered = new ArrayList<>();

    public PokedexImpl(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return pokemonsRegistered.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonsRegistered.add(pokemon);
        return pokemonsRegistered.size();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        try {
            Pokemon pokemon = pokemonsRegistered.get(id);
            return pokemon;
        } catch (IndexOutOfBoundsException e) {
            throw new PokedexException("Erreur : pas dans la liste");
        }
    }

    @Override
    public List<Pokemon> getPokemons() {
        List<Pokemon> unmodifiableSortedPokemonList = Collections.unmodifiableList(pokemonsRegistered);
        return unmodifiableSortedPokemonList;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List sorted = new ArrayList(pokemonsRegistered);
        sorted.sort(order);
        List<Pokemon> unmodifiableSortedPokemonList = Collections.unmodifiableList(sorted);
        return unmodifiableSortedPokemonList;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
