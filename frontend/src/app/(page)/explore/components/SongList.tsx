import React, { useState, useEffect, useCallback } from "react";
import SongItem from "./SongItem";
import Player from "@/components/ui/Player";
import {
  fetchSongsByGenre,
  fetchSongsBySearchTerm,
  fetchSongs,
} from "@/utils/fetchSongs";
import { useFilterSongs } from "@/hooks/useFilterSongs";
import { Song } from "@/types/ui/Song";
import { formatDuration } from "@/utils/formatDuration";
//import { mockSongs } from "@/data/mockSongs";

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
  const [songs, setSongs] = useState<Song[]>([]);
  const [initialSongs, setInitialSongs] = useState<Song[]>([]);

  useEffect(() => {
    const genres = [
      "pop",
      "rock",
      "electronica",
      "clasica",
      "hip-hop",
      "rap",
      "k-pop",
    ];

    const loadInitialSongs = async () => {
      try {
        const promises = genres.map((genre) => fetchSongsByGenre(genre));
        const results = await Promise.all(promises);
        const allSongs = results.flat();

        const randomFetchedSongs = await fetchSongs("");

        const combinedSongs: Song[] = [];
        const maxLength = Math.max(allSongs.length, randomFetchedSongs.length);
        for (let i = 0; i < maxLength; i++) {
          if (i < allSongs.length) {
            combinedSongs.push(allSongs[i]);
          }
          if (i < randomFetchedSongs.length) {
            combinedSongs.push(randomFetchedSongs[i]);
          }
        }

        setInitialSongs(combinedSongs);
      } catch (error) {
        console.error("Error fetching initial songs:", error);
      }
    };

    loadInitialSongs();
  }, []);

  useEffect(() => {
    const loadSongs = async () => {
      try {
        let fetchedSongs: Song[] = [];

        if (searchTerm) {
          fetchedSongs = await fetchSongsBySearchTerm(searchTerm);
        } else {
          fetchedSongs = await fetchSongs("");
        }

        const combinedSongs: Song[] = [];
        const maxLength = Math.max(fetchedSongs.length, initialSongs.length);
        for (let i = 0; i < maxLength; i++) {
          if (i < fetchedSongs.length) {
            combinedSongs.push(fetchedSongs[i]);
          }
          if (i < initialSongs.length) {
            combinedSongs.push(initialSongs[i]);
          }
        }

        setSongs(combinedSongs.slice(0, 15));
      } catch (error) {
        console.error("Error fetching songs:", error);
      }
    };

    loadSongs();
  }, [searchTerm, initialSongs]);

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
    const currentIndex = songs.findIndex((song) => song.id === selectedSong.id);
    if (currentIndex < songs.length - 1) {
      setSelectedSong(songs[currentIndex + 1]);
      setIsPlaying(true);
    }
  }, [selectedSong, songs]);

  const handlePrevious = useCallback(() => {
    if (!selectedSong) return;
    const currentIndex = songs.findIndex((song) => song.id === selectedSong.id);
    if (currentIndex > 0) {
      setSelectedSong(songs[currentIndex - 1]);
      setIsPlaying(true);
    }
  }, [selectedSong, songs]);

  const toggleFavoriteHandler = useCallback((songId: string) => {
    setSongs((prevSongs) =>
      prevSongs.map((song) =>
        song.id === songId ? { ...song, isFavorite: !song.isFavorite } : song
      )
    );
  }, []);

  const filteredSongs = useFilterSongs(songs, searchTerm, selectedGenre);

  return (
    <div className="w-full">
      <div className="mb-24">
        {filteredSongs.map((song) => (
          <SongItem
            key={song.id}
            id={song.id}
            title={song.title}
            title_short={song.title_short}
            genres={song.album.genres || ""}
            duration={formatDuration(song.duration)}
            md5_image={song.md5_image}
            preview={song.preview}
            artist={song.artist?.name || "Unknown Artist"}
            artistImage={song.artist?.picture_medium || ""}
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
            artist: selectedSong.artist?.name || "Unknown Artist",
          }}
          genres={selectedSong.album.genres || ""}
          artistImage={selectedSong.artist?.picture_medium || ""}
          isFavorite={selectedSong.isFavorite}
          isPlaying={isPlaying}
          onPlayPause={handlePlayPause}
          onNext={handleNext}
          onPrevious={handlePrevious}
          onFavoriteToggle={() =>
            selectedSong && toggleFavoriteHandler(selectedSong.id)
          }
        />
      )}
    </div>
  );
}
