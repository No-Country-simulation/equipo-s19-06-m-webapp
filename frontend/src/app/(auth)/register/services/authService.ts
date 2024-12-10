import { RegisterFormValues } from "../components/RegisterModal";

export interface RegisterForm {
    username: string;
    email: string;
    contact: string;
    password: string;
};

export interface ApiResponse {
    success: boolean;
    message: string;
};

export const registerUser = async (formData: RegisterFormValues): Promise<ApiResponse> => {
    try {
        const response = await fetch("http://144.33.15.219:8080/swagger-ui/index.html#/auth/register", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        });
        if (!response.ok) {
            console.error('Error al registrar el usuario');
        }
        const result: ApiResponse = await response.json();
        console.log(result);
        return result;
    } catch (error: any) {
        console.error('Error al registrar el usuario:', error);
        return { success: false, message: 'Error al registrar el usuario' };
    };
};
