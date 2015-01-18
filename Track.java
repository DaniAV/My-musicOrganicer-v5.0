/**
 * Store the details of a music track,
 * such as the artist, title, and file name.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class Track
{
    // The artist.
    private String artist;
    // The track's title.
    private String title;
    // Where the track is stored.
    private String filename;
    //Almacena la cuenta de las veces que se ha reproducido una cancion
    private int playCount;
    //Se almacena el genero de la cancion
    private String genero;
    
    /**
     * Constructor for objects of class Track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    public Track(String artist, String title, String filename)
    {
        int playCount = 0;
        String genero = "undefined";
        setDetails(artist, title, filename);
    }
    
    public void incremenPlayCount()
    {
        playCount = playCount +1;
        
    }
    
    /**
     * Constructor for objects of class Track.
     * It is assumed that the file name cannot be
     * decoded to extract artist and title details.
     * @param filename The track file. 
     */
    public Track(String filename)
    {
        int playCount = 0;
        String genero = "undefined";
        setDetails("unknown", "unknown", filename);
    }
    
    /**
     * Return the artist.
     * @return The artist.
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Return the title.
     * @return The title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Return the file name.
     * @return The file name.
     */
    public String getFilename()
    {
        return filename;
    }
        
    /**
     * Return details of the track: artist, title and file name.
     * @return The track's details.
     */
    public String getDetails()
    {
        return artist + ": " + title + "  (file: " + filename + ")" + " Reproducciones: " + getPlayCount() + " Genero: " + getGenero();
    }
    
    /**
     * Set details of the track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    private void setDetails(String artist, String title, String filename)
    {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
    }
    
    /**
     * Metodo que resetea el playCount a cero
     */
    public void resetCero()
    {
        playCount = 0;
    }
    
    /**
     * Metodo que aumenta en cada ejecución el playCount en uno
     */
    public void addPlayCount()
    {
        playCount++;
    }
    
    /**
     * Metodo que devuelve el valor de playcount
     */
    public int getPlayCount()
    {
        return playCount;
    }
    
    /**
     * Devuelve el genero de una cancion
     */
    public String getGenero()
    {
        return this.genero;
    }
    
    /**
     * Metodo que permite modificar el genero de una cancion
     */
    public void selectGenero(String Genero)
    {
        this.genero = Genero;
    }
    
}
