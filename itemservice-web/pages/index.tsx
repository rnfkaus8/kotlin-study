import React, { useState } from 'react';
import Link from 'next/link';

const Home: React.FC = () => {
  return (
    <div>
      <h1>Hello Shop</h1>
      <p>회원 기능</p>
      <p>
        <Link href="/members/new">회원 가입</Link>
        <Link href="/members">회원 목록</Link>
      </p>
      <p>상품 기능</p>
      <p>
        <Link href="/items/new">상품 등록</Link>
        <Link href="/items">상품 목록</Link>
      </p>
      <p>주문 기능</p>
      <p>
        <Link href="/order">상품 주문</Link>
        <Link href="/orders">주문 내역</Link>
      </p>
    </div>
  );
};

export default Home;
