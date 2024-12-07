"use client";
import GenreButtons from "@/components/ui/GenroButtons";
import SearchBar from "@/components/ui/SearchBar";
import SongList from "@/app/(page)/explore/components/SongList";
import { useState } from "react";

export default function ExplorePage() {
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedGenre, setSelectedGenre] = useState("Todos");

  const handleSearchChange = (term: string) => {
    setSearchTerm(term);
  };

  const handleGenreChange = (genre: string) => {
    setSelectedGenre(genre);
  };

  return (
    <div className="container mx-auto px-4 py-12 max-w-[1300px]">
      <h1 className="text-4xl font-bold mb-12 text-center text-white">
        Explorar
      </h1>
      <div className="flex flex-col md:flex-row gap-6">
        {/* Pantallas grandes*/}
        <div className="hidden md:flex gap-6 w-full">
          <div className="md:w-1/4">
            <div className="flex flex-wrap gap-2 justify-center md:justify-start">
              <GenreButtons
                onGenreChange={handleGenreChange}
                selectedGenre={selectedGenre}
              />
            </div>
          </div>
          <div className="md:w-3/4">
            <div className="mb-6">
              <SearchBar onSearchChange={handleSearchChange} />
            </div>
            <div className="mt-10">
              <SongList searchTerm={searchTerm} selectedGenre={selectedGenre} />
            </div>
          </div>
        </div>
        {/* Mobile*/}
        <div className="flex flex-col gap-6 md:hidden">
          <div className="mb-6">
            <SearchBar onSearchChange={handleSearchChange} />
          </div>
          <div className="flex flex-wrap gap-2 justify-center">
            <GenreButtons
              onGenreChange={handleGenreChange}
              selectedGenre={selectedGenre}
            />
          </div>
          <div className="mt-10">
            <SongList searchTerm={searchTerm} selectedGenre={selectedGenre} />
          </div>
        </div>
      </div>
    </div>
  );
}
