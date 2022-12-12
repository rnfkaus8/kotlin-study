import React from 'react';

const MemberCreateForm = () => {
  return (
    <form action="http://localhost:8080/members/new" method="post">
      <label htmlFor="name">
        이름
        <input
          type="text"
          id="name"
          name="name"
          placeholder="이름을 입력하세요"
          required
        />
      </label>
      <label htmlFor="city">
        도시
        <input
          type="text"
          id="city"
          name="city"
          placeholder="도시를 입력하세요"
          required
        />
      </label>
      <label htmlFor="street">
        거리
        <input
          type="text"
          id="street"
          name="street"
          placeholder="거리를 입력하세요"
          required
        />
      </label>
      <label htmlFor="zipcode">
        우편번호
        <input
          type="text"
          id="zipcode"
          name="zipcode"
          placeholder="우편번호를 입력하세요"
          required
        />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
};

export default MemberCreateForm;
