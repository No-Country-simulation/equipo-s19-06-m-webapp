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
            selectedGenre === "Todos" || genres.some((genre) => {
                if (selectedGenre.toLowerCase().includes('/')) {
                    // Use includes for compound genres
                    return genre.toLowerCase().includes(selectedGenre.toLowerCase());
                } else {
                    // Use exact match for single-word genres
                    return genre.toLowerCase() === selectedGenre.toLowerCase();
                }
            });

        return matchesSearch && matchesGenre;
    });
};
