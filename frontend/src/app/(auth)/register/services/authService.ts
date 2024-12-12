import { RegisterFormValues } from "../components/RegisterModal";

export interface ApiResponse {
    id: string;
    username: string;
    token: string;
};

export const registerUser = async (formData: Omit<RegisterFormValues, 'confirmPassword'>): Promise<ApiResponse | null> => {
    try {
        console.log("Datos enviados al backend:", formData);
        const response = await fetch("/api/auth/register", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData),
        });
        console.log("Estado de la respuesta:", response.status);

        const result = await response.json();
        console.log("Respuesta completa:", result);

        if (!response.ok || result.isError) {
            console.error("Error en la respuesta:", result);
            throw new Error(result.message || "Error al registrar el usuario");
        }

        const userData: ApiResponse = {
            id: result.data.id,
            username: result.data.username,
            token: result.data.token
        };

        console.log("Respuesta procesada:", userData);
        return userData;
    } catch (error: any) {
        console.error("Error al registrar el usuario:", error.message);
        return null;
    }
};