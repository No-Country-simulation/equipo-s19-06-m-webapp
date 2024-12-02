"use client";

import { useState } from "react";
import Link from "next/link";
import { usePathname } from "next/navigation";
import Image from "next/image";
import { Button, buttonVariants } from "@/components/ui/button";
import { Eye } from "lucide-react";
import { EyeOff } from "lucide-react";

const Profile = () => {
  const pathname = usePathname();
  const [clicked, setClicked] = useState(false);
  const handleClick = () => {
    setClicked(!clicked);
  };
  return (
    <div className="flex flex-col justify-evenly w-full min-h-screen md:w-5/6 mx-auto py-4 p-2">
      <section className="flex items-center text-white">
        <div className="w-32 sm:w-36 lg:w-48 xl:w-64 text-center">
          <Image
            src="/avatar.jpg"
            alt="avatar"
            width={834}
            height={227}
            className="object-contain w-full h-auto rounded-full border-4 border-primary"
          />
          <h3 className="text-base lg:text-xl m-2 font-bold">
          Christian
          </h3>
        </div>
        <div className="w-32 sm:w-36 lg:w-48 xl:w-64 text-left mx-10">
          <h3 className="text-base lg:text-xl m-2">
            <span className="font-bold">Email:</span> user@gmail.com
          </h3>
          <div className="flex items-center">
            <h3 className="text-base lg:text-xl m-2">
              <span className="font-bold">Contraseña:</span> { clicked ? "1234" : "*****" }
            </h3>
            <div onClick={handleClick}>
              { clicked ? <EyeOff /> : <Eye /> }
            </div>
          </div>
        </div>
      </section>
      <section className="flex items-center justify-between">
        <Link
          key="settings"
          href="/settings"
          className={`text-lg transition-colors ${pathname === "/settings" ? "text-primary"
          : "text-white hover:text-primary"}`}>
            <Button>Editar perfil</Button>
        </Link>
        <Link
          key="library"
          href="/library"
          className={`text-lg transition-colors ${pathname === "/library" ? "text-primary"
          : "text-white hover:text-primary"}`}>
            <Button>Biblioteca</Button>
        </Link>
        <Button>Cerrar sesión</Button>
      </section>
    </div>
  );
};

export default Profile;