
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

export type RawSong = {
    id: string | number;
    title: string;
    duration: number | string;
    preview: string;
    md5_image: string | null;
    artist: {
        id: string | number;
        name: string;
        picture_medium: string;
        picture_url: string;
        picture: string | null;
        picture_small: string | null;
        picture_big: string | null;
        picture_xl: string | null;
        tracklist: string | null;
    };
    album: {
        id: string | number;
        title: string;
        genres: string | null;
        genre: string | null;
        cover: string | null;
        cover_small: string | null;
        cover_medium: string | null;
        cover_big: string | null;
        cover_xl: string | null;
        md5_image: string | null;
        tracklist: string | null;
    };
};

