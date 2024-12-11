import React, { useState, useEffect, useCallback } from "react";
import SongItem from "./SongItem";
import Player from "@/components/ui/Player";
import { fetchSongsList } from "@/utils/fetchSongsList";
import { useFilterSongs } from "@/hooks/useFilterSongs";
import { Song } from "@/types/ui/Song";
import { formatDuration } from "@/utils/formatDuration";

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
  const [allSongs, setAllSongs] = useState<Song[]>([]);

  useEffect(() => {
    const loadSongs = async () => {
      try {
        const fetchedSongs = await fetchSongsList();
        //console.log("Fetched Songs:", fetchedSongs); // Debug log
        setAllSongs(fetchedSongs);
      } catch (error) {
        console.error("Error fetching songs:", error);
      }
    };

    loadSongs();
  }, []);

  // Llamar a useFilterSongs directamente dentro del componente
  const filteredSongs = useFilterSongs(allSongs, searchTerm, selectedGenre);

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
  const handlePlayerClose = () => {
    setSelectedSong(null);
  };

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

  const toggleFavoriteHandler = useCallback((songId: string) => {
    setAllSongs((prevSongs) =>
      prevSongs.map((song) =>
        song.id === songId ? { ...song, isFavorite: !song.isFavorite } : song
      )
    );
  }, []);

  return (
    <div className="w-full">
      <div className="mb-24">
        {filteredSongs.slice(0, 10).map((song) => (
          <SongItem
            key={song.id}
            id={song.id}
            title={song.title}
            title_short={song.title_short}
            genres={song.album.genres || ""}
            duration={formatDuration(song.duration)}
            md5_image={song.md5_image}
            preview={song.preview}
            artist={song.artist.name}
            artistImage={song.artist.picture_medium}
            isFavorite={song.isFavorite}
            isSelected={selectedSong?.id === song.id}
            onPlay={() => handlePlay(song)}
            onFavoriteToggle={() => toggleFavoriteHandler(song.id)}
          />
        ))}
      </div>
      {selectedSong && (
        <Player
          currentSong={{
            ...selectedSong,
            artist: selectedSong.artist.name,
          }}
          genres={selectedSong.album.genres || ""}
          artistImage={selectedSong.artist.picture_medium}
          isPlaying={isPlaying}
          onPlayPause={handlePlayPause}
          onNext={handleNext}
          onPrevious={handlePrevious}
          onFavoriteToggle={() =>
            selectedSong && toggleFavoriteHandler(selectedSong.id)
          }
          onClose={handlePlayerClose}
        />
      )}
    </div>
  );
}
