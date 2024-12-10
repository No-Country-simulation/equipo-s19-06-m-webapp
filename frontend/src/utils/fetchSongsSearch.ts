import { Song } from '@/types/ui/Song'; // Asegúrate de importar el tipo Song

export const fetchSongsSearchDeezer = async (formattedTrack: string): Promise<Song[]> => {
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

    // Acceder al arreglo de canciones dentro de la estructura de datos
    const songs = data.data || [];
    //console.log('Extracted Songs:', songs); // Debug log

    if (songs.length > 0) {
        return songs;
    } else {
        console.warn('No songs found');
        return [];
    }
};
