import Link from 'next/link';
import React from 'react';
import { Layout } from 'antd';

const { Header } = Layout;

const BodyHeader = () => {
  return (
    <Layout>
      <Header>
        <div
          style={{
            float: 'left',
          }}
        >
          <Link href="/" style={{ color: 'white' }}>
            <h3 className="text-muted">HELLO SHOP</h3>
          </Link>
        </div>
      </Header>
    </Layout>
  );
};

export default BodyHeader;
