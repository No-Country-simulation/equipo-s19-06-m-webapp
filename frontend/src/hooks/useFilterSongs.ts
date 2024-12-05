import { Song } from "@/types/ui/Song";

export const useFilterSongs = (
    songs: Song[],
    searchTerm: string,
    selectedGenre: string
): Song[] => {
    return songs.filter((song) => {
        const matchesSearch = [song.title, song.artist, song.genre]
            .map((field) => (typeof field === "string" ? field : "").toLowerCase())
            .some((value) => value.includes(searchTerm.toLowerCase()));

        const matchesGenre =
            selectedGenre === "Todos" || song.genre === selectedGenre;

        return matchesSearch && matchesGenre;
    });
};
