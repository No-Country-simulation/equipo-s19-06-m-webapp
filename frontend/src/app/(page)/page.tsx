"use client";

import { Button, buttonVariants } from "@/components/ui/button";
import React from "react";

const HomePage = () => {
    return (
        <>
            <article className='flex flex-col w-full justify-between items-center min-h-screen text-white text-3xl font-bold px-4 py-12'>
                <div>
                    <h2>Explora el Sonido en 8D: Música que te envuelve</h2>
                </div>
                <div>
                    <h3>Siente cada nota, cada ritmo y cada vibración a tu alrededor.</h3>
                    <h3>Descubre una experiencia musical inmersiva como nunca antes. </h3>
                </div>
                <div>
                    <Button>Explorar</Button>
                </div>
                <div>
                    <h3>No solo escuches la música, vívela en 8D.</h3>
                </div>
            </article>
        </>
    );
};

export default HomePage;
