import React from 'react';

const MemberCreateForm = () => {
  return (
    <form action="/members/new" method="post">
      <label htmlFor="name">
        <input
          type="text"
          id="name"
          name="name"
          placeholder="이름을 입력하세요"
          required
        />
        이름
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
      <label htmlFor="zipcode">
        우편번호
        <input
          type="text"
          id="city"
          name="city"
          placeholder="우편번호를 입력하세요"
          required
        />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
};

export default MemberCreateForm;
