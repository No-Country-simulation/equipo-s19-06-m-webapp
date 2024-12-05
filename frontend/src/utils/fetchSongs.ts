export const fetchSongs = async (track: string) => {
    const genres = ["pop", "rock", "electronica", "clasica", "hip-hop", "rap", "k-pop"];

    const formattedTrack = track ? `'${track}'` : `'${genres[Math.floor(Math.random() * genres.length)]}'`;
    //console.log(`Fetching songs for track: ${formattedTrack}`); // Debug log

    const response = await fetch(`http://144.33.15.219:8080/search?track=${encodeURIComponent(formattedTrack)}`, {
        headers: {
            'accept': 'application/json'
        }
    });

    if (!response.ok) {
        throw new Error('Error fetching songs');
    }

    const data = await response.json();
    //console.log('API Response:', data); // Debug log

    // Asegurarse de acceder al arreglo de canciones dentro de la estructura de datos
    const songs = data.data.data || [];
    //console.log('Extracted Songs:', songs); // Debug log

    if (songs.length > 0) {
        return songs;
    } else {
        console.warn('No songs found');
        return [];
    }
};
