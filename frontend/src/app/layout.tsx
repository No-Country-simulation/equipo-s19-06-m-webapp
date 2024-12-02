import type { Metadata } from "next";
import { Roboto } from "next/font/google";
import "./globals.css";
import Header from "@/components/ui/Header";
import Footer from "@/components/ui/Footer";

export const metadata: Metadata = {
  title: "Soundbit",
  description: "Música, Reproductor de música, artistas, canciones, álbumes",
  icons: {
    icon: '/favicon.ico',
    shortcut: '/favicon.ico',
    apple: '/apple-touch-icon.png',
  },
};

const globalFont = Roboto({ subsets: ["latin"], weight: "400" });

interface RootLayoutProps {
  children: React.ReactNode;
}

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
}
