"use client";
import { Search } from "lucide-react";
import React, { useState } from "react";

interface SearchBarProps {
  onSearchChange?: (searchTerm: string) => void;
}

export default function SearchBar({ onSearchChange }: SearchBarProps) {
  const [searchTerm, setSearchTerm] = useState("");

  const handleSearchChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const value = e.target.value;
    setSearchTerm(value);
    onSearchChange?.(value);
  };

  return (
    <div className="relative w-full items-start">
      <input
        type="text"
        value={searchTerm}
        onChange={handleSearchChange}
        className="w-full px-4 py-3 pl-12 rounded-full
                 bg-[#2a2a2a] border-none
                 text-primary
                 focus:outline-none focus:ring-1 focus:ring-primary"
      />
      <Search
        className="absolute left-4 top-1/2 -translate-y-1/2 font-bold text-white"
        size={28}
      />
    </div>
  );
}
