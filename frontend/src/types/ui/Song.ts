export interface Song {
    id: string;
    title: string;
    artist: string;
    genre: string;
    duration: string;
    imageUrl: string;
    isFavorite: boolean;
}

export interface Genre {
    name: string;
}
