import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * A class to hold details of audio tracks.
 * Individual tracks may be played.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing music tracks.
    private ArrayList<Track> tracks;
    // A player for the music tracks.
    private MusicPlayer player;
    // A reader that can read music files and load them as tracks.
    private TrackReader reader;
    //Devuelve true/false en funcion de si se está reproduciendo musica o no
    private boolean playing;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer(String CarpetaDeAudio)
    {
        tracks = new ArrayList<Track>();
        player = new MusicPlayer();
        reader = new TrackReader();
        readLibrary(CarpetaDeAudio);
        System.out.println("Music library loaded. " + getNumberOfTracks() + " tracks.");
        System.out.println();
        playing = false;
    }

    /**
     * Add a track file to the collection.
     * @param filename The file name of the track to be added.
     */
    public void addFile(String filename)
    {
        tracks.add(new Track(filename));
    }

    /**
     * Add a track to the collection.
     * @param track The track to be added.
     */
    public void addTrack(Track track)
    {
        tracks.add(track);
    }

    /**
     * Play a track in the collection.
     * @param index The index of the track to be played.
     */
    public void playTrack(int index)
    {
        if(indexValid(index) && playing == false) {
            Track track = tracks.get(index);
            player.startPlaying(track.getFilename());
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
            track.addPlayCount();
            playing = true;

        }
       
        if(playing == true)
        {
           System.out.println("Reproducción en curso");
        }
    }

    /**
     * Return the number of tracks in the collection.
     * @return The number of tracks in the collection.
     */
    public int getNumberOfTracks()
    {
        return tracks.size();
    }

    /**
     * List a track from the collection.
     * @param index The index of the track to be listed.
     */
    public void listTrack(int index)
    {
        System.out.print("Track " + index + ": ");
        Track track = tracks.get(index);
        System.out.println(track.getDetails());
        System.out.println("Veces reproducido: " + track.getPlayCount());
    }

    /**
     * Show a list of all the tracks in the collection.
     */
    public void listAllTracks()
    {
        System.out.println("Track listing: ");

        for(Track track : tracks) {
            System.out.println(track.getDetails());
        }
        System.out.println();
    }

    /**
     * List all tracks by the given artist.
     * @param artist The artist's name.
     */
    public void listByArtist(String artist)
    {
        for(Track track : tracks) {
            if(track.getArtist().contains(artist)) {
                System.out.println(track.getDetails());
            }
        }
    }

    /**
     * Remove a track from the collection.
     * @param index The index of the track to be removed.
     */
    public void removeTrack(int index)
    {
        if(indexValid(index)) {
            tracks.remove(index);
        }
    }

    /**
     * Play the first track in the collection, if there is one.
     */
    public void playFirst()
    {
        if(tracks.size() > 0) {
            player.startPlaying(tracks.get(0).getFilename());
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
        playing = false;
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean indexValid(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;

        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= tracks.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }

    private void readLibrary(String folderName)
    {
        ArrayList<Track> tempTracks = reader.readTracks(folderName, ".mp3");

        // Put all thetracks into the organizer.
        for(Track track : tempTracks) {
            addTrack(track);
        }
    }

    /**
     * Metodo que muestra por pantalla la informacion de las canciones con el titulo
     * introducid por parametro
     */
    public void findInTitle(String Title)
    {
        for(Track track : tracks) 
        {
            if(track.getTitle().contains(Title)) 
            {
                System.out.println(track.getTitle());
            }
        }
    }

    /**
     * Metodo que fija el valor del genero de una canción
     */
    public void fijarGenero(int index, String Genero)
    {
        if(indexValid(index)) 
        {
            Track track = tracks.get(index);
            track.selectGenero(Genero);
        }

    }
    /**
     * Metodo que informa si se está reproduciendo musica en este momento
     */
    public void isPlaying()
    {
        if (playing == true)
        {
            System.out.println("Reproducción en curso");
        }
        else
        {
            System.out.println("No hay reproducción en curso");
        }
    }
    
    /**
     * Metodo que muestra los detalles de todos los tracks almacenados en el organizador
     * utilizando Iterator
     */
    public void listAllTrackWithIterator()
    {
        Iterator<Track> canciones = tracks.iterator();
        while (canciones.hasNext())
        {
            Track tracks = canciones.next();
            System.out.println(tracks.getDetails());
        }
    }
    
    /**
     * Metodo que permite eliminar tracks que contengan un determindado artista utilizando
     * Iterator
     */
    public void removeByArtist(String Artist)
    {
        Iterator<Track> canciones = tracks.iterator();
        while (canciones.hasNext())
        {
            Track tracks = canciones.next();
            String tr = tracks.getArtist();
            if(tr.contains(Artist))
            {
                canciones.remove();
            }
        }    
    }
    
    /**
     * Metodo que permite eliminar tracks que contienen una determinada cadena en el titulo
     * usando Iterador
     */
    public void removeByTitle(String Title)
    {
        Iterator<Track> canciones = tracks.iterator();
        while (canciones.hasNext())
        {
            Track tracks = canciones.next();
            String tr = tracks.getTitle();
            if(tr.contains(Title))
            {
                canciones.remove();
            }
        }   
    }
    
    /**
     * Metodo que reproduce una de las canciones al azar utilizando la clase Random.
     */
    public void playRandom()
    {
        Random track = new Random();
        int limite = tracks.size();
        playTrack(+track.nextInt(limite));
    }
}