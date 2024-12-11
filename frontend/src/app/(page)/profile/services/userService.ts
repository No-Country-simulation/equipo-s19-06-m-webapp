export interface ApiResponse {
    id: number;
    username: string;
    email: string;
    contact: string;
    userImage: string;
    role: string;
    isActive: boolean;
};

export const getUser = async (): Promise<ApiResponse | null> => {
    try {
        const token = localStorage.getItem("token");
        if (!token) {
            throw new Error("No existe el token de autenticación");
        };
        const userId = localStorage.getItem("userId");
        if (!userId) {
            throw new Error("No se encontró el ID del usuario");
        };
        const response = await fetch(`http://144.33.15.219:8080/user/${userId}`, {
            method: "GET",
            headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json"
            }
        });
        if (!response.ok) {
            const errorData = await response.json();
            console.error("Error en la respuesta:", errorData);
            throw new Error(errorData.message || "Error al obtener los datos del usuario");
        };
        const result: ApiResponse = await response.json();
        console.log("Usuario obtenido:", result); 
        return result;
    } catch (error: any) {
        console.error("Error al obtener los datos del usuario:", error.message);
        return null;
    };
};