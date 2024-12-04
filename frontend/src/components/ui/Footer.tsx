"use client";

import Link from "next/link";
import Image from "next/image";
import { FooterLink } from "@/types/ui/Footer";
import { usePathname } from "next/navigation";

const footerLinks: FooterLink[] = [
  { label: "Sobre nosotros", href: "/about" },
  { label: "Política de privacidad", href: "/politics" },
  { label: "Preguntas frecuentes", href: "/faq" },
];

const Footer = () => {
  const pathname = usePathname();

  return (
    <footer className="bg-black text-white p-6">
      <div className="max-w-7xl mx-auto grid gap-4 grid-cols-1 md:grid-cols-3 md:gap-8 items-center">
        {/* Derechos reservados */}
        <div className="order-last md:order-none flex justify-center md:justify-start">
          <p className="text-sm md:text-xl text-center md:text-left">
            Derechos reservados @Soundbit
          </p>
        </div>

        {/* Logo */}
        <div className="flex justify-center order-first md:order-none">
          <Link href="/">
            <div className="w-40 sm:w-44 lg:w-56 ">
              <Image
                src="/logo.png"
                alt="Soundbit Logo"
                width={188}
                height={42}
                className="w-full"
              />
            </div>
          </Link>
        </div>

        {/* Links */}
        <nav className="flex flex-col items-center md:items-end md:gap-0 text-right">
          {footerLinks.map(({ label, href }) => (
            <Link
              key={label}
              href={href}
              className={`text-lg transition-colors ${pathname === href
                ? "text-primary"
                : "text-white hover:text-primary"
                }`}
            >
              {label}
            </Link>
          ))}
        </nav>
      </div>
    </footer>
  );
};

export default Footer;
