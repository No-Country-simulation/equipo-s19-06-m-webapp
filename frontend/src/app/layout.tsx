import type { Metadata } from "next";
import { Roboto } from "next/font/google";
import "./globals.css";
import Header from "@/components/ui/Header";
import Footer from "@/components/ui/Footer";

export const metadata: Metadata = {
  title: "Soundbit",
  description: "Soundbit es un innovador reproductor de música 8D diseñado para sumergirte en una experiencia auditiva única. Disfruta de tus canciones favoritas con efectos de audio envolventes que te transportarán a un mundo de sonido en movimiento.",
  icons: {
    icon: "/favicon.ico",
    shortcut: "/favicon.ico",
    apple: "/favicon.ico"
  },
  openGraph: {
    title: "Soundbit",
    description: "Soundbit es un innovador reproductor de música 8D diseñado para sumergirte en una experiencia auditiva única. Disfruta de tus canciones favoritas con efectos de audio envolventes que te transportarán a un mundo de sonido en movimiento.",
    url: "https://soundbitmusic.vercel.app",
    images: [
      {
        url: ""
      }
    ]
  }
};

const globalFont = Roboto({ subsets: ["latin"], weight: "400" });

interface RootLayoutProps {
  children: React.ReactNode;
};

export default function RootLayout({ children }: RootLayoutProps) {
  return (
    <html lang="en" suppressHydrationWarning>
      <body
        className={`${globalFont.className} bg-primary flex flex-col min-h-screen`}
      >
        <Header />
        <main className="flex-grow w-full h-full">{children}</main>
        <Footer />
      </body>
    </html>
  );
};