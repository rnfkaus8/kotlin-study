import React from 'react';
import { AppProps } from 'next/app';
import BodyHeader from '../components/bodyHeader';
import Footer from '../components/footer';
import 'antd/dist/reset.css';

import './styles.css';

const App = ({ Component, pageProps }: AppProps) => {
  return (
    <div
      style={{ justifyContent: 'center', maxWidth: '720px', margin: 'auto' }}
    >
      <BodyHeader />
      <div
        style={{
          display: 'flex',
        }}
      >
        <Component {...pageProps} />
      </div>
      <Footer />
    </div>
  );
};

export default App;
