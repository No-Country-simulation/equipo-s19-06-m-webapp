"use client";

import { useState } from "react";
import Image from "next/image";
import { Eye } from "lucide-react";
import { EyeOff } from "lucide-react";
import SettingsForm from "@/app/(page)/settings/components/settingsForm";

const Settings = () => {
  const [clicked, setClicked] = useState(false);
  const handleClick = () => {
    setClicked(!clicked);
  };
  return (
    <div className="flex flex-col justify-evenly w-full min-h-screen md:w-5/6 mx-auto py-4 p-2">
      <section className="flex flex-col md:flex-row items-center text-white text-xl">
        <div className="w-90 md:w-36 lg:w-48 xl:w-64 text-center">
          <Image
            src="/avatar.jpg"
            alt="avatar"
            width={834}
            height={227}
            className="object-contain w-full h-auto rounded-full border-4 border-primary"
          />
          <h3 className="m-2 font-bold">
          Christian
          </h3>
        </div>
        <div className="w-90 md:w-36 lg:w-48 xl:w-64 text-left mx-10">
          <h3 className="m-2">
            <span className="font-bold">Email:</span> user@gmail.com
          </h3>
          <div className="flex items-center">
            <h3 className="m-2">
              <span className="font-bold">Contraseña:</span> { clicked ? "1234" : "******" }
            </h3>
            <div onClick={handleClick}>
              { clicked ? <EyeOff /> : <Eye /> }
            </div>
          </div>
        </div>
      </section>
      <section>
        <SettingsForm />
      </section>
    </div>
  );
};

export default Settings;