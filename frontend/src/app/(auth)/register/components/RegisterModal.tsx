"use client";

import { useState } from "react";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { z } from "zod";
import { Dialog, DialogContent, DialogHeader, DialogTitle } from "@/components/ui/dialog";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { Label } from "@/components/ui/label";
import { Eye, EyeOff } from "lucide-react";

const registerSchema = z
    .object({
        username: z.string().min(3, "El nombre debe tener al menos 3 caracteres"),
        email: z.string().email("Ingresa un correo válido"),
        password: z.string().min(6, "La contraseña debe tener al menos 6 caracteres"),
        confirmPassword: z.string(),
    })
    .refine((data) => data.password === data.confirmPassword, {
        message: "Las contraseñas no coinciden",
        path: ["confirmPassword"],
    });

type RegisterFormValues = z.infer<typeof registerSchema>;

interface RegisterModalProps {
    onClose: () => void;
}

const RegisterModal: React.FC<RegisterModalProps> = ({ onClose }) => {
    const [showPassword, setShowPassword] = useState(false);
    const [showConfirmPassword, setShowConfirmPassword] = useState(false);

    const {
        register,
        handleSubmit,
        formState: { errors },
    } = useForm<RegisterFormValues>({
        resolver: zodResolver(registerSchema),
    });

    const onSubmit = (data: RegisterFormValues) => {
        console.log("Datos del registro:", data);
        onClose();
    };

    return (
        <Dialog open onOpenChange={onClose}>
            <DialogContent className="bg-black border border-cyan-500 text-white">
                <DialogHeader>
                    <DialogTitle>
                        <div className="w-32 mx-auto">
                            <img
                                src="/logo.png"
                                alt="Logo Soundbit"
                                className="object-contain w-full h-auto"
                            />
                        </div>
                    </DialogTitle>
                </DialogHeader>
                <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
                    {/* Campo de nombre de usuario */}
                    <div className="space-y-1">
                        <Label htmlFor="username" className="text-primary text-xl">
                            Nombre de usuario:
                        </Label>
                        <Input
                            id="username"
                            type="text"
                            {...register("username")}
                            aria-invalid={!!errors.username}
                        />
                        {errors.username && (
                            <p className="text-red-500 text-xl">{errors.username.message}</p>
                        )}
                    </div>

                    {/* Campo de correo */}
                    <div className="space-y-1">
                        <Label htmlFor="email" className="text-primary text-xl">
                            Mail:
                        </Label>
                        <Input
                            id="email"
                            type="email"
                            {...register("email")}
                            aria-invalid={!!errors.email}
                        />
                        {errors.email && (
                            <p className="text-red-500 text-xl">{errors.email.message}</p>
                        )}
                    </div>

                    {/* Campo de contraseña */}
                    <div className="space-y-1 relative">
                        <Label htmlFor="password" className="text-primary text-xl">
                            Contraseña:
                        </Label>
                        <div className="relative">
                            <Input
                                id="password"
                                type={showPassword ? "text" : "password"}
                                {...register("password")}
                                aria-invalid={!!errors.password}
                                className="pr-10"
                            />
                            <button
                                type="button"
                                onClick={() => setShowPassword(!showPassword)}
                                className="absolute inset-y-0 right-2 flex items-center text-black hover:text-primary"
                            >
                                {showPassword ? <EyeOff size={20} /> : <Eye size={20} />}
                            </button>
                        </div>
                        {errors.password && (
                            <p className="text-red-500 text-xl">{errors.password.message}</p>
                        )}
                    </div>

                    {/* Campo de confirmación de contraseña */}
                    <div className="space-y-1 relative">
                        <Label htmlFor="confirmPassword" className="text-primary text-xl">
                            Confirmar Contraseña:
                        </Label>
                        <div className="relative">
                            <Input
                                id="confirmPassword"
                                type={showConfirmPassword ? "text" : "password"}
                                {...register("confirmPassword")}
                                aria-invalid={!!errors.confirmPassword}
                                className="pr-10"
                            />
                            <button
                                type="button"
                                onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                                className="absolute inset-y-0 right-2 flex items-center text-black hover:text-primary"
                            >
                                {showConfirmPassword ? <EyeOff size={20} /> : <Eye size={20} />}
                            </button>
                        </div>
                        {errors.confirmPassword && (
                            <p className="text-red-500 text-xl">{errors.confirmPassword.message}</p>
                        )}
                    </div>

                    <Button type="submit" className="w-full">
                        Registrarse
                    </Button>
                </form>
            </DialogContent>
        </Dialog>
    );
};

export default RegisterModal;
