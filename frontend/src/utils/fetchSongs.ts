
//Primera ruta api deezer

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

    // Acceder al arreglo de canciones dentro de la estructura de datos
    const songs = data.data.data || [];
    //console.log('Extracted Songs:', songs); // Debug log

    if (songs.length > 0) {
        return songs;
    } else {
        console.warn('No songs found');
        return [];
    }
};


//Nueva ruta
/*
export const fetchSongs = async (track: string) => {
    const response = await fetch(`http://144.33.15.219:8080/search/?track=${encodeURIComponent(track)}&page=0&size=15`, {
        headers: {
            'accept': 'application/json'
        }
    });

    if (!response.ok) {
        throw new Error('Error fetching songs');
    }

    const data = await response.json();
    const songs = data.data || [];

    if (songs.length > 0) {
        return songs.map(song => ({
            id: song.id.toString(),
            title: song.title,
            title_short: song.title,
            duration: song.duration.toString(),
            preview: song.preview,
            md5_image: null,
            artist: {
                id: song.artist.id.toString(),
                name: song.artist.name,
                picture_medium: song.artist.picture_medium,
                picture: null,
                picture_small: null,
                picture_big: null,
                picture_xl: null,
                tracklist: null
            },
            album: {
                id: song.album.id.toString(),
                title: song.album.genres,
                genres: song.album.genres,
                cover: null,
                cover_small: null,
                cover_medium: null,
                cover_big: null,
                cover_xl: null,
                md5_image: null,
                tracklist: null
            },
            isFavorite: false
        }));
    } else {
        console.warn('No songs found');
        return [];
    }
};
*/


//Ruta para traer canciones por genero
export const fetchSongsByGenre = async (genre: string) => {
    const url = `http://144.33.15.219:8080/tracks?genre=${genre}`;
    return fetchSongsList(url);
};

export const fetchSongsBySearchTerm = async (searchTerm: string) => {
    const url = `http://144.33.15.219:8080/search?track=${encodeURIComponent(searchTerm)}`;
    return fetchSongsList(url);
};

const fetchSongsList = async (url: string) => {
    const response = await fetch(url, {
        headers: {
            'accept': 'application/json'
        }
    });

    if (!response.ok) {
        throw new Error('Error fetching songs');
    }

    const data = await response.json();
    const songs = data.data || [];

    if (songs.length > 0) {
        return songs;
    } else {
        console.warn('No songs found');
        return [];
    }
};
