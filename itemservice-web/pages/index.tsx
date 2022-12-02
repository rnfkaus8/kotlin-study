import React, { useState } from 'react';

const Home: React.FC = () => {
  const [counter, setCounter] = useState(0);
  return (
    <div>
      <h1>hello {counter}</h1>
      <button
        onClick={() => {
          setCounter((prevState) => prevState + 1);
        }}
      >
        +
      </button>
    </div>
  );
};

export default Home;
