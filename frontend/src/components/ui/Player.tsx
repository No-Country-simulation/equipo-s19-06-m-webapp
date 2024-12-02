import React, { useEffect, useRef, useState } from "react";
import Image from "next/image";
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
    title: string;
    artist: string;
    duration: string;
    genre: string;
  };
  isPlaying: boolean;
  onPlayPause: () => void;
}

const Player: React.FC<PlayerProps> = ({ currentSong }) => {
  const [isPlaying, setIsPlaying] = useState(false);
  const [isFavorite, setIsFavorite] = useState(false);
  const [progress, setProgress] = useState(0); // Progreso de la canción
  const playerRef = useRef<HTMLDivElement>(null);

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

  useEffect(() => {
    if (isPlaying) {
      const interval = setInterval(() => {
        setProgress((prev) => (prev >= 100 ? 0 : prev + 1));
      }, 1000); // Simula el progreso
      return () => clearInterval(interval);
    }
  }, [isPlaying]);

  if (!currentSong) return null;

  return (
    <div
      ref={playerRef}
      className="fixed left-0 right-0 bottom-0 bg-black border border-primary shadow-[0_0_10px_rgba(0,227,227,0.1)] flex"
    >
      {/* Contenedor de la imagen */}
      <div className="w-1/8 mx-auto flex justify-center items-center">
        <Image
          src="/bg-4.jpg"
          alt="Album art"
          width={200}
          height={250}
          className="object-cover rounded-md"
        />
      </div>

      {/* Contenedor derecho */}
      <div className="w-2/3 p-4">
        {/* Información de la canción */}
        <div className="flex items-center justify-between mb-4">
          <div>
            <h3 className="text-primary font-medium">{currentSong.title}</h3>
            <p className="text-primary/60 text-sm">{currentSong.artist}</p>
          </div>
          <Heart
            className={`cursor-pointer ${
              isFavorite ? "text-[#00E3E3]" : "text-primary/60"
            }`}
            size={24}
            onClick={() => setIsFavorite(!isFavorite)}
          />
        </div>
        {/* Controles del reproductor */}
        <div className="flex items-center justify-center gap-4 mb-4">
          <SkipBack
            className="text-primary cursor-pointer"
            size={47}
            style={{ strokeWidth: 2, fill: "currentColor" }}
          />
          <Rewind
            className="text-primary cursor-pointer"
            size={47}
            style={{ strokeWidth: 2, fill: "currentColor" }}
          />
          <button
            onClick={() => setIsPlaying(!isPlaying)}
            className="text-primary cursor-pointer"
            style={{ strokeWidth: 2, fill: "currentColor" }}
          >
            {isPlaying ? (
              <Pause
                className="text-primary cursor-pointer"
                size={47}
                style={{ strokeWidth: 2, fill: "currentColor" }}
              />
            ) : (
              <Play
                className="text-primary cursor-pointer"
                size={47}
                style={{ strokeWidth: 2, fill: "currentColor" }}
              />
            )}
          </button>
          <Square
            className="text-primary cursor-pointer"
            size={47}
            style={{ strokeWidth: 2, fill: "currentColor" }}
          />
          <FastForward
            className="text-primary cursor-pointer"
            size={47}
            style={{ strokeWidth: 2, fill: "currentColor" }}
          />
          <SkipForward
            className="text-primary cursor-pointer"
            size={47}
            style={{ strokeWidth: 2, fill: "currentColor" }}
          />
        </div>
        {/* Barra de progreso */}
        <div className="flex items-center gap-2">
          <span className="text-primary text-sm min-w-[40px]">00:00</span>
          <div className="flex-1 relative h-4">
            <div className="absolute inset-0 bg-primary/10 rounded-full" />
            <div
              className="absolute top-0 bottom-0 bg-primary rounded-full"
              style={{ width: `${progress}%` }}
            />
          </div>
          <span className="text-primary text-sm min-w-[40px]">
            {currentSong.duration}
          </span>
        </div>
      </div>
    </div>
  );
};

export default Player;
