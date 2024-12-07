"use client";

import React, { ReactNode } from "react";

interface ExploreLayoutProps {
  children: ReactNode;
}

const ExploreLayout: React.FC<ExploreLayoutProps> = ({ children }) => {
  return (
    <div
      className="min-h-screen bg-cover bg-center bg-no-repeat"
      style={{ backgroundImage: "url('/bg-1.jpg')" }}
    >
      <div className="bg-black bg-opacity-70 min-h-screen">{children}</div>
    </div>
  );
};

export default ExploreLayout;
