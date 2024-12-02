import React from 'react'

const Politics = () => {
    return (
        <article className='flex flex-col text-left text-white w-full md:w-5/6 mx-auto py-4 p-2'>
            <div className='font-bold px-2 py-6'>
                <h2 className='text-xl lg:text-3xl text-center pb-4'>Políticas de privacidad</h2>
                <h3 className='text-base lg:text-xl'>
                    En Soundbit, nos tomamos muy en serio tu privacidad y nos comprometemos a proteger tus datos personales. A continuación, detallamos cómo recopilamos, usamos y protegemos tu información:
                </h3>
            </div>
            <div className='flex flex-col gap-4 bg-black text-base md:text-xl rounded-3xl opacity-90 p-8'>
                <div>
                    <h2 className='text-primary font-bold text-xl lg:text-2xl'>Información que Recopilamos</h2>
                    <p className='mb-4'>Cuando utilizas nuestra plataforma, podemos recopilar los siguientes tipos de información:</p>
                    <ul className='list-disc pl-6 p-4'>
                        <li><strong>Datos de registro:</strong> Como tu nombre, dirección de correo electrónico y contraseña al crear una cuenta.</li>
                        <li><strong>Datos de uso:</strong> Información sobre cómo interactúas con nuestra plataforma, como tus preferencias musicales, listas de reproducción y tiempo de uso.</li>
                        <li><strong>Datos técnicos:</strong> Información sobre tu dispositivo, dirección IP y configuración del navegador.</li>
                        <li><strong>Datos de pago:</strong> Información necesaria para procesar transacciones en caso de suscripciones o compras.</li>
                    </ul>
                </div>
                <div>
                    <h2 className='text-primary font-bold text-xl lg:text-2xl'>Cómo Usamos Tu Información</h2>
                    <p className='mb-4'>Usamos tu información para:</p>
                    <ul className='list-disc pl-6 p-4'>
                        <li>Proporcionarte acceso a nuestras funcionalidades y personalizar tu experiencia musical.</li>
                        <li>Mejorar y optimizar nuestra plataforma mediante análisis de datos de uso.</li>
                        <li>Comunicarnos contigo sobre actualizaciones, promociones y notificaciones relacionadas con tu cuenta.</li>
                        <li>Procesar pagos y gestionar suscripciones.</li>
                    </ul>
                </div>
                <div>
                    <h2 className='text-primary font-bold text-xl lg:text-2xl'>Cómo Protegemos Tu Información</h2>
                    <p className='mb-4'>Utilizamos cifrado y medidas de seguridad avanzadas para proteger tus datos personales.</p>
                    <ul className='list-disc pl-6 p-4'>
                        <li>Solo compartimos tu información con terceros de confianza para fines estrictamente necesarios, como procesamiento de pagos o análisis técnicos.</li>
                        <li>Nunca vendemos tu información a terceros con fines de marketing.</li>
                    </ul>
                </div>
                <div>
                    <h2 className='text-primary font-bold text-xl lg:text-2xl'>Tus Derechos</h2>
                    <p className='mb-4'>Tienes el derecho de:</p>
                    <ul className='list-disc pl-6 p-4'>
                        <li>Acceder, corregir o eliminar tus datos personales.</li>
                        <li>Solicitar que no procesemos tus datos para ciertos fines, como marketing.</li>
                        <li>Retirar tu consentimiento en cualquier momento.</li>
                    </ul>
                    <p className='mt-2'>Para ejercer estos derechos, puedes contactarnos en: <a href="mailto:privacidad@soundbit.com" className='text-blue-400'>privacidad@soundbit.com</a></p>
                </div>
                <div>
                    <h2 className='text-primary font-bold text-xl lg:text-2xl'>Uso de Cookies</h2>
                    <p className='mb-4'>Utilizamos cookies y tecnologías similares para mejorar tu experiencia en Soundbit. Puedes gestionar tus preferencias de cookies desde la configuración de tu navegador.</p>
                </div>
                <div>
                    <h2 className='text-primary font-bold text-xl lg:text-2xl'>Cambios a Esta Política</h2>
                    <p className='mb-4'>Podemos actualizar esta política de privacidad de vez en cuando. Te notificaremos cualquier cambio significativo a través de nuestra plataforma o por correo electrónico.</p>
                </div>
                <div>
                    <p className='mt-4'>Si tienes alguna pregunta o inquietud sobre nuestras políticas de privacidad, no dudes en escribirnos a <a href="mailto:soporte@soundbit.com" className='text-blue-400'>soporte@soundbit.com</a>.</p>
                </div>
                <div className='mt-4'>
                    <p className='text-xl md:text-3xl text-primary font-bold text-center animate-pulse'>¡Gracias por confiar en Soundbit para llevar tu experiencia musical al siguiente nivel!</p>
                </div>
            </div>
        </article>
    )
}

export default Politics