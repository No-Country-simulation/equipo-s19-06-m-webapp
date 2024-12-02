// SongList.tsx
import React, { useState } from "react";
import SongItem from "./SongItem";
import Player from "@/components/ui/Player";
import { useFilterSongs } from "@/hooks/useFilterSongs";
import { mockSongs } from "@/data/mockSongs";
import { Song } from "@/types/ui/Song";

interface SongListProps {
  searchTerm?: string;
  selectedGenre?: string;
}

export default function SongList({
  searchTerm = "",
  selectedGenre = "Todos",
}: SongListProps) {
  const [selectedSong, setSelectedSong] = useState<Song | null>(null);
  const [isPlaying, setIsPlaying] = useState(false);
  const [songs, setSongs] = useState<Song[]>(mockSongs);

  const filteredSongs = useFilterSongs(songs, searchTerm, selectedGenre);

  const handlePlay = (song: Song) => {
    setSelectedSong(song);
    setIsPlaying(true);
  };

  const toggleFavorite = (songId: string) => {
    setSongs((prevSongs) =>
      prevSongs.map((song) =>
        song.id === songId ? { ...song, isFavorite: !song.isFavorite } : song
      )
    );
  };

  return (
    <div className="w-full">
      {filteredSongs.map((song) => (
        <SongItem
          key={song.id}
          title={song.title}
          artist={song.artist}
          genre={song.genre}
          duration={song.duration}
          isFavorite={song.isFavorite}
          isSelected={selectedSong?.id === song.id}
          onPlay={() => handlePlay(song)}
          onFavoriteToggle={() => toggleFavorite(song.id)}
        />
      ))}
      {selectedSong && (
        <Player
          currentSong={selectedSong}
          isPlaying={isPlaying}
          onPlayPause={() => setIsPlaying(!isPlaying)}
        />
      )}
    </div>
  );
}
