import React from "react";
import { Heart } from "lucide-react";
import Image from "next/image";

interface SongItemProps {
  id: string;
  title: string;
  title_short: string;
  duration: string;
  preview: string;
  md5_image: string | null;
  artist: string;
  artistImage: string;
  genres: string;
  isSelected: boolean;
  isFavorite: boolean;
  onFavoriteToggle: () => void;
  onPlay: () => void;
}

const SongItem: React.FC<SongItemProps> = ({
  title,
  genres,
  artistImage,
  duration,
  isSelected,
  isFavorite,
  onFavoriteToggle,
  onPlay,
}) => {
  const defaultImage = "URL_DE_IMAGEN_DEFAULT";

  return (
    <div
      onClick={onPlay}
      className={`
        mb-2 px-4 py-3
        transition-colors cursor-pointer
        ${isSelected ? "border-2 border-primary bg-black" : "bg-black"}
        rounded-xl
      `}
    >
      <div className="grid grid-cols-[48px_40px_1fr_auto] sm:grid-cols-[78px_100px_2fr_180px_100px] items-center gap-2">
        <div className="h-12 w-12 rounded overflow-hidden relative">
          <Image
            src={artistImage || defaultImage}
            alt="Album art"
            className="object-cover rounded-md"
            width={150}
            height={150}
            decoding="async"
          />
        </div>

        <div className="flex justify-center">
          <Heart
            className={`w-5 h-5 cursor-pointer transition-colors
              ${
                isFavorite
                  ? "text-primary fill-primary"
                  : "text-primary/60 hover:text-primary"
              }
            `}
            onClick={(e) => {
              e.stopPropagation();
              onFavoriteToggle();
            }}
          />
        </div>

        <div className="min-w-0">
          <div className="text-white text-sm sm:text-lg font-bold truncate">
            {title}
          </div>
          <div className="block sm:hidden text-white text-xs font-medium truncate">
            {genres}
          </div>
        </div>

        <div className="hidden sm:block text-white font-bold text-lg truncate">
          {genres}
        </div>

        <div className="text-white font-bold text-right text-sm sm:text-lg">
          {duration}
        </div>
      </div>
    </div>
  );
};

export default SongItem;
