import {
    Accordion,
    AccordionContent,
    AccordionItem,
    AccordionTrigger,
} from "@/components/ui/accordion"

import React from 'react'

const FaqPage = () => {
    return (
        <article className='flex flex-col text-left text-white w-full md:w-5/6 mx-auto py-4 px-2'>
            <div className="font-bold px-2 py-6">
                <h2 className='text-xl lg:text-3xl text-center font-bold pb-4'>Preguntas Frecuentes</h2>
            </div>
            <div className="flex flex-col gap-4 bg-black text-base md:text-xl rounded-3xl opacity-90 p-8">
                <Accordion type="single" collapsible>
                    <AccordionItem value="item-1">
                        <AccordionTrigger>¿Qué es Soundbit?</AccordionTrigger>
                        <AccordionContent>
                            Soundbit es un reproductor de música 8D que ofrece
                            una experiencia sonora envolvente. Nuestro formato
                            8D crea la sensación de que el sonido se mueve a tu
                            alrededor, sumergiéndote completamente en la música.
                        </AccordionContent>
                    </AccordionItem>

                    <AccordionItem value="item-2">
                        <AccordionTrigger>
                            ¿Qué necesito para usar Soundbit?
                        </AccordionTrigger>
                        <AccordionContent>
                            Para disfrutar de Soundbit, necesitas: <br />
                            <strong>Auriculares:</strong> El formato 8D está
                            diseñado para usarse exclusivamente con auriculares,
                            lo que garantiza el efecto envolvente.
                        </AccordionContent>
                    </AccordionItem>

                    <AccordionItem value="item-3">
                        <AccordionTrigger>
                            ¿Cómo funciona el sonido 8D?
                        </AccordionTrigger>
                        <AccordionContent>
                            El sonido 8D utiliza técnicas avanzadas de
                            ingeniería de audio para simular un espacio
                            tridimensional. Al escuchar con auriculares, los
                            sonidos parecen moverse a tu alrededor, creando una
                            experiencia inmersiva única.
                        </AccordionContent>
                    </AccordionItem>

                    <AccordionItem value="item-4">
                        <AccordionTrigger>
                            ¿Dónde está disponible Soundbit?
                        </AccordionTrigger>
                        <AccordionContent>
                            Soundbit está disponible a través de nuestra
                            aplicación para dispositivos móviles (iOS y
                            Android) y nuestra versión web.
                        </AccordionContent>
                    </AccordionItem>

                    <AccordionItem value="item-5">
                        <AccordionTrigger>
                            ¿Soundbit funciona con todos los tipos de
                            auriculares?
                        </AccordionTrigger>
                        <AccordionContent>
                            Sí, puedes usar cualquier auricular para disfrutar
                            del sonido 8D. Sin embargo, recomendamos auriculares
                            de buena calidad para obtener la mejor experiencia
                            sonora.
                        </AccordionContent>
                    </AccordionItem>

                    <AccordionItem value="item-6">
                        <AccordionTrigger>
                            ¿Cómo contacto al equipo de soporte?
                        </AccordionTrigger>
                        <AccordionContent>
                            Si tienes dudas o necesitas ayuda, puedes
                            escribirnos a{" "}
                            <a
                                href="mailto:soporte@soundbit.com"
                                className="underline text-blue-400"
                            >
                                soporte@soundbit.com
                            </a>
                        </AccordionContent>
                    </AccordionItem>

                    <AccordionItem value="item-7">
                        <AccordionTrigger>¿Tienes otra pregunta?</AccordionTrigger>
                        <AccordionContent>
                            ¡Estamos aquí para ayudarte!
                        </AccordionContent>
                    </AccordionItem>
                </Accordion>
            </div>
        </article>
    )
}

export default FaqPage