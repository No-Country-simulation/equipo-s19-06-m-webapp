import { RegisterFormValues } from "../components/RegisterModal";

export interface ApiResponse {
    id: string;
    username: string;
    token: string;
};

export const registerUser = async (formData: Omit<RegisterFormValues, 'confirmPassword'>): Promise<ApiResponse | null> => {
    try {
        console.log("Datos enviados al backend:", formData);

        const response = await fetch("http://144.33.15.219:8080/auth/register", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData), 
        });

        console.log("Estado de la respuesta:", response.status); 
        if (!response.ok) {
            const errorData = await response.json();
            console.error("Error en la respuesta:", errorData);
            throw new Error(errorData.message || "Error al registrar el usuario");
        }

        const result: ApiResponse = await response.json();
        console.log("Respuesta procesada:", result); 
        return result;
    } catch (error: any) {
        console.error("Error al registrar el usuario:", error.message);
        return null;
    }
};

