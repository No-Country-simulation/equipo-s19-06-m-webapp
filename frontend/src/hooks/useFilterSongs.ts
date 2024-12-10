import { Song } from "@/types/ui/Song";

export const useFilterSongs = (
    songs: Song[],
    searchTerm: string,
    selectedGenre: string
): Song[] => {
    if (!Array.isArray(songs)) {
        return [];
    }

    return songs.filter((song) => {
        const matchesSearch = [song.title, song.artist?.name, ...(Array.isArray(song.album.genres) ? song.album.genres : [song.album.genres])]
            .map((field) => (typeof field === "string" ? field : "").toLowerCase())
            .some((value) => value.includes(searchTerm.toLowerCase()));

        const genres = Array.isArray(song.album.genres) ? song.album.genres : [song.album.genres];
        const matchesGenre =
            selectedGenre === "Todos" || genres.some((genre) =>
                genre.toLowerCase().includes(selectedGenre.toLowerCase())
            );

        return matchesSearch && matchesGenre;
    });
};


/*import { Song } from "@/types/ui/Song";

export const useFilterSongs = (
    songs: Song[],
    searchTerm: string,
    selectedGenre: string
): Song[] => {
    if (!Array.isArray(songs)) {
        return [];
    }

    return songs.filter((song) => {
        const matchesSearch = [song.title, song.artist.name, song.album.genres]
            .map((field) => (typeof field === "string" ? field : "").toLowerCase())
            .some((value) => value.includes(searchTerm.toLowerCase()));

        const genres = song.album.genres || "";
        const matchesGenre =
            selectedGenre === "Todos" || genres.toLowerCase().includes(selectedGenre.toLowerCase());

        return matchesSearch && matchesGenre;
    });
};
*/