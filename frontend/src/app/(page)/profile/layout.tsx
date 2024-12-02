"use client";

import React, { ReactNode } from "react";

interface ProfileLayoutProps {
  children: ReactNode;
}

const ProfileLayout: React.FC<ProfileLayoutProps> = ({ children }) => {
  return (
    <>
      <div
        className="min-h-screen bg-cover bg-top bg-no-repeat"
        style={{ backgroundImage: "url('/bg-5.jpg')" }}
      >
        <div className="bg-black bg-opacity-40 min-h-screen">
          {children}
        </div>
      </div>
    </>
  );
};

export default ProfileLayout;