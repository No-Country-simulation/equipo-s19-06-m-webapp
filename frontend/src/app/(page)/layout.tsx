"use client";

import React, { ReactNode } from "react";

interface HomeLayoutProps {
    children: ReactNode;
}

const HomeLayout: React.FC<HomeLayoutProps> = ({ children }) => {
    return (
        <>
            <div
                className="min-h-screen bg-cover bg-center bg-no-repeat"
                style={{ backgroundImage: "url('/bg-index.jpg')" }}
            >
                <div className="bg-black bg-opacity-50 min-h-screen">
                    {children}
                </div>
            </div>
        </>
    );
};

export default HomeLayout;
