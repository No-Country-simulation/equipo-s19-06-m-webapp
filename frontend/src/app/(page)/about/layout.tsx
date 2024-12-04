"use client";

import React, { ReactNode } from "react";

interface AboutLayoutProps {
    children: ReactNode;
}

const AboutLayout: React.FC<AboutLayoutProps> = ({ children }) => {
    return (
        <>
            <div
                className="min-h-screen bg-cover bg-top bg-no-repeat"
                style={{ backgroundImage: "url('/bg-2.jpg')" }}
            >
                <div className="bg-black bg-opacity-50 min-h-screen">
                    {children}
                </div>
            </div>
        </>
    );
};

export default AboutLayout;
