export interface LoginRequestDto {
  email: string;
  password: string;
}

export interface AuthResponseDto {
  id: number;
  username: string;
  token: string;
}

export const loginUser = async (credentials: LoginRequestDto): Promise<AuthResponseDto | null> => {
  try {
   // console.log("Iniciando solicitud de inicio de sesión con:", credentials);
    const response = await fetch("/api/auth/login", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(credentials),
    });
    //console.log("Respuesta completa:", response);
    //console.log("Estado de la respuesta:", response.status);

    const result = await response.json();
    //console.log("Datos de la respuesta completa:", result);

    if (!response.ok || result.isError) {
      // console.error("Error en la respuesta:", result);
      throw new Error(result.message || "Error al iniciar sesión");
    }

    // Extract user data from the nested data property
    const userData: AuthResponseDto = {
      id: result.data.id,
      username: result.data.username,
      token: result.data.token
    };

    //console.log("Datos del usuario procesados:", userData);
    return userData;
  } catch (error: any) {
    console.error("Error al iniciar sesión:", error.message);
    return null;
  }
};