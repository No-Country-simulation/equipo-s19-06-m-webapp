"use client";

import { useState } from "react";
import Link from "next/link";
import Image from "next/image";
import { UserCircle, Menu, X } from "lucide-react";
import { NavLink } from "@/types/ui/Header";
import { usePathname } from "next/navigation";

const navLinks: NavLink[] = [
  { label: "Inicio", href: "/" },
  { label: "Explorar", href: "/explore" },
];

const Header = () => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const pathname = usePathname();

  const toggleMenu = () => {
    setIsMenuOpen((prev) => !prev);
  };

  return (
    <header className="bg-black p-4">
      <div className="max-w-7xl mx-auto flex items-center justify-between">
        <Link href="/">
          <div className="w-32 sm:w-36 lg:w-48 xl:w-64">
            <Image
              src="/logo.png"
              alt="Logo Soundbit"
              width={188}
              height={42}
              className="object-contain w-full h-auto"
            />
          </div>
        </Link>

        <nav className="hidden sm:flex items-center gap-8">
          {navLinks.map(({ label, href }) => (
            <Link
              key={label}
              href={href}
              className={`text-xl transition-colors ${
                pathname === href
                  ? "text-primary"
                  : "text-white hover:text-primary"
              }`}
            >
              {label}
            </Link>
          ))}
          <Link
            href="/profile"
            className={`text-3xl transition-colors ${
              pathname === "/profile"
                ? "text-primary"
                : "text-white hover:text-primary"
            }`}
          >
            <UserCircle className="w-8 h-8" />
          </Link>
        </nav>

        <button
          onClick={toggleMenu}
          className="sm:hidden text-white"
          aria-label="Toggle menu"
        >
          <Menu className="w-6 h-6" />
        </button>
      </div>

      {isMenuOpen && (
        <div className="fixed inset-0 z-50 sm:hidden bg-black animate-fade duration-300">
          <div className="flex flex-col h-full w-full p-4">
            <div className="flex justify-between items-center mb-8">
              <Link href="/">
                <div className="w-32 sm:w-36 lg:w-48 xl:w-64">
                  <Image
                    src="/logo.png"
                    alt="Logo Soundbit"
                    width={188}
                    height={42}
                    className="w-full h-auto"
                  />
                </div>
              </Link>
              <button
                onClick={toggleMenu}
                className="text-white"
                aria-label="Close menu"
              >
                <X className="w-6 h-6" />
              </button>
            </div>
            <nav className="flex flex-col h-full justify-center items-center gap-12 pb-8">
              {navLinks.map(({ label, href }) => (
                <Link
                  key={label}
                  href={href}
                  className={`text-2xl transition-colors ${
                    pathname === href
                      ? "text-primary"
                      : "text-white hover:text-primary"
                  }`}
                  onClick={toggleMenu}
                >
                  {label}
                </Link>
              ))}
              <Link
                href="/profile"
                className={`transition-colors ${
                  pathname === "/profile"
                    ? "text-primary"
                    : "text-white hover:text-primary"
                }`}
                onClick={toggleMenu}
              >
                <UserCircle className="w-12 h-12" />
              </Link>
            </nav>
          </div>
        </div>
      )}
    </header>
  );
};

export default Header;
