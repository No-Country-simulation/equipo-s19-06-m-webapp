"use client";

import { useState, useEffect } from "react";
import Link from "next/link";
import { usePathname, useRouter } from "next/navigation";
import Image from "next/image";
// import { getUser } from "@/app/(page)/profile/services/userService";
import { Button } from "@/components/ui/button";
import { Eye } from "lucide-react";
import { EyeOff } from "lucide-react";

const Profile = () => {
  const pathname = usePathname();
  const router = useRouter();
  const [clicked, setClicked] = useState(false);
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const handleClick = () => {
    setClicked(!clicked);
  };
  const getUser = async () => {
    try {
      const token = localStorage.getItem("token");
      if (!token) {
        throw new Error("No existe el token de autenticación");
      }
      const userId = localStorage.getItem("userId");
      if (!userId) {
        throw new Error("No se encontró el ID del usuario");
      }
      const response = await fetch(`/api/user/${userId}`, {
        method: "GET",
        headers: {
          Authorization: `Bearer ${token}`,
          "Content-Type": "application/json",
        },
      });
      if (!response.ok) {
        const errorData = await response.json();
        console.error("Error en la respuesta:", errorData);
        throw new Error(
          errorData.message || "Error al obtener los datos del usuario"
        );
      };
      const data = await response.json();
      setUsername(data.username);
      setEmail(data.email);
      setPassword(data.password);
      console.log("Usuario obtenido:", data);
      return data;
    } catch (error) {
      //console.error("Error al obtener los datos del usuario:", error.message);
      return null;
    }
  };
  const handleLogout = () => {
    localStorage.removeItem("token");
    router.push("/");
    console.log("Sesión finalizada con éxito");
  };
  useEffect(() => {
    getUser();
  }, []);
  return (
    <div className="flex flex-col justify-evenly w-full min-h-screen md:w-5/6 mx-auto py-4 p-2">
      <section className="flex flex-col md:flex-row items-center text-white text-xl">
        <div className="w-90 md:w-36 lg:w-48 xl:w-64 text-center">
          <Image
            src="/profile.jpg"
            alt="avatar"
            width={834}
            height={227}
            className="object-contain w-full h-auto rounded-full border-4 border-primary"
          />
          <h3 className="m-2 font-bold">user.username</h3>
        </div>
        <div className="w-90 md:w-36 lg:w-48 xl:w-64 text-left mx-10">
          <h3 className="m-2">
            <span className="font-bold">Email:</span> user.email
          </h3>
          <div className="flex items-center">
            <h3 className="m-2">
              <span className="font-bold">Contraseña:</span>{" "}
              {clicked ? "user.password" : "******"}
            </h3>
            <div onClick={handleClick}>{clicked ? <EyeOff /> : <Eye />}</div>
          </div>
        </div>
      </section>
      <section className="flex flex-col md:flex-row items-center justify-center w-90">
        <Link
          key="Editar perfil"
          href="/settings"
          className={`text-lg transition-colors m-2 ${
            pathname === "/settings"
              ? "text-primary"
              : "text-white hover:text-primary"
          }`}
        >
          <Button>Editar perfil</Button>
        </Link>
        <Link
          key="Cerrar sesión"
          onCLick={handleLogout}
          className={`text-lg transition-colors m-2 ${
            pathname === "/profile"
              ? "text-primary"
              : "text-white hover:text-primary"
          }`}
        >
          <Button>Cerrar sesión</Button>
        </Link>
      </section>
    </div>
  );
};

export default Profile;
