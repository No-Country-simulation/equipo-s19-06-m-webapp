"use client";

interface GenreButtonsProps {
  onGenreChange: (genres: string) => void;
  selectedGenre: string;
}

const genres = [
  "Todos",
  "Electrónica",
  "Pop",
  "Rock",
  "Rap",
  "K-pop",
  "Clássica",
  "Dance",
];

export default function GenreButtons({
  onGenreChange,
  selectedGenre,
}: GenreButtonsProps) {
  return (
    <div className="flex flex-wrap gap-4 justify-center md:justify-start">
      {genres.map((genres) => (
        <button
          key={genres}
          onClick={() => onGenreChange(genres)}
          className={`
            w-[150px] h-[50px] md:w-[200px] md:h-[60px] rounded-full text-lg font-bold border-2
            transition-all duration-200
            ${
              selectedGenre === genres
                ? "bg-primary text-black border-black"
                : "bg-black text-primary border-primary hover:bg-primary hover:text-black hover:border-black"
            }
          `}
        >
          {genres}
        </button>
      ))}
    </div>
  );
}
