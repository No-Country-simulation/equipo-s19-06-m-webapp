export const getUser = async (): Promise<{ username: string, email: string, userImage: string, contact: string } | null> => {
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
        }
        const result = await response.json();
        console.log("Usuario obtenido:", result);

        const { username, email, userImage, contact } = result.data;
        return { username, email, userImage, contact };
    } catch (error: any) {
        console.error("Error al obtener los datos del usuario:", error.message);
        return null;
    }
};
