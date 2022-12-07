import React from 'react';
import { AppProps } from 'next/app';
import BodyHeader from '../components/bodyHeader';
import Footer from '../components/footer';

import './styles.css';

const App = ({ Component, pageProps }: AppProps) => {
  return (
    <div className="container">
      <BodyHeader />
      <Component {...pageProps} />
      <Footer />
    </div>
  );
};

export default App;
