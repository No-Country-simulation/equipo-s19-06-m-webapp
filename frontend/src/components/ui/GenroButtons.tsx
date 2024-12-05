"use client";

interface GenreButtonsProps {
  onGenreChange: (genre: string) => void;
  selectedGenre: string;
}

const genres = [
  "Todos",
  "Electrónica",
  "Pop",
  "Rock",
  "Rap",
  "K-pop",
  "Clásica",
];

export default function GenreButtons({
  onGenreChange,
  selectedGenre,
}: GenreButtonsProps) {
  return (
    <div className="flex flex-wrap gap-4 justify-center md:justify-start">
      {genres.map((genre) => (
        <button
          key={genre}
          onClick={() => onGenreChange(genre)}
          className={`
            w-[150px] h-[50px] md:w-[200px] md:h-[60px] rounded-full text-lg font-bold border-2
            transition-all duration-200
            ${
              selectedGenre === genre
                ? "bg-primary text-black border-black"
                : "bg-black text-primary border-primary hover:bg-primary hover:text-black hover:border-black"
            }
          `}
        >
          {genre}
        </button>
      ))}
    </div>
  );
}
