const registerUrl = `${process.env.NEXT_PUBLIC_API_URL}/auth/register`;
import { RegisterFormValues } from "../components/RegisterModal";

export interface AuthResponse {
    token: string;
    user: {
        id: string;
        username: string;
    };
}

export const registerUser = async (formData: RegisterFormValues): Promise<AuthResponse | null> => {
    try {
        const response = await fetch(registerUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData),
        });

        if (!response.ok) {
            const error = await response.json();
            throw new Error(error.message || 'Error al registrar el usuario');
        }

        const data: AuthResponse = await response.json();
        return data;
    } catch (error) {
        console.error('Error al registrar el usuario:', error);
        return null;
    }
};
