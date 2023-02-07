import React, { useState } from 'react';
import Link from 'next/link';

const Home: React.FC = () => {
  return (
    <div style={{ margin: 'auto' }}>
      <h1>Hello Shop</h1>
      <p>회원 기능</p>
      <p>
        <Link style={LinkStyle} href="/members/new">
          회원 가입
        </Link>
        <Link style={LinkStyle} href="/members">
          회원 목록
        </Link>
      </p>
      <p>상품 기능</p>
      <p>
        <Link style={LinkStyle} href="/items/new">
          상품 등록
        </Link>
        <Link style={LinkStyle} href="/items">
          상품 목록
        </Link>
      </p>
      <p>주문 기능</p>
      <p>
        <Link style={LinkStyle} href="/order">
          상품 주문
        </Link>
        <Link style={LinkStyle} href="/orders">
          주문 내역
        </Link>
      </p>
    </div>
  );
};

const LinkStyle = {
  marginLeft: 25,
};

export default Home;
