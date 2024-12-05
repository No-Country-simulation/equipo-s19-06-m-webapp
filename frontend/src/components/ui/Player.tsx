import React, { useEffect, useRef, useState } from "react";
import Image from "next/image";
import { formatDuration } from "@/utils/formatDuration";
import {
  SkipBack,
  Rewind,
  Play,
  Pause,
  Square,
  FastForward,
  SkipForward,
  Heart,
} from "lucide-react";

interface PlayerProps {
  currentSong?: {
    id: string;
    title: string;
    artist: string;
    duration: string;
    preview: string;
    isFavorite: boolean;
  };
  genres: string;
  artistImage: string;
  isPlaying: boolean;
  onPlayPause: () => void;
  onNext?: () => void;
  onPrevious?: () => void;
  onFavoriteToggle: (songId: string) => void;
  isFavorite: boolean;
}

const Player: React.FC<PlayerProps> = ({
  currentSong,
  genres,
  artistImage,
  isPlaying,
  onPlayPause,
  onNext,
  onPrevious,
  onFavoriteToggle,
}) => {
  const [progress, setProgress] = useState(0);
  const [currentTime, setCurrentTime] = useState("00:00");
  const [error, setError] = useState<string | null>(null);
  const playerRef = useRef<HTMLDivElement>(null);
  const audioRef = useRef<HTMLAudioElement | null>(null);

  const initializeAudio = () => {
    if (!currentSong?.preview) return;

    if (audioRef.current) {
      audioRef.current.pause();
      audioRef.current.src = "";
    }

    audioRef.current = new Audio(currentSong.preview);
    audioRef.current.preload = "auto";

    audioRef.current.addEventListener("loadeddata", () => {
      setError(null);
      if (isPlaying) {
        audioRef.current?.play();
      }
    });

    audioRef.current.addEventListener("timeupdate", updateProgress);
    audioRef.current.addEventListener("ended", handleSongEnd);
    audioRef.current.addEventListener("error", handleAudioError);
  };

  useEffect(() => {
    initializeAudio();
    return () => {
      if (audioRef.current) {
        audioRef.current.removeEventListener("timeupdate", updateProgress);
        audioRef.current.removeEventListener("ended", handleSongEnd);
        audioRef.current.removeEventListener("error", handleAudioError);
        audioRef.current.pause();
        audioRef.current = null;
      }
    };
  }, [currentSong?.preview]);

  useEffect(() => {
    if (!audioRef.current || error) return;

    if (isPlaying) {
      audioRef.current.play().catch(handleAudioError);
    } else {
      audioRef.current.pause();
    }
  }, [isPlaying, currentSong]);

  //Para que el player se mueva con el scroll y no pase a cubrir el footer
  useEffect(() => {
    const handleScroll = () => {
      const footer = document.querySelector("footer");
      if (playerRef.current && footer) {
        const footerRect = footer.getBoundingClientRect();
        const windowHeight = window.innerHeight;

        if (footerRect.top <= windowHeight) {
          playerRef.current.style.bottom = `${windowHeight - footerRect.top}px`;
        } else {
          playerRef.current.style.bottom = "0";
        }
      }
    };

    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  const updateProgress = () => {
    if (!audioRef.current) return;
    const duration = audioRef.current.duration;
    const currentTime = audioRef.current.currentTime;
    const progressPercent = (currentTime / duration) * 100;
    setProgress(progressPercent);
    setCurrentTime(formatTime(currentTime));
  };

  const handleSongEnd = () => {
    setProgress(0);
    setCurrentTime("00:00");
    onPlayPause();
    if (onNext) onNext();
  };

  const handleAudioError = (e: Event) => {
    console.error("Audio error:", e);
    setError("Error playing audio");
    onPlayPause();
  };

  const handleSeek = (e: React.MouseEvent<HTMLDivElement>) => {
    if (!audioRef.current) return;

    const progressBar = e.currentTarget;
    const rect = progressBar.getBoundingClientRect();
    const x = e.clientX - rect.left;
    const width = rect.width;
    const percentage = x / width;
    const seekTime = audioRef.current.duration * percentage;

    audioRef.current.currentTime = seekTime;
    setProgress(percentage * 100);
  };

  const handleFastForward = () => {
    if (!audioRef.current) return;
    audioRef.current.currentTime = Math.min(
      audioRef.current.currentTime + 10,
      audioRef.current.duration
    );
  };

  const handleRewind = () => {
    if (!audioRef.current) return;
    audioRef.current.currentTime = Math.max(
      audioRef.current.currentTime - 10,
      0
    );
  };

  const handleStop = () => {
    if (audioRef.current) {
      audioRef.current.pause();
      audioRef.current.currentTime = 0;
      setProgress(0);
      setCurrentTime("00:00");
    }
  };

  const formatTime = (time: number): string => {
    const minutes = Math.floor(time / 60);
    const seconds = Math.floor(time % 60);
    return `${minutes.toString().padStart(2, "0")}:${seconds
      .toString()
      .padStart(2, "0")}`;
  };

  if (!currentSong) return null;

  return (
    <div
      ref={playerRef}
      className="fixed left-0 right-0 bottom-0 bg-black border border-primary shadow-[0_0_10px_rgba(0,227,227,0.1)] flex"
    >
      <div className="w-1/8 mx-auto flex justify-center items-center">
        <Image
          src={artistImage}
          alt="Album art"
          width={150}
          height={150}
          className="object-cover rounded-md"
        />
      </div>

      <div className="w-2/3 p-4">
        <div className="flex items-center justify-between mb-4">
          <div>
            <h3 className="text-primary font-medium">{currentSong.title}</h3>
            <p className="text-primary/60 text-sm">{currentSong.artist}</p>
            <p className="text-primary/60 text-sm">{genres}</p>
          </div>
          <Heart
            className={`w-6 h-6 cursor-pointer transition-colors
              ${
                currentSong.isFavorite
                  ? "text-primary fill-primary"
                  : "text-primary/60 hover:text-primary"
              }
            `}
            onClick={() => onFavoriteToggle(currentSong.id)}
          />
        </div>

        <div className="flex items-center justify-center gap-4 mb-4">
          <SkipBack
            className="text-primary cursor-pointer"
            size={47}
            style={{ strokeWidth: 2, fill: "currentColor" }}
            onClick={onPrevious}
          />
          <Rewind
            className="text-primary cursor-pointer"
            size={47}
            style={{ strokeWidth: 2, fill: "currentColor" }}
            onClick={handleRewind}
          />
          <button
            onClick={onPlayPause}
            className="text-primary cursor-pointer"
            style={{ strokeWidth: 2, fill: "currentColor" }}
          >
            {isPlaying ? (
              <Pause
                size={47}
                style={{ strokeWidth: 2, fill: "currentColor" }}
              />
            ) : (
              <Play
                size={47}
                style={{ strokeWidth: 2, fill: "currentColor" }}
              />
            )}
          </button>
          <Square
            className="text-primary cursor-pointer"
            size={47}
            style={{ strokeWidth: 2, fill: "currentColor" }}
            onClick={handleStop} // Cambia a handleStop
          />
          <FastForward
            className="text-primary cursor-pointer"
            size={47}
            style={{ strokeWidth: 2, fill: "currentColor" }}
            onClick={handleFastForward}
          />
          <SkipForward
            className="text-primary cursor-pointer"
            size={47}
            style={{ strokeWidth: 2, fill: "currentColor" }}
            onClick={onNext}
          />
        </div>

        <div className="flex items-center gap-2">
          <span className="text-primary text-sm min-w-[40px]">
            {currentTime}
          </span>
          <div
            className="flex-1 relative h-4 cursor-pointer"
            onClick={handleSeek}
          >
            <div className="absolute inset-0 bg-primary/10 rounded-full" />
            <div
              className="absolute top-0 bottom-0 bg-primary rounded-full"
              style={{ width: `${progress}%` }}
            />
          </div>
          <span className="text-primary text-sm min-w-[40px]">
            {formatDuration(currentSong.duration)}
          </span>
        </div>
      </div>
    </div>
  );
};

export default Player;
