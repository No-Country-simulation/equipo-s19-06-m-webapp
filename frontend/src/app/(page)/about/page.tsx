import React from 'react'

const AboutPage = () => {
    return (
        <article className='flex flex-col text-left text-white w-full md:w-5/6 mx-auto py-4 p-2'>
            <div className='font-bold px-2 py-6'>
                <h2 className='text-xl lg:text-3xl text-center pb-4'> Sobre nosotros </h2>

                <h3 className='text-base lg:text-xl'>En Soundbit, llevamos la experiencia musical a una nueva dimensión. Somos más que un reproductor: somos una puerta al universo del sonido envolvente en 8D. Nuestra tecnología transforma cada canción en un viaje sensorial único, diseñado para que sientas la música como si estuvieras en el centro del escenario.
                </h3>
            </div>
            <div className='flex flex-col gap-4 bg-black text-base md:text-xl rounded-3xl opacity-90 p-8'>
                <div>
                    <h3 className='text-primary font-bold text-xl lg:text-2xl'>¿Cómo funciona?</h3>
                    <p> Para disfrutar de Soundbit, todo lo que necesitas son unos auriculares. Nuestro formato 8D está optimizado para sumergirte en un entorno sonoro inmersivo, haciendo que cada nota y cada ritmo se desplacen a tu alrededor con precisión y realismo.</p>
                </div>
                <div>
                    <h3 className='text-primary font-bold text-xl lg:text-2xl'>Nuestra Misión</h3>
                    <p>Revolucionar la forma en que las personas experimentan la música, creando momentos inolvidables a través de un sonido inmersivo y único.</p>
                </div>
                <div>
                    <h3 className='text-primary font-bold text-xl lg:text-2xl'>Nuestros Valores</h3>
                    <p>Estamos en constante evolución para ofrecerte las mejores experiencias auditivas. Cada canción en Soundbit es procesada para garantizar un sonido impecable. Queremos que todos puedan disfrutar del poder del 8D, sin importar dónde estén. Creemos en la capacidad de la música para unir a las personas y despertar emociones.</p>
                </div>
                <div className='mt-4'>
                    <p className='text-xl md:text-3xl text-primary font-bold text-center animate-pulse'>¡Únete a Soundbit y deja que la música te envuelva!</p>
                </div>
            </div>

        </article>
    )
}

export default AboutPage