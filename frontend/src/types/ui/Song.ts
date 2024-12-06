
export interface Song {
    id: string;
    title: string;
    title_short: string;
    duration: string;
    preview: string;
    md5_image: string | null;
    artist: Artist;
    album: Album;
    isFavorite: boolean;
}



export interface Artist {
    id: string;
    name: string;
    picture_medium: string;
    picture: string | null;
    picture_small: string | null;
    picture_big: string | null;
    picture_xl: string | null;
    tracklist: string | null;
}

export interface Album {
    id: string;
    title: string;
    genres: string | null;
    cover: string | null;
    cover_small: string | null;
    cover_medium: string | null;
    cover_big: string | null;
    cover_xl: string | null;
    md5_image: string | null;
    tracklist: string | null;

}

export interface newSong {
    id: string;
    title: string;
    duration: number;    
    preview: string;
    artist: {
        id: string;
        name: string;
        picture_medium: string;
    };
    album: {
        id: string;
        title: string;
        genres: string[];
    };
}
