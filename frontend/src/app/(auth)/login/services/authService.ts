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
    console.log("Iniciando solicitud de inicio de sesión con:", credentials);
    console.log("Datos enviados al backend:", credentials);

    const response = await fetch("http://144.33.15.219:8080/auth/login", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(credentials),
    });

    console.log("Respuesta completa:", response);
    console.log("Estado de la respuesta:", response.status);
    if (!response.ok) {
      const errorData = await response.json();
      console.error("Error en la respuesta:", errorData);
      throw new Error(errorData.message || "Error al iniciar sesión");
    }

    const result: AuthResponseDto = await response.json();
    console.log("Datos de la respuesta procesada:", result);
    return result;
  } catch (error: any) {
    console.error("Error al iniciar sesión:", error.message);
    return null;
  }
};

