"use client";

import { Button, buttonVariants } from "@/components/ui/button";
import React from "react";

const HomePage = () => {
    return (
        <>
            <h1 className="text-3xl text-center">Probando... HOME</h1>
            <Button className={buttonVariants({ variant: 'ghost' })}>Testing button</Button >
        </>
    );
};

export default HomePage;
