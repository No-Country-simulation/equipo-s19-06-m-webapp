'use client';

import { usePathname } from 'next/navigation';
import Link from 'next/link';
import React from 'react';

interface ActiveNavLinkProps {
    href: string;
    children: React.ReactNode;
    activeClassName: string;
    className?: string;
}

const ActiveNavLink: React.FC<ActiveNavLinkProps> = ({ href, children, activeClassName, className = '' }) => {
    const pathname = usePathname();
    const isActive = pathname === href;

    return (
        <Link
            href={href}
            className={`${className} ${isActive ? activeClassName : ''}`}
        >
            {children}
        </Link>
    );
};

export default ActiveNavLink;
