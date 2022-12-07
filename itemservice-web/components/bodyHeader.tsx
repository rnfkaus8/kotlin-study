import Link from 'next/link';
import React from 'react';

const BodyHeader = () => {
  return (
    <div className="header">
      <ul>
        <li>
          <Link href="/">Home</Link>
        </li>
      </ul>
      <Link href="/">
        <h3 className="text-muted">HELLO SHOP</h3>
      </Link>
    </div>
  );
};

export default BodyHeader;
