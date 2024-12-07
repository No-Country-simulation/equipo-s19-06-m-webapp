
export interface Song {
    id: string;
    title: string;
    title_short: string;
    duration: string;
    preview: string;
    md5_image: string;
    artist: Artist;
    album: Album;
    isFavorite: boolean;
    genre: string;
    imageUrl: string; 
}

export interface Genre {
    name: string;
}

export interface Artist {
    id: string;
    name: string;
    picture: string;
    picture_small: string;
    picture_medium: string;
    picture_big: string;
    picture_xl: string;
    tracklist: string;
}

export interface Album {
    id: string;
    title: string;
    cover: string;
    cover_small: string;
    cover_medium: string;
    cover_big: string;
    cover_xl: string;
    md5_image: string;
    tracklist: string;
}
