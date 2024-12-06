import Link from "next/link";
import { usePathname } from "next/navigation";
import { ProfileLink } from "@/types/ui/Profile";
import { Button } from "@/components/ui/button";

const settingsLinks: ProfileLink[] = [
  { label: "Guardar", href: "/profile" },
  { label: "Cancelar", href: "/profile" }
];

const Input = () => {
  const pathname = usePathname();
  return (
    <>
      <form className="flex flex-col lg:flex-row justify-center items-center text-white text-xl font-bold w-90 my-4 mt-4">
        <div className="flex flex-col m-2">
          <label htmlFor="name">Nombre:</label>
          <input type="text" id="name" className="border-2 border-primary rounded-full focus:outline-none focus:ring-2 text-black text-base my-3 p-2" />
        </div>
        <div className="flex flex-col m-2">
          <label htmlFor="email">Email:</label>
          <input type="email" id="email" className="border-2 border-primary rounded-full focus:outline-none focus:ring-2 text-black text-base my-3 p-2" />
        </div>
        <div className="flex flex-col m-2">
          <label htmlFor="password">Contraseña:</label>
          <input type="password" id="password" className="border-2 border-primary rounded-full focus:outline-none focus:ring-2 text-black text-base my-3 p-2" />
        </div>
      </form>
      <div className="flex flex-col md:flex-row justify-center items-center my-4">
        {settingsLinks.map(({ label, href }) => (
          <Link
            key={label}
            href={href}
            className={`text-lg transition-colors m-2 ${
              pathname === href
              ? "text-primary"
              : "text-white hover:text-primary"
            }`}
          >
            <Button>{label}</Button>
          </Link>
        ))}
      </div>
    </>
  );
};

export default Input;