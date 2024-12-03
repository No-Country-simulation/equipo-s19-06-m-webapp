"use client";

import React, { ReactNode } from "react";

interface FaqLayoutProps {
    children: ReactNode;
}

const FaqLayout: React.FC<FaqLayoutProps> = ({ children }) => {
    return (
        <>
            <div
                className="min-h-screen bg-cover bg-top bg-no-repeat"
                style={{ backgroundImage: "url('/bg-6.jpg')" }}
            >
                <div className="bg-black bg-opacity-40 min-h-screen">
                    {children}
                </div>
            </div>
        </>
    );
};

export default FaqLayout;
