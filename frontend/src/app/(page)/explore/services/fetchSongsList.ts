import { Song, Artist, Album, RawSong } from "@/types/ui/Song";

export const fetchSongsList = async (): Promise<Song[]> => {
    const response = await fetch("http://144.33.15.219:8080/tracks", {
        headers: {
            accept: "application/json",
        },
    });

    if (!response.ok) {
        throw new Error("Error fetching songs");
    }

    const data = await response.json();
    const songs: RawSong[] = data.data || [];

    return songs.map((song: RawSong): Song => ({
        id: song.id ? song.id.toString() : "0",
        title: song.title || "No Title",
        title_short: song.title || "No Title",
        duration: song.duration ? song.duration.toString() : "0",
        preview: song.preview || "",
        md5_image: song.md5_image || null,
        artist: {
            id: song.artist.id ? song.artist.id.toString() : "0",
            name: song.artist.name || "Unknown Artist",
            picture_medium: song.artist.picture_medium || song.artist.picture_url || "",
            picture: song.artist.picture || null,
            picture_small: song.artist.picture_small || null,
            picture_big: song.artist.picture_big || null,
            picture_xl: song.artist.picture_xl || null,
            tracklist: song.artist.tracklist || null,
        } as Artist,
        album: {
            id: song.album.id ? song.album.id.toString() : "0",
            title: song.album.title || "Unknown Album",
            genres: song.album.genres || song.album.genre || "Unknown Genero",
            cover: song.album.cover || null,
            cover_small: song.album.cover_small || null,
            cover_medium: song.album.cover_medium || null,
            cover_big: song.album.cover_big || null,
            cover_xl: song.album.cover_xl || null,
            md5_image: song.album.md5_image || null,
            tracklist: song.album.tracklist || null,
        } as Album,
        isFavorite: false,
    }));
};
