// SongItem.tsx
import React from "react";
import Image from "next/image";
import { Heart } from "lucide-react";

interface SongItemProps {
  title: string;
  artist: string;
  genre: string;
  duration: string;
  isSelected: boolean;
  isFavorite: boolean;
  onFavoriteToggle: () => void;
  onPlay: () => void;
}

const SongItem: React.FC<SongItemProps> = ({
  title,
  genre,
  duration,
  isSelected,
  isFavorite,
  onFavoriteToggle,
  onPlay,
}) => {
  return (
    <div
      onClick={onPlay}
      className={`
        p-4 rounded-[15px] bg-black
        hover:bg-primary/10 transition-colors cursor-pointer
        ${isSelected ? "border border-primary" : ""}
        mb-3
        h-[72px]
      `}
    >
      <div className="flex items-center gap-4 h-full">
        {/* Imagen de la canción */}
        <div className="w-16 h-16 bg-black rounded-md overflow-hidden relative flex-shrink-0">
          <Image
            src="/bg-4.jpg"
            alt="Album art"
            fill
            className="object-cover"
          />
        </div>

        {/* Corazón para marcar favorito */}
        <Heart
          className={`w-5 h-5 cursor-pointer transition-colors border-primary ${
            isFavorite ? "fill-primary" : "text-primary"
          }`}
          onClick={(e) => {
            e.stopPropagation();
            onFavoriteToggle();
          }}
        />

        {/* Contenedor de la canción */}
        <div className="flex flex-1 items-center justify-between h-full">
          {/* Título de la canción */}
          <div className="flex-1">
            <h3 className="text-white font-bold truncate">{title}</h3>
          </div>

          {/* Género */}
          <div className="text-white text-center font-bold w-[100px]">
            {genre}
          </div>

          {/* Duración */}
          <div className="text-white font-bold w-[60px]">{duration}</div>
        </div>
      </div>
    </div>
  );
};

export default SongItem;
