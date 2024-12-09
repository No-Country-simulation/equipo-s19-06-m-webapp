"use client";

import { Button } from "@/components/ui/button";
import Link from "next/link";
import React from "react";

const HomePage = () => {
    return (
        <>
            <article className='flex flex-col w-full justify-between items-center min-h-screen text-white text-xl lg:text-3xl text-center font-bold px-4 py-12'>
                <div>
                    <h2>Explora el Sonido en 8D: Música que te envuelve</h2>
                </div>
                <div>
                    <h3>Siente cada nota, cada ritmo y cada vibración a tu alrededor.</h3>
                    <h3>Descubre una experiencia musical inmersiva como nunca antes. </h3>
                </div>
                <div>
                    <Link href='/explore'>
                        <Button>Explorar</Button>
                    </Link>
                </div>
                <div>
                    <h3>No solo escuches la música, vívela en 8D.</h3>
                </div>
            </article>
        </>
    );
};

export default HomePage;
