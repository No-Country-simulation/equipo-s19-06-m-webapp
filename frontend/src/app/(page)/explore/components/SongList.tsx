import React, { useState, useCallback } from "react";
import SongItem from "./SongItem";
import Player from "@/components/ui/Player";
import { useFilterSongs } from "@/hooks/useFilterSongs";
import { mockSongs } from "@/data/mockSongs";
import { Song } from "@/types/ui/Song";
import { formatDuration } from "@/app/utils/formatDuration";

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

  const handlePlay = useCallback(
    (song: Song) => {
      if (selectedSong?.id === song.id) {
        setIsPlaying(!isPlaying);
      } else {
        setSelectedSong(song);
        setIsPlaying(true);
      }
    },
    [selectedSong, isPlaying]
  );

  const handlePlayPause = useCallback(() => {
    setIsPlaying(!isPlaying);
  }, [isPlaying]);

  const handleNext = useCallback(() => {
    if (!selectedSong) return;
    const currentIndex = filteredSongs.findIndex(
      (song) => song.id === selectedSong.id
    );
    if (currentIndex < filteredSongs.length - 1) {
      setSelectedSong(filteredSongs[currentIndex + 1]);
      setIsPlaying(true);
    }
  }, [selectedSong, filteredSongs]);

  const handlePrevious = useCallback(() => {
    if (!selectedSong) return;
    const currentIndex = filteredSongs.findIndex(
      (song) => song.id === selectedSong.id
    );
    if (currentIndex > 0) {
      setSelectedSong(filteredSongs[currentIndex - 1]);
      setIsPlaying(true);
    }
  }, [selectedSong, filteredSongs]);

  const toggleFavorite = useCallback((songId: string) => {
    setSongs((prevSongs) =>
      prevSongs.map((song) =>
        song.id === songId ? { ...song, isFavorite: !song.isFavorite } : song
      )
    );
  }, []);

  return (
    <div className="w-full">
      <div className="mb-24">
        {filteredSongs.map((song) => (
          <SongItem
            key={song.id}
            id={song.id}
            title={song.title}
            title_short={song.title_short}
            genre={song.genre}
            duration={formatDuration(song.duration)}
            md5_image={song.md5_image}
            preview={song.preview}
            artist={song.artist.name}
            isFavorite={song.isFavorite}
            isSelected={selectedSong?.id === song.id}
            onPlay={() => handlePlay(song)}
            onFavoriteToggle={() => toggleFavorite(song.id)}
          />
        ))}
      </div>
      {selectedSong && (
        <Player
          currentSong={{
            ...selectedSong,
            artist: selectedSong.artist.name, // Asegúrate de usar el nombre
          }}
          isFavorite={selectedSong.isFavorite}
          isPlaying={isPlaying}
          onPlayPause={handlePlayPause}
          onNext={handleNext}
          onPrevious={handlePrevious}
          onFavoriteToggle={() =>
            selectedSong && toggleFavorite(selectedSong.id)
          }
        />
      )}
    </div>
  );
}
