"use client";

import Link from "next/link";
import Image from "next/image";
import { FooterLink } from "@/types/ui/Footer";

const footerLinks: FooterLink[] = [
  { label: "Sobre nosotros", href: "/sobre-nosotros" },
  { label: "Política de privacidad", href: "/privacidad" },
  { label: "Preguntas frecuentes", href: "/faq" },
];

const Footer = () => {
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
            <div className="w-32 sm:w-36 lg:w-48">
              <Image
                src="/logo1.png"
                alt="Logo Soundbit"
                layout="responsive"
                width={0}
                height={0}
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
              className="text-lg text-white hover:text-primary transition-colors"
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