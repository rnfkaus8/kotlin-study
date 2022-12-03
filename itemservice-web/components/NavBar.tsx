import Link from 'next/link';
import React from 'react';
import { useRouter } from 'next/router';

const NavBar: React.FC = () => {
  const router = useRouter();
  return (
    <nav>
      <Link style={{ color: router.pathname === '/' ? 'red' : 'blue' }} className="hi" href="/">Home</Link>
      <Link style={{ color: router.pathname === '/about' ? 'red' : 'blue' }} href="/about">About</Link>
    </nav>
  );
};

export default NavBar;
