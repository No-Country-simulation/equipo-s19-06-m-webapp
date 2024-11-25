'use client';

import { useState } from 'react'
import Link from 'next/link'
import Image from 'next/image'
import { UserCircle, Menu, X } from 'lucide-react'
import { NavLink } from '@/types/ui/Header';

const navLinks: NavLink[] = [
    { label: "Inicio", href: "/" },
    { label: "Explorar", href: "/explorar" },
];

const Header = () => {
    const [isMenuOpen, setIsMenuOpen] = useState(false);

    const toggleMenu = () => {
        setIsMenuOpen((prev) => !prev);
    };

    return (
        <header className="bg-black p-4">
            <div className="max-w-7xl mx-auto flex items-center justify-between">
                <Link href="/">
                    <div className="w-32 sm:w-36 lg:w-48 xl:w-64">
                        <Image
                            src="/logo1.png"
                            alt="Logo Soundbit"
                            layout="responsive"
                            width={128}
                            height={128}
                        />
                    </div>
                </Link>


                <nav className="hidden sm:flex items-center gap-8">
                    {navLinks.map(({ label, href }) => (
                        <Link
                            key={label}
                            href={href}
                            className="text-white hover:text-primary transition-colors"
                        >
                            {label}
                        </Link>
                    ))}
                    <Link
                        href="/profile"
                        className="text-white hover:text-primary transition-colors"
                    >
                        <UserCircle className="w-6 h-6" />
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
                                        src="/logo1.png"
                                        alt="Logo Soundbit"
                                        layout="responsive"
                                        width={128}
                                        height={128}
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
                        <nav className="flex flex-col items-center gap-8">
                            {navLinks.map(({ label, href }) => (
                                <Link
                                    key={label}
                                    href={href}
                                    className="text-2xl text-white hover:text-primary transition-colors"
                                    onClick={toggleMenu}
                                >
                                    {label}
                                </Link>
                            ))}
                            <Link
                                href="/profile"
                                className="text-white hover:text-primary transition-colors"
                                onClick={toggleMenu}
                            >
                                <UserCircle className="w-8 h-8" />
                            </Link>
                        </nav>
                    </div>
                </div>
            )}
        </header>
    )
}

export default Header

