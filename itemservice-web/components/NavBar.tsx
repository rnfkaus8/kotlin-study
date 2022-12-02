import Link from 'next/link';
import React from 'react';

const NavBar: React.FC = () => (
  <nav>
    <Link href="/">Home</Link>
    <Link href="/about">About</Link>
  </nav>
);

export default NavBar;
